package util;

public record Pair<L, R>(L getLeft, R getRight) {
    public static <L, M, R> Pair<L, R> of(L left, R right) {
        return new Pair<>(left, right);
    }
}
