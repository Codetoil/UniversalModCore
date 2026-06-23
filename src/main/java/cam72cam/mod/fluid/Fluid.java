package cam72cam.mod.fluid;

public class Fluid {
    public static final int BUCKET_VOLUME = 0; // implementation dependent?
    public static final Fluid WATER = getFluid("water");
    public static final Fluid LAVA = getFluid("lava");

    // Fluid Name/Ident
    public final String ident;

    // Fake, not in real UMC
    private Fluid(String ident) {
        this.ident = ident;
    }

    public static Fluid getFluid(String type) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public int getDensity() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public String toString() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }
}
