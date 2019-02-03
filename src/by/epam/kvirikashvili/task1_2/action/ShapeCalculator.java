package by.epam.kvirikashvili.task1_2.action;

import by.epam.kvirikashvili.task1_2.entity.Shape;

public interface ShapeCalculator {
    double calculateSquare(Shape shape);
    double calculatePerimeter(Shape shape);
    double getFirstXCoordinate(Shape shape);
    double getFirstYCoordinate(Shape shape);
}
