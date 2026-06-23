package cam72cam.mod.block;

import cam72cam.mod.entity.Player;
import cam72cam.mod.entity.boundingbox.IBoundingBox;
import cam72cam.mod.item.ItemStack;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.resource.Identifier;
import cam72cam.mod.util.Facing;
import cam72cam.mod.world.World;

/** A standard block with no attached entity */
public abstract class BlockType {

    protected BlockType()
    {
        // API
    }

    /** Override to provide a custom Minecraft Block implementation (ex: support tile entities) */
    protected BlockInternal getBlock() {
        return new BlockInternal();
    }

    /** @return false if the in-progress break should be cancelled */
    public abstract boolean tryBreak(World world, Vec3i pos, Player player);

    public abstract Identifier getIdentifier();

    /*
    Properties
     */

    public Material getMaterial() {
        return Material.METAL;
    }
    public float getHardness() {
        return 1.0f;
    }
    public float getExplosionResistance() {
        return getHardness() * 5;
    }

    /** @return if fencing / glass should connect to it */
    public boolean isConnectable() {
        return true;
    }
    /** @return true if redstone functions below should be wired in */
    public boolean isRedstoneProvider() {
        return false;
    }


    /*
    Public functionality
     */

    /** Called when the block is broken */
    public abstract void onBreak(World world, Vec3i pos);

    /**
     * Called when a player right-clicks a block.
     * @return true if this accepts the click (stop processing it after this call)
     */
    public abstract boolean onClick(World world, Vec3i pos, Player player, Player.Hand hand, Facing facing, Vec3d hit);

    /**
     * Called when a player performs the pick operation on this block.
     * @return An ItemStack representing this block.  Must NOT be null, return ItemStack.EMPTY instead.
     */
    public abstract ItemStack onPick(World world, Vec3i pos);

    /**
     * Called when a neighboring block has changed state
     */
    public abstract void onNeighborChange(World world, Vec3i pos, Vec3i neighbor);

    public IBoundingBox getBoundingBox(World world, Vec3i pos) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * Only applicable if isRedstoneProvider returns true
     * @return strong redstone power
     */
    public int getStrongPower(World world, Vec3i vec3i, Facing from) {
        return 0;
    }

    /**
     * Only applicable if isRedstoneProvider returns true
     * @return strong redstone power
     */
    public int getWeakPower(World world, Vec3i vec3i, Facing from) {
        return 0;
    }

    /**
     * BlockInternal is an internal class that should only be extended when you need to implement
     * an interface.
     */
    protected class BlockInternal implements IBlockTypeBlock {
        public BlockType getType() {
            return BlockType.this;
        }

        protected BlockInternal() {
            // API
        }
    }
}
