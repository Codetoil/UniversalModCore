package cam72cam.mod.block.tile;

import cam72cam.mod.UMC;
import cam72cam.mod.block.BlockEntity;
import cam72cam.mod.energy.IEnergy;
import cam72cam.mod.fluid.ITank;
import cam72cam.mod.item.IInventory;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.registry.Registries;
import cam72cam.mod.resource.Identifier;
import cam72cam.mod.util.Facing;
import cam72cam.mod.serialization.TagCompound;
import cam72cam.mod.world.World;
import com.google.common.collect.HashBiMap;

import java.util.Map;
import java.util.function.Supplier;

/**
 * TileEntity is an internal class that should only be extended when you need to implement
 * an interface.
 *
 * If you need to create a standard tile entity and wound up here, take a look at BlockEntity instead.
 *
 * @see BlockEntity
 */
public abstract class TileEntity {
    static {
        UMC.getInstance().getRegistries().getTileEntityTypeRegistry()
                .register(TileEntity.class, new Identifier(UMC.MODID, "hack"));
    }

    // Set before initialization, used to lookup supplier
    private String instanceId;
    // Set during initialization
    private BlockEntity instance;

    // Cached
    private Vec3i umcPos;
    private World umcWorld;

    /**
     * Used only be Forge's reflection.
     * <ul>
     *     <li>Must be implemented in subclasses.</li>
     *     <li>Do not use directly.</li>
     * </ul>
     */
    public TileEntity() {
        super();
    }

    /**
     * Used only by BlockEntity to construct an instance to register.
     * <ul>
     *     <li>Must be implemented in subclasses.</li>
     *     <li>Do not use directly.</li>
     * </ul>
     *
     * @see BlockEntity
     * @param id Block Entity ID
     */
    public TileEntity(Identifier id) {
        this();
        instanceId = id.toString();
    }

    /** Wrap getPos() in a cached UMC Vec3i */
    public Vec3i getUMCPos() {
        if (umcPos == null || !umcPos.internal().equals(pos)) {
            umcPos = new Vec3i(pos);
        }
        return umcPos;
    }

    /** Wrap getWorld in cached UMC World */
    public World getUMCWorld();

    /*
    New Functionality
    */

    /** @return If the BlockEntity instance is loaded */
    public boolean isLoaded() {
        return instance() != null;
    }

    /** @return The instance of the BlockEntity if possible */
    public BlockEntity instance() {
        return instance(null);
    }

    /**
     * So this is a fun one...<br>
     * <br>
     * First we require the world object to have been set.  Without that we can't do much at all.<br>
     * Secondly we need to see if we are on the client or server.  Server side is easy, if a TE has been created
     * server side, it's no problem to load the instance as there's no waiting for packets.  Client side is a bit more
     * interesting.  There's a few paths into it, but the idea is that we can only load the TE once the client has
     * received a copy of the tile data from the server.<br>
     *<br>
     * If there are bugs in loading / synchronizing / faking TE's look here first...
     *
     * @param data
     * @return The instance of the BlockEntity if possible
     */
    protected abstract BlockEntity instance(TagCompound data);

    /* Capabilities */

    public IInventory getInventory(Facing side) {
        return instance() != null ? instance().getInventory(side) : null;
    }

    public ITank getTank(Facing side) {
        return instance() != null ? instance().getTank(side) : null;
    }

    public IEnergy getEnergy(Facing side) {
        return instance() != null ? instance().getEnergy(side) : null;
    }
}
