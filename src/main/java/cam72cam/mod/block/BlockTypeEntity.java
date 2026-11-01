package cam72cam.mod.block;

import cam72cam.mod.entity.Player;
import cam72cam.mod.entity.boundingbox.IBoundingBox;
import cam72cam.mod.item.ItemStack;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.util.Facing;
import cam72cam.mod.world.World;

import javax.annotation.Nonnull;

/**
 * Extension to BlockType that integrates with BlockEntities.
 *
 * Most if not all of the functions exposed are now redirected to the block entity (break/pick/etc...)
 */
public abstract class BlockTypeEntity extends BlockType {

    // Cached from ctr
    private final boolean isRedstoneProvider;

    public BlockTypeEntity(String modID, String name) {
        super(modID, name);
        this.isRedstoneProvider = constructBlockEntity() instanceof IRedstoneProvider;
    }

    /** Supply your custom BlockEntity constructor here */
    protected abstract BlockEntity constructBlockEntity();

    @Override
    public final boolean isRedstoneProvider() {
        return isRedstoneProvider;
    }

    /*

    BlockType Implementation

    */

    protected abstract BlockEntity getInstance(World world, Vec3i pos);

    @Override
    public final boolean tryBreak(World world, Vec3i pos, Player player) {
        BlockEntity instance = getInstance(world, pos);
        if (instance != null) {
            return instance.tryBreak(player);
        }
        return true;
    }

    /*

    Add block data to normal block calls

     */

    @Override
    public final void onBreak(World world, Vec3i pos) {
        BlockEntity instance = getInstance(world, pos);
        if (instance != null) {
            instance.onBreak();
        }
    }

    @Override
    public final boolean onClick(World world, Vec3i pos, Player player, Player.Hand hand, Facing facing, Vec3d hit) {
        BlockEntity instance = getInstance(world, pos);
        if (instance != null) {
            return instance.onClick(player, hand, facing, hit);
        }
        return false;
    }

    @Override
    public final ItemStack onPick(World world, Vec3i pos) {
        BlockEntity instance = getInstance(world, pos);
        if (instance != null) {
            return instance.onPick();
        }
        return ItemStack.EMPTY;
    }

    @Override
    public final void onNeighborChange(World world, Vec3i pos, Vec3i neighbor) {
        BlockEntity instance = getInstance(world, pos);
        if (instance != null) {
            instance.onNeighborChange(neighbor);
        }
    }

    @Override
    public IBoundingBox getBoundingBox(World world, Vec3i pos) {
        BlockEntity instance = getInstance(world, pos);
        if (instance != null) {
            return instance.getBoundingBox();
        }
        return super.getBoundingBox(world, pos);
    }

    @Override
    public int getStrongPower(World world, Vec3i pos, Facing from) {
        if (isRedstoneProvider()) {
            BlockEntity instance = getInstance(world, pos);
            if (instance instanceof IRedstoneProvider) {
                return ((IRedstoneProvider)instance).getStrongPower(from);
            }
        }
        return 0;
    }

    @Override
    public int getWeakPower(World world, Vec3i pos, Facing from) {
        if (isRedstoneProvider()) {
            BlockEntity instance = getInstance(world, pos);
            if (instance instanceof IRedstoneProvider) {
                return ((IRedstoneProvider)instance).getWeakPower(from);
            }
        }
        return 0;
    }

    protected class BlockTypeInternal extends BlockInternal {
        @Override
        public final boolean hasTileEntity(IBlockState state) {
            return true;
        }

        @Override
        public final net.minecraft.tileentity.TileEntity createTileEntity(net.minecraft.world.World world, IBlockState state) {
            return constructBlockEntity().supplier(id);
        }

        @Override
        @Nonnull
        protected BlockStateContainer createBlockState() {
            return new ExtendedBlockState(this, new IProperty[0], new IUnlistedProperty<?>[]{BLOCK_DATA});
        }

        @Override
        public IBlockState getExtendedState(IBlockState origState, IBlockAccess access, BlockPos pos) {
            World world = getWorldOrNull(access, pos);
            if (world != null) {
                BlockEntity te = world.getBlockEntity(new Vec3i(pos), BlockEntity.class);
                if (te != null) {
                    IExtendedBlockState state = (IExtendedBlockState) origState;
                    state = state.withProperty(BLOCK_DATA, te);
                    return state;
                }
            }
            return super.getExtendedState(origState, access, pos);
        }

        @Override
        protected World getWorldOrNull(IBlockAccess source, BlockPos pos) {
            if (source instanceof net.minecraft.world.World) {
                return World.get((net.minecraft.world.World) source);
            }
            net.minecraft.tileentity.TileEntity te = source.getTileEntity(pos);
            if (te instanceof TileEntity && ((TileEntity) te).isLoaded()) {
                return ((TileEntity) te).getUMCWorld();
            }
            return null;
        }
    }
}
