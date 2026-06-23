package cam72cam.mod.entity;

import cam72cam.mod.item.ClickResult;
import cam72cam.mod.item.IInventory;
import cam72cam.mod.item.ItemStack;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.text.IPlayerMessage;

/** Wrapper around EntityPlayer */
public class Player extends Entity {

    private Player() {}

    public ItemStack getHeldItem(Hand hand) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void sendMessage(IPlayerMessage o) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void sendActionBarMessage(IPlayerMessage o){
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public boolean isCrouching() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public boolean isCreative() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Deprecated
    public float getYawHead() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void setHeldItem(Hand hand, ItemStack stack) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public int getFoodLevel() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void useFood(int i) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public IInventory getInventory() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Force the player to click a block */
    public ClickResult clickBlock(Hand hand, Vec3i pos, Vec3d hit) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** What direction the player is trying to move and how fast */
    public Vec3d getMovementInput() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public boolean hasPermission(PermissionAction action) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public static class PermissionAction {
        private PermissionAction(String node) {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }
    }

    public static PermissionAction registerAction(String name, String description, boolean opRequiredDefault) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public enum Hand {
        PRIMARY,
        SECONDARY;

        Hand() {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }
    }
}
