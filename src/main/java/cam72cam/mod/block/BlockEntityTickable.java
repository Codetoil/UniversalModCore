package cam72cam.mod.block;

import cam72cam.mod.block.tile.TileEntity;
import cam72cam.mod.resource.Identifier;

/** Wraps BlockEntity and exposes an update function which is called every tick */
public abstract class BlockEntityTickable extends BlockEntity {
    /** Called every tick */
    public abstract void update();

    protected abstract TileEntity supplier(Identifier id);
}
