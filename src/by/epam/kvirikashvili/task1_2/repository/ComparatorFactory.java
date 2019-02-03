package by.epam.kvirikashvili.task1_2.repository;

import by.epam.kvirikashvili.task1_2.entity.Shape;
import by.epam.kvirikashvili.task1_2.exception.NoSuchComparatorTypeException;

import java.util.Comparator;

public class ComparatorFactory {
    private static ComparatorFactory comparatorFactory;

    private ComparatorFactory() {
    }

    public static ComparatorFactory getInstance() {
        if (comparatorFactory == null) {
            comparatorFactory = new ComparatorFactory();
        }
        return comparatorFactory;
    }

    public Comparator<Shape> getComparator(String criterion) throws NoSuchComparatorTypeException {
        switch (criterion) {
            case "id":
                return Comparator.comparing(Shape::getId);
            case "name":
                return Comparator.comparing(Shape::getName);
            case "firstXCoordinate":
                return Comparator.comparing(Shape::getFirstXCoordinate);
            case "firstYCoordinate":
                return Comparator.comparing(Shape::getFirstYCoordinate);
            default:
                throw new NoSuchComparatorTypeException();
        }
    }
}
