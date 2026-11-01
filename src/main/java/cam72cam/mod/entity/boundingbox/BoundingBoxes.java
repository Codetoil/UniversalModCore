package cam72cam.mod.entity.boundingbox;

import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;

public interface BoundingBoxes {
    IBoundingBox getInfinite();
    IBoundingBox getOrigin();
    IBoundingBox getBlock();
    IBoundingBox getDefaultBox();

    /** Create a new 0 size BB at pos */
    IBoundingBox from(Vec3i pos);

    IBoundingBox from(Vec3d start, Vec3d end);
}
