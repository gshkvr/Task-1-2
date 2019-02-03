package by.epam.kvirikashvili.task1_2.repository;

import by.epam.kvirikashvili.task1_2.entity.Shape;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum TriangleRepository implements ShapeRepository<Shape> {
    INSTANCE;

    private List<Shape> triangles = new ArrayList<>();

    @Override
    public void add(Shape shape) {
        triangles.add(shape);
    }

    @Override
    public void update(Shape shape) {
        for (Shape sh : triangles) {
            if (sh.getId() == shape.getId()) {
                triangles.set(triangles.indexOf(sh), shape);
                break;
            }
        }
    }

    @Override
    public void remove(Shape shape) {
        triangles.remove(shape);
    }

    @Override
    public void sort(Comparator<Shape> comparator) {
        triangles.sort(comparator);
    }

    @Override
    public List<Shape> getAll() {
        return triangles;
    }

    @Override
    public void removeAll() {
        triangles = new ArrayList<>();
    }


    @Override
    public List<Shape> query(Predicate<Shape> predicate) {
        return triangles.stream().
                filter(predicate).
                collect(Collectors.toList());
    }
}
