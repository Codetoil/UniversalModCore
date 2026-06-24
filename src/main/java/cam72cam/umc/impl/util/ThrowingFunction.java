package cam72cam.umc.impl.util;

@FunctionalInterface
public interface ThrowingFunction<T, R, E extends Throwable> {
    R apply(T in) throws E;
}
