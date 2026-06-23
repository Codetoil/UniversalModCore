package cam72cam.mod.energy;

import cam72cam.mod.serialization.TagField;

/** Reference IEnergy implementation */
public class Energy implements IEnergy {
    @TagField("max")
    private int max;
    @TagField("stored")
    private int stored;

    private Energy() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public Energy(int stored, int maxStorage) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Subscribe to on-change event */
    public void onChanged(Runnable fn) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public int receive(int maxReceive, boolean simulate) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public int extract(int maxExtract, boolean simulate) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public int getCurrent() {
        return stored;
    }

    @Override
    public int getMax() {
        return max;
    }
}
