package cam72cam.mod.entity.boundingbox;

import cam72cam.mod.math.Vec3d;

public class BoundingBox {
    public final IBoundingBox internal;

    private BoundingBox(IBoundingBox internal, double[] constructorParams) {
        this.internal = internal;
    }

    private BoundingBox(IBoundingBox internal) {
        this(internal, hack(internal));
    }

    public static BoundingBox from(IBoundingBox internal) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    private static double[] hack(IBoundingBox internal) {
        Vec3d min = internal.min();
        Vec3d max = internal.max();
        return new double[]{max.x, max.y, max.z, min.x, min.y, min.z};
    }

    /* NOP */
    public BoundingBox setMaxY(double y) {
        // Used by blockwall
        return this;
    }

    public BoundingBox intersect(BoundingBox p_191500_1_) {
        // Used by piston
        return this;
    }

    public BoundingBox union(BoundingBox other) {
        // Used by piston
        // Used by entityliving for BB stuff
        return this;
    }

    /* Modifiers */

    public BoundingBox expand(double x, double y, double z) {
        return new BoundingBox(internal.expand(new Vec3d(x, y, z)));
    }

    public BoundingBox contract(double x, double y, double z) {
        return new BoundingBox(internal.contract(new Vec3d(x, y, z)));
    }

    public BoundingBox grow(double x, double y, double z) {
        return new BoundingBox(internal.grow(new Vec3d(x, y, z)));
    }

    public BoundingBox offset(double x, double y, double z) {
        return new BoundingBox(internal.offset(new Vec3d(x, y, z)));
    }

    /* Interactions */
    public double calculateXOffset(BoundingBox other, double offsetX) {
        return internal.calculateXOffset(IBoundingBox.from(other), offsetX);
    }

    public double calculateYOffset(BoundingBox other, double offsetY) {
        return internal.calculateYOffset(IBoundingBox.from(other), offsetY);
    }

    public double calculateZOffset(BoundingBox other, double offsetZ) {
        return internal.calculateZOffset(IBoundingBox.from(other), offsetZ);
    }

    public boolean intersects(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public double getMinX()
    {

    }
}
