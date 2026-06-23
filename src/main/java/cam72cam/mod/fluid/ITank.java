package cam72cam.mod.fluid;

import cam72cam.mod.UMC;
import cam72cam.mod.item.ItemStack;

import java.util.function.Consumer;

public interface ITank {
    /**
     * Get a Tank that represents the contents of an itemstack.  Assumes each item can only have a single tank.
     *
     * onUpdate is used for receiving the resultant modified itemstack without actually modifying the input stack (simulate)
     *
     * See ImmersiveRailroading's FreightTank for an example.
     */
    static ITank getTank(ItemStack stack, Consumer<ItemStack> onUpdate) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Copy of the current contents of the tank */
    FluidStack getContents();

    /** Max capacity */
    int getCapacity();

    /** If a fluid will be accepted into this tank */
    boolean allows(Fluid fluid);

    /**
     * Attempt to fill the tank with as much of the stack as possible
     *
     * @return Amount actually transferred
     */
    int fill(FluidStack fluidStack, boolean simulate);

    /**
     * Attempt to drain the tank, whitelisting the type of the stack and up to the amount in the stack
     * @return Fluid/amount actually transferred
     */
    FluidStack drain(FluidStack fluidStack, boolean simulate);

    /**
     * Attempt to drain the inputTank into this tank
     * @return if anything was transferred
     */
    default int drain(ITank source, int max, boolean simulate) {
        ITank dest = this;

        // Max transfer into dest
        int maxTransfer = dest.getCapacity() - dest.getContents().getAmount();
        if (maxTransfer == 0) {
            return 0;
        }

        // Max transferred from source
        maxTransfer = Math.min(maxTransfer, source.getContents().getAmount());
        if (maxTransfer == 0) {
            return 0;
        }

        // Limited
        maxTransfer = Math.min(maxTransfer, max);
        if (maxTransfer == 0) {
            return 0;
        }

        // Simulate filling destination
        maxTransfer = dest.fill(new FluidStack(source.getContents().getFluid(), maxTransfer), true);
        if (maxTransfer == 0) {
            return maxTransfer;
        }

        // Simulate draining source
        FluidStack allowedTransfer = source.drain(new FluidStack(source.getContents().getFluid(), maxTransfer), true);

        if (allowedTransfer.getAmount() == 0) {
            // Can't transfer anything
            return 0;
        }

        if (simulate) {
            // We can stop here, already performed all the necessary checks (probably).
            return allowedTransfer.getAmount();
        }

        // Fill dest
        int transferred = dest.fill(allowedTransfer, false);
        // Drain source
        FluidStack check = source.drain(new FluidStack(source.getContents().getFluid(), transferred), false);

        // If these don't agree there's probably a bug...
        if (check.getAmount() != transferred) {
            try {
                throw new Exception("Invalid fluid transfer!");
            } catch (Exception e) {
                UMC.catching(e);
            }
        }

        return transferred;
    }

    /**
     * Attempt to drain this tank into the inputTank
     * @return if anything was transferred
     */
    default int fill(ITank inputTank, int max, boolean simulate) {
        return inputTank.drain(this, max, simulate);
    }
}
