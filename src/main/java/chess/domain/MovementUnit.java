package chess.domain;

public enum MovementUnit {
    UP(0, 1),
    RIGHT(1, 0),
    DIAGNOAL(1, 1),
    KNIGHT_MOVE_ONE(2, 1),
    KNIGHT_MOVE_TWO(1, 2);

    private final int x;
    private final int y;

    MovementUnit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //TODO 메서드, 파라미터명 수정
    public int getX(int xDirection) {
        return x * xDirection;
    }

    public int getY(int yDirection) {
        return y * yDirection;
    }

    //TODO 리팩토링
    public static MovementUnit direction(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        if (x == 0 && y == 0) {
            throw new IllegalArgumentException("올바른 움직임을 입력하세요");
        }

        if (x == 0) {
            return UP;
        }

        if (y == 0) {
            return RIGHT;
        }

        if (x == y) {
            return DIAGNOAL;
        }

        if (x == 2 && y == 1) {
            return KNIGHT_MOVE_ONE;
        }

        if (x == 1 && y == 2) {
            return KNIGHT_MOVE_TWO;
        }

        throw new IllegalArgumentException("올바른 점들을 입력해주세요");

//        for (MovementUnit value : values()) {
//
//        }
    }
}