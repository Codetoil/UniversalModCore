package cam72cam.mod.entity.boundingbox;

import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;

public interface IBoundingBox {
    IBoundingBox INFINITE = null;
    IBoundingBox ORIGIN = null;
    IBoundingBox BLOCK = null;

    static IBoundingBox from(BoundingBox internal) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Create a new 0 size BB at pos */
    static IBoundingBox from(Vec3i pos) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    static IBoundingBox from(Vec3d start, Vec3d end) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Smaller corner of the BB */
    Vec3d min();

    /** Center of the BB */
    Vec3d center();

    /** Larger corner of the BB */
    Vec3d max();

    /** Expands the BB in one direction (positive/negative) */
    IBoundingBox expand(Vec3d val);

    /** Contracts the BB in one direction (positive/negative) */
    IBoundingBox contract(Vec3d val);

    /** Increase the BB's size in all dimensions by value specified (by axis) */
    IBoundingBox grow(Vec3d val);

    /** Move the BB by the given amount */
    IBoundingBox offset(Vec3d vec3d);

    double calculateXOffset(IBoundingBox other, double offsetX);

    double calculateYOffset(IBoundingBox other, double offsetY);

    double calculateZOffset(IBoundingBox other, double offsetZ);

    /** Does the AABB represented by these coords intersect this BB */
    boolean intersects(Vec3d min, Vec3d max);

    /** Expand this BB to contain another BB */
    IBoundingBox expandToFit(IBoundingBox other);

    /** Does the line represented by these coords intersect this BB */
    boolean intersectsSegment(Vec3d start, Vec3d end);

    /** Is this vector within bounds */
    boolean contains(Vec3d vec);

    default boolean intersects(IBoundingBox bounds) {
        return this.intersects(bounds.min(), bounds.max());
    }

}
