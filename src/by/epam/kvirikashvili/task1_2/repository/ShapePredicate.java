package by.epam.kvirikashvili.task1_2.repository;

import java.util.function.Predicate;

public interface ShapePredicate<Shape> {
    Predicate<Shape> searchById(int id);

    Predicate<Shape> searchByName(String name);

    Predicate<Shape> searchSquareBetween(double minSquare, double maxSquare);

    Predicate<Shape> searchPerimeterBetween(double minPerimeter, double maxPerimeter);
}
