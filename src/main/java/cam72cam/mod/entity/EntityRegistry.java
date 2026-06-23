package cam72cam.mod.entity;

import cam72cam.mod.UMC;
import cam72cam.mod.serialization.TagCompound;
import cam72cam.mod.text.IPlayerMessage;
import cam72cam.mod.world.World;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EntityRegistry {
    private static final Map<Class<? extends CustomEntity>, String> identifiers = new HashMap<>();
    private static final Map<String, Supplier<CustomEntity>> constructors = new HashMap<>();
    private static String missingResources;

    private EntityRegistry() {

    }

    public static void register(UMC.Mod mod, Supplier<CustomEntity> ctr, int distance) {
        CustomEntity tmp = ctr.get();
        Class<? extends CustomEntity> type = tmp.getClass();
    }

    public static Supplier<CustomEntity> getConstructor(String type) {
        return constructors.get(type);
    }

    protected static CustomEntity create(String type, ModdedEntity base) {
        return getConstructor(type).get().setup(base);
    }

    public static CustomEntity create(World world, Class<? extends Entity> cls) {
        //TODO null checks
        ModdedEntity ent = new ModdedEntity(world.internal);
        String id = identifiers.get(cls);
        ent.initSelf(id);
        return ent.getSelf();
    }


    public static void registerEvents() {
        CommonEvents.Entity.REGISTER.subscribe(() -> {
            net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(SeatEntity.ID, SeatEntity.class, SeatEntity.class.getSimpleName(), constructors.size()+1, UMC.instance, 512, 20, false);
        });

        CommonEvents.Entity.JOIN.subscribe((world, entity) -> {
            if (entity instanceof ModdedEntity) {
                if (World.get(world) != null) {
                    Pair<String, TagCompound> msg = ((ModdedEntity) entity).refusedToJoin;
                    if (msg != null) {
                        missingResources = msg.getKey();
                        return false;
                    }
                }
            }
            return true;
        });
    }


    @SideOnly(Side.CLIENT)
    public static void registerClientEvents() {
        ClientEvents.TICK.subscribe(() -> {
            if (missingResources != null && !Minecraft.getMinecraft().isSingleplayer() && Minecraft.getMinecraft().getConnection() != null) {
                UMC.error(missingResources);
                Minecraft.getMinecraft().getConnection().getNetworkManager().closeChannel(IPlayerMessage.direct(missingResources).internal);
                Minecraft.getMinecraft().loadWorld(null);
                Minecraft.getMinecraft().displayGuiScreen(new GuiDisconnected(new GuiMultiplayer(new GuiMainMenu()), "disconnect.lost", IPlayerMessage.direct(missingResources).internal));
                missingResources = null;
            }
        });
        CommonEvents.World.UNLOAD.subscribe(w -> {
            if (w.isRemote) {
                // Cleanup client side since mc does not call setDead client side...
                // See ClientEvents registration for related crap
                w.getEntities(ModdedEntity.class, e -> true).forEach(ModdedEntity::setDead);
            }
        });
    }
}
