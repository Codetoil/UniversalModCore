package cam72cam.mod;

import cam72cam.mod.entity.Entity;
import cam72cam.mod.entity.Player;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;

/** Static Minecraft Client props, don't touch server side */
public abstract class MinecraftClient {
    protected static MinecraftClient instance;

    public static MinecraftClient getInstance()
    {
        return instance;
    }

    /** Minecraft is loaded and has a loaded world */
    public abstract boolean isReady();

    /** Hey, it's you! */
    public abstract Player getPlayer();

    /** Hooks into the GUI profiler */
    public abstract void startProfiler(String section);

    /** Hooks into the GUI profiler */
    public abstract void endProfiler();

    /** Entity that you are currently looking at (distance limited) */
    public abstract Entity getEntityMouseOver();

    /** Block you are currently pointing at (distance limited) */
    public abstract Vec3i getBlockMouseOver();

    /** Offset inside the block you are currently pointing at (distance limited) */
    public abstract Vec3d getPosMouseOver();

    /** Is the game in the paused state? */
    public abstract boolean isPaused();
}
