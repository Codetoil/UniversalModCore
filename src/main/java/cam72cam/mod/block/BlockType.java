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

    /** Mod/name of the block */
    public final Identifier id;

    /**
     * Construct a new BlockType (backed by a std minecraft block)<br>
     * <br>
     * Should be called during ModEvent.CONSTRUCT
     */
    public BlockType(String modID, String name) {
        this.id = new Identifier(modID, name);
    }

    /** @return false if the in-progress break should be cancelled */
    public abstract boolean tryBreak(World world, Vec3i pos, Player player);

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

    /**
     * Shape of the block.
     */
    public IBoundingBox getBoundingBox(World world, Vec3i pos) {
        return world.boundingBoxes().getDefaultBox();
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
}
