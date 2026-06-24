package cam72cam.umc.impl.world;

import cam72cam.umc.impl.entity.Entity;
import cam72cam.umc.impl.math.Vec3i;

public interface IBlockEntityCollision {
    boolean canCollide(World world, Vec3i pos, Entity entity);
}
