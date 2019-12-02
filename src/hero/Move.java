package hero;

public class Move {
    private final int x;
    private final int y;

    public Move(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }
}
