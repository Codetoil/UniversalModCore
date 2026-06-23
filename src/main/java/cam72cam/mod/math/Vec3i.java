package cam72cam.mod.math;

import cam72cam.mod.util.Facing;

public record Vec3i(int x, int y, int z) {
    public static final Vec3i ZERO = new Vec3i(0, 0, 0);

    public Vec3i(double x, double y, double z) {
        int xi = (int) x;
        int yi = (int) y;
        int zi = (int) z;
        if (xi > x) {
            xi -= 1;
        }
        if (yi > y) {
            yi -= 1;
        }
        if (zi > z) {
            zi -= 1;
        }
        this(xi, yi, zi);
    }

    public Vec3i(Vec3d pos) {
        this(pos.x, pos.y, pos.z);
    }

    public Vec3i offset(Facing facing, int offset) {
        if (offset == 0) {
            return this;
        }
        return new Vec3i(
                this.x + facing.getXMultiplier() * offset,
                this.y + facing.getYMultiplier() * offset,
                this.z + facing.getZMultiplier() * offset
        );
    }

    public Vec3i offset(Facing facing) {
        return offset(facing, 1);
    }

    public Vec3i up() {
        return offset(Facing.UP);
    }

    public Vec3i down() {
        return offset(Facing.DOWN);
    }

    public Vec3i north() {
        return offset(Facing.NORTH);
    }

    public Vec3i east() {
        return offset(Facing.EAST);
    }

    public Vec3i south() {
        return offset(Facing.SOUTH);
    }

    public Vec3i west() {
        return offset(Facing.WEST);
    }

    public Vec3i up(int offset) {
        return offset(Facing.UP, offset);
    }

    public Vec3i down(int offset) {
        return offset(Facing.DOWN, offset);
    }

    public Vec3i north(int offset) {
        return offset(Facing.NORTH, offset);
    }

    public Vec3i east(int offset) {
        return offset(Facing.EAST, offset);
    }

    public Vec3i south(int offset) {
        return offset(Facing.SOUTH, offset);
    }

    public Vec3i west(int offset) {
        return offset(Facing.WEST, offset);
    }

    public Vec3i add(int x, int y, int z) {
        return new Vec3i(this.x + x, this.y + y, this.z + z);
    }

    public Vec3i add(Vec3i other) {
        return add(other.x, other.y, other.z);
    }

    public Vec3i subtract(int x, int y, int z) {
        return add(-x, -y, -z);
    }

    public Vec3i subtract(Vec3i other) {
        return subtract(other.x, other.y, other.z);
    }

    @Deprecated
    public long toLong() {
        return internal().toLong();
    }

    public Vec3i rotate(Rotation rotation) {
        return switch (rotation) {
            case CLOCKWISE_90 -> new Vec3i(-z, y, x);
            case CLOCKWISE_180 -> new Vec3i(-x, y, -z);
            case COUNTERCLOCKWISE_90 -> new Vec3i(z, y, -x);
            default -> this;
        };
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Vec3i ov) {
            return ov.x == this.x && ov.y == this.y && ov.z == this.z;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", this.x, this.y, this.z);
    }

    public Vec3d toChunkMin() {
        return new Vec3d(x >> 4 << 4, 0, z >> 4 << 4);
    }

    public Vec3d toChunkMax() {
        return new Vec3d((x >> 4 << 4) + 16, Double.POSITIVE_INFINITY, (z >> 4 << 4) + 16);
    }
}
