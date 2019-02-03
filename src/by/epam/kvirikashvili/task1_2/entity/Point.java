package by.epam.kvirikashvili.task1_2.entity;

public final class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (int) Math.round(x);
        result = 31 * result + (int) Math.round(y);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Point point = (Point) obj;

        return x == point.getX() && y == point.getY();
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
