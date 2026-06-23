package cam72cam.mod.block.tile;

import cam72cam.mod.UMC;
import cam72cam.mod.block.BlockEntity;
import cam72cam.mod.block.BlockEntityTickable;
import cam72cam.mod.resource.Identifier;

/**
 * TileEntityTickable is an internal class which wraps TileEntity and implements ITickable.  Is paired with
 * BlockEntityTickable.
 *
 * If you need to create a standard tile entity and wound up here, take a look at BlockEntityTickable instead.
 *
 * @see BlockEntityTickable
 */
public abstract class TileEntityTickable extends TileEntity {
    static {
        register(TileEntityTickable.class, new Identifier(UMC.MODID, "hack_tickable"));
    }

    /**
     * Used only be Forge's reflection.
     * <ul>
     *     <li>Must be implemented in subclasses.</li>
     *     <li>Do not use directly.</li>
     * </ul>
     */
    public TileEntityTickable() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * Used only by BlockEntity to construct an instance to register.
     * <ul>
     *     <li>Must be implemented in subclasses.</li>
     *     <li>Do not use directly.</li>
     * </ul>
     *
     * @see BlockEntity
     * @param id Block Entity ID
     */
    public TileEntityTickable(Identifier id) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }
}
