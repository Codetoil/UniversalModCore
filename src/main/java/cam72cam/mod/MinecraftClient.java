package cam72cam.mod;

import cam72cam.mod.entity.Entity;
import cam72cam.mod.entity.Player;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;

/** Static Minecraft Client props, don't touch server side */
public interface MinecraftClient {
    /** Minecraft is loaded and has a loaded world */
    boolean isReady();
    /** Hey, it's you! */
    Player getPlayer();

    /** Hooks into the GUI profiler */
    void startProfiler(String section);

    /** Hooks into the GUI profiler */
    void endProfiler();

    /** Entity that you are currently looking at (distance limited) */
    Entity getEntityMouseOver();

    /** Block you are currently pointing at (distance limited) */
    Vec3i getBlockMouseOver();

    /** Offset inside the block you are currently pointing at (distance limited) */
    Vec3d getPosMouseOver();

    /** Is the game in the paused state? */
    boolean isPaused();
}
