package util;

public record Triple<L, M, R>(L getLeft, M getMiddle, R getRight) {
    public static <L, M, R> Triple<L, M, R> of(L left, M middle, R right) {
        return new Triple<>(left, middle, right);
    }
}
