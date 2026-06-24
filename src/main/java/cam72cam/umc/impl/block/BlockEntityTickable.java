package cam72cam.umc.impl.block;

import cam72cam.umc.impl.block.tile.TileEntity;
import cam72cam.umc.impl.block.tile.TileEntityTickable;
import cam72cam.umc.impl.resource.Identifier;

/** Wraps BlockEntity and exposes an update function which is called every tick */
public abstract class BlockEntityTickable extends BlockEntity {
    /** Called every tick */
    public abstract void update();

    protected TileEntity supplier(Identifier id) {
        return new TileEntityTickable(id);
    }
}
