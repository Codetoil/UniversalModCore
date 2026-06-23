package cam72cam.mod.world;

import cam72cam.mod.math.Vec3i;

/** Internal, do not use directly */
public abstract class ChunkManager {
    public abstract void setup();

    abstract void flagEntityPos(World world, Vec3i inPos);

    protected abstract void onWorldTick(World world);

    protected abstract void saveChunks(World world);
}
