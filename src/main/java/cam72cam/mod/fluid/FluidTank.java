package cam72cam.mod.fluid;

import cam72cam.mod.serialization.TagCompound;
import cam72cam.mod.serialization.TagField;
import cam72cam.mod.serialization.TagMapped;
import cam72cam.mod.serialization.TagMapper;
import cam72cam.umc.serialization.*;

import java.util.List;
import java.util.function.Supplier;

@TagMapped(FluidTank.Mapper.class)
public class FluidTank implements ITank {
    public FluidTank(FluidStack fluidStack, int capacity) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    private void onChange() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Add onChanged handler */
    public void onChanged(Runnable onChange) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public FluidStack getContents() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public int getCapacity() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void setCapacity(int milliBuckets) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * null == all
     * [] == none
     */
    public void setFilter(Supplier<List<Fluid>> filter) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public boolean allows(Fluid fluid) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public int fill(FluidStack fluidStack, boolean simulate) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public FluidStack drain(FluidStack fluidStack, boolean simulate) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public TagCompound write(TagCompound tag) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void read(TagCompound tag) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    static class Mapper implements TagMapper<FluidTank> {
        @Override
        public TagAccessor<FluidTank> apply(Class<FluidTank> type, String fieldName, TagField tag) {
            return new TagAccessor<>(
                    ((d, o) -> {
                        if (o == null) {
                            d.remove(fieldName);
                            return;
                        }
                        d.set(fieldName, o.write(new TagCompound()));
                    }),
                    d -> {
                        FluidTank ft = new FluidTank(null, 0);
                        ft.read(d.get(fieldName));
                        return ft;
                    }
            );
        }
    }
}
