package util;

public record Quadruple<L, ML, MR, R>(L getLeft, ML getMiddleLeft, MR getMiddleRight, R getRight) {
    public static <L, ML, MR, R> Quadruple<L, ML, MR, R> of(L left, ML middleLeft, MR middleRight, R right) {
        return new Quadruple<>(left, middleLeft, middleRight, right);
    }
}
