package by.epam.kvirikashvili.task1_2.repository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface ShapeRepository<T> {
    void add(T item);

    void update(T item);

    void remove(T item);

    void sort(Comparator<T> comparator);

    List<T> getAll();

    void removeAll();

    List<T> query(Predicate<T> predicate);
}
