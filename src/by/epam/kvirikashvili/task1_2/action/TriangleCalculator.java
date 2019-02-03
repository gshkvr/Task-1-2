package by.epam.kvirikashvili.task1_2.action;

import by.epam.kvirikashvili.task1_2.entity.Point;
import by.epam.kvirikashvili.task1_2.entity.Shape;
import by.epam.kvirikashvili.task1_2.entity.Triangle;
import org.apache.commons.math3.util.Precision;

import java.util.Arrays;

public enum TriangleCalculator implements ShapeCalculator {
    INSTANCE;
    private final double PRECISION = 0.0000000001;

    @Override
    public double calculateSquare(Shape shape) {
        Triangle triangle = (Triangle) shape;
        double[] sides = getSides(triangle.getPoints());
        double p = 0.5 * (sides[0] + sides[1] + sides[2]);
        return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }

    @Override
    public double calculatePerimeter(Shape shape) {
        Triangle triangle = (Triangle) shape;
        double[] sides = getSides(triangle.getPoints());
        return sides[0] + sides[1] + sides[2];
    }

    @Override
    public double getFirstXCoordinate(Shape shape) {
        return ((Triangle) shape).getA().getX();
    }

    @Override
    public double getFirstYCoordinate(Shape shape) {
        return ((Triangle) shape).getA().getY();
    }

    public boolean isTriangle(Point[] points) {
        double[] sides = getSides(points);
        return (sides[0] < sides[1] + sides[2]) &&
                (sides[1] < sides[0] + sides[2]) &&
                (sides[2] < sides[0] + sides[1]);
    }

    public boolean isEquilateral(Triangle triangle) {
        double[] sides = getSides(triangle.getPoints());
        return Precision.equals(sides[0], sides[1], PRECISION) &&
                Precision.equals(sides[1], sides[2], PRECISION);
    }

    public boolean isIsosceles(Triangle triangle) {
        double[] sides = getSides(triangle.getPoints());
        return Precision.equals(sides[0], sides[1], PRECISION) ||
                Precision.equals(sides[1], sides[2], PRECISION) ||
                Precision.equals(sides[0], sides[2], PRECISION);
    }

    public boolean isRectangular(Triangle triangle) {
        double[] sides = getSides(triangle.getPoints());
        return Precision.equals(Math.pow(sides[0], 2), Math.pow(sides[1], 2) + Math.pow(sides[2], 2), PRECISION) ||
                Precision.equals(Math.pow(sides[1], 2), Math.pow(sides[0], 2) + Math.pow(sides[2], 2), PRECISION) ||
                Precision.equals(Math.pow(sides[2], 2), Math.pow(sides[0], 2) + Math.pow(sides[1], 2), PRECISION);
    }

    public boolean isSharpCornered(Triangle triangle) {
        double[] sides = getSides(triangle.getPoints());
        Arrays.sort(sides);
        return Double.compare(Math.pow(sides[2], 2), Math.pow(sides[0], 2) + Math.pow(sides[1], 2)) == -1;
    }

    public boolean isAllPointsInFirstKvadrant(Shape shape) {
        Triangle triangle = (Triangle) shape;
        return isPointInFirstKvadrant(triangle.getA())
                && isPointInFirstKvadrant(triangle.getB())
                && isPointInFirstKvadrant(triangle.getC());
    }

    public boolean isPointInFirstKvadrant(Point point) {
        return point.getX() > 0 && point.getY() > 0;
    }

    public double[] getSides(Point[] points) {
        double[] sides = new double[3];
        sides[0] = getDistanceBetweenPoints(points[0], points[1]);
        sides[1] = getDistanceBetweenPoints(points[1], points[2]);
        sides[2] = getDistanceBetweenPoints(points[2], points[0]);
        return sides;
    }

    public double getDistanceToShape(Shape shape) {
        Point[] points = ((Triangle) shape).getPoints();
        double[] distances = new double[3];
        distances[0] = getDistanceBetweenPoints(points[0], new Point(0, 0));
        distances[1] = getDistanceBetweenPoints(points[1], new Point(0, 0));
        distances[2] = getDistanceBetweenPoints(points[2], new Point(0, 0));
        Arrays.sort(distances);
        return distances[0];
    }

    public double getDistanceBetweenPoints(Point a, Point b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) +
                Math.pow(b.getY() - a.getY(), 2));
    }
}
