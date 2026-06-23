package cam72cam.mod.entity.boundingbox;

import cam72cam.mod.math.Vec3d;

/** Default implementation of IBoundingBox, do not use directly! */
public class DefaultBoundingBox implements IBoundingBox {
    @Override
    public Vec3d min() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public Vec3d center() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public Vec3d max() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public IBoundingBox expand(Vec3d centered) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public IBoundingBox contract(Vec3d centered) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public IBoundingBox grow(Vec3d val) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public IBoundingBox offset(Vec3d vec3d) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public double calculateXOffset(IBoundingBox other, double offsetX) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public double calculateYOffset(IBoundingBox other, double offsetY) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public double calculateZOffset(IBoundingBox other, double offsetZ) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public boolean intersects(Vec3d min, Vec3d max) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public IBoundingBox expandToFit(IBoundingBox other) {
        Vec3d min = min();
        Vec3d max = max();

        min = min.min(other.min());
        max = max.max(other.max());

        return IBoundingBox.from(min, max);
    }

    @Override
    public boolean intersectsSegment(Vec3d startVec, Vec3d endVec) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public boolean contains(Vec3d vec) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }
}
