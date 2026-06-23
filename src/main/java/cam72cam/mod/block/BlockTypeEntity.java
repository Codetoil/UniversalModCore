package cam72cam.mod.block;

import cam72cam.mod.entity.Player;
import cam72cam.mod.entity.boundingbox.IBoundingBox;
import cam72cam.mod.item.ItemStack;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.util.Facing;
import cam72cam.mod.world.World;

/**
 * Extension to BlockType that integrates with BlockEntities.
 *
 * Most if not all of the functions exposed are now redirected to the block entity (break/pick/etc...)
 */
public abstract class BlockTypeEntity extends BlockType {
    /** This is a crappy hack that allows us to pass the block entity instance into the renderer */
    public static final PropertyObject BLOCK_DATA = new PropertyObject("BLOCK_DATA");

    public BlockTypeEntity(String modID, String name) {
        super(modID, name);
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Supply your custom BlockEntity constructor here */
    protected abstract BlockEntity constructBlockEntity();

    @Override
    public final boolean isRedstoneProvider() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Hack for initializing a "fake" te */
    public final BlockEntity createBlockEntity(World world, Vec3i pos) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /*

    BlockType Implementation

    */

    protected BlockInternal getBlock() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public final boolean tryBreak(World world, Vec3i pos, Player player) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /*

    Add block data to normal block calls

     */

    @Override
    public final void onBreak(World world, Vec3i pos) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public final boolean onClick(World world, Vec3i pos, Player player, Player.Hand hand, Facing facing, Vec3d hit) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public final ItemStack onPick(World world, Vec3i pos) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public final void onNeighborChange(World world, Vec3i pos, Vec3i neighbor) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public IBoundingBox getBoundingBox(World world, Vec3i pos) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public int getStrongPower(World world, Vec3i pos, Facing from) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public int getWeakPower(World world, Vec3i pos, Facing from) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    protected class BlockTypeInternal extends BlockInternal {

    }
}
