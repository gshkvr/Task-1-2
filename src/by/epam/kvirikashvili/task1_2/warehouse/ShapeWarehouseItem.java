package by.epam.kvirikashvili.task1_2.warehouse;

import by.epam.kvirikashvili.task1_2.action.TriangleCalculator;
import by.epam.kvirikashvili.task1_2.entity.Shape;

import java.util.Objects;

public class ShapeWarehouseItem implements WarehouseItem, Observer {
    private TriangleCalculator triangleCalculator = TriangleCalculator.INSTANCE;
    private Shape shape;
    private double square;
    private double perimeter;

    public ShapeWarehouseItem(Shape shape) {
        this.shape = shape;
        shape.addObserver(this);
    }

    public ShapeWarehouseItem(Shape shape, double perimeter, double square) {
        this.shape = shape;
        this.perimeter = perimeter;
        this.square = square;
        shape.addObserver(this);
    }

    @Override
    public void update() {
        square = triangleCalculator.calculateSquare(shape);
        perimeter = triangleCalculator.calculatePerimeter(shape);
    }

    public void unSubscribe() {
        shape.removeObserver(this);
        shape = null;
    }

    @Override
    public int getId() {
        return shape.getId();
    }

    public double getSquare() {
        return square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapeWarehouseItem that = (ShapeWarehouseItem) o;
        return Double.compare(that.square, square) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(square, perimeter);
    }
}
