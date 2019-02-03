package by.epam.kvirikashvili.task1_2.repository;

import by.epam.kvirikashvili.task1_2.action.TriangleCalculator;
import by.epam.kvirikashvili.task1_2.entity.Shape;

import java.util.function.Predicate;

public enum TrianglePredicate implements ShapePredicate<Shape> {
    INSTANCE;

    private TriangleCalculator triangleCalculator = TriangleCalculator.INSTANCE;

    public Predicate<Shape> searchById(int id) {
        return shape -> shape.getId() == id;
    }

    public Predicate<Shape> searchByName(String name) {
        return shape -> name.equals(shape.getName());
    }

    public Predicate<Shape> searchSquareBetween(double minSquare, double maxSquare) {
        return shape -> triangleCalculator.calculateSquare(shape) > minSquare
                && triangleCalculator.calculateSquare(shape) < maxSquare;
    }

    public Predicate<Shape> searchPerimeterBetween(double minPerimeter, double maxPerimeter) {
        return shape -> triangleCalculator.calculatePerimeter(shape) > minPerimeter
                && triangleCalculator.calculatePerimeter(shape) < maxPerimeter;
    }

    public Predicate<Shape> searchDistanceToShapeBetween(double minDistance, double maxDistance) {
        return shape -> triangleCalculator.getDistanceToShape(shape) > minDistance
                && triangleCalculator.getDistanceToShape(shape) < maxDistance;
    }

    public Predicate<Shape> searchShapesInFirstKvadrant() {
        return shape -> triangleCalculator.isAllPointsInFirstKvadrant(shape);
    }
}
