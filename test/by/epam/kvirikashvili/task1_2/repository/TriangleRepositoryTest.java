package by.epam.kvirikashvili.task1_2.repository;

import by.epam.kvirikashvili.task1_2.action.TriangleCalculator;
import by.epam.kvirikashvili.task1_2.entity.Point;
import by.epam.kvirikashvili.task1_2.entity.Shape;
import by.epam.kvirikashvili.task1_2.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TriangleRepositoryTest {
    private ShapeRepository triangleRepository = TriangleRepository.INSTANCE;
    private TriangleCalculator triangleCalculator = TriangleCalculator.INSTANCE;

    private final Comparator<Shape> comparatorById = Comparator.comparing(Shape::getId);
    private final Comparator<Shape> comparatorByName = Comparator.comparing(Shape::getName);
    private final Comparator<Shape> comparatorByFirstXCoordinate = Comparator.comparing(Shape::getFirstXCoordinate);
    private final Comparator<Shape> comparatorByFirstYCoordinate = Comparator.comparing(Shape::getFirstYCoordinate);
    private final Predicate<Shape> predicateById = shape -> shape.getId() == 0;
    private final Predicate<Shape> predicateByName = shape -> "Triangle2".equals(shape.getName());
    private final Predicate<Shape> predicateSquareBetween = shape -> triangleCalculator.calculateSquare(shape) > 10
            && triangleCalculator.calculateSquare(shape) < 20;
    private final Predicate<Shape> predicatePerimeterBetween = shape -> triangleCalculator.calculatePerimeter(shape) > 20
            && triangleCalculator.calculatePerimeter(shape) < 70;
    private final Predicate<Shape> predicateDistanceToShapeBetween = shape -> triangleCalculator.getDistanceToShape(shape) > 1
            && triangleCalculator.getDistanceToShape(shape) < 2;
    private final Predicate<Shape> predicateShapesInFirstKvadrant = shape -> triangleCalculator.isAllPointsInFirstKvadrant(shape);

    private final List<Shape> sortedById = Arrays.asList(
            new Triangle(0, new Point(1, 1), new Point(3, 4), new Point(8, 35)),
            new Triangle(1, new Point(6, 4), new Point(6, 5), new Point(8, 4)),
            new Triangle(2, new Point(-3, -2), new Point(5, 5), new Point(9, 4)),
            new Triangle(3, new Point(6, 7), new Point(8, 5), new Point(8, 35)),
            new Triangle(4, new Point(9, 3), new Point(-4, -3), new Point(9, 5)),
            new Triangle(5, new Point(2, 8), new Point(-7, -44), new Point(-91, -4)));

    private final List<Shape> sortedByFirstXCoordinate = Arrays.asList(
            new Triangle(2, new Point(-3, -2), new Point(5, 5), new Point(9, 4)),
            new Triangle(0, new Point(1, 1), new Point(3, 4), new Point(8, 35)),
            new Triangle(5, new Point(2, 8), new Point(-7, -44), new Point(-91, -4)),
            new Triangle(1, new Point(6, 4), new Point(6, 5), new Point(8, 4)),
            new Triangle(3, new Point(6, 7), new Point(8, 5), new Point(8, 35)),
            new Triangle(4, new Point(9, 3), new Point(-4, -3), new Point(9, 5)));

    private final List<Shape> sortedByFirstYCoordinate = Arrays.asList(
            new Triangle(2, new Point(-3, -2), new Point(5, 5), new Point(9, 4)),
            new Triangle(0, new Point(1, 1), new Point(3, 4), new Point(8, 35)),
            new Triangle(4, new Point(9, 3), new Point(-4, -3), new Point(9, 5)),
            new Triangle(1, new Point(6, 4), new Point(6, 5), new Point(8, 4)),
            new Triangle(3, new Point(6, 7), new Point(8, 5), new Point(8, 35)),
            new Triangle(5, new Point(2, 8), new Point(-7, -44), new Point(-91, -4)));

    private final List<Shape> notSorted = Arrays.asList(
            new Triangle(0, new Point(1, 1), new Point(3, 4), new Point(8, 35)),
            new Triangle(2, new Point(-3, -2), new Point(5, 5), new Point(9, 4)),
            new Triangle(1, new Point(6, 4), new Point(6, 5), new Point(8, 4)),
            new Triangle(5, new Point(2, 8), new Point(-7, -44), new Point(-91, -4)),
            new Triangle(3, new Point(6, 7), new Point(8, 5), new Point(8, 35)),
            new Triangle(4, new Point(9, 3), new Point(-4, -3), new Point(9, 5)));

    @Test
    public void testAdd() {
        //given
        triangleRepository.removeAll();
        triangleRepository.add(new Triangle(0, new Point(1, 1), new Point(2, 4), new Point(3, 1)));
        List<Shape> expected = new ArrayList<>();
        expected.add(new Triangle(0, new Point(1, 1), new Point(2, 4), new Point(3, 1)));
        //when
        List<Shape> actual = triangleRepository.getAll();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdate() {
        //given
        triangleRepository.removeAll();
        triangleRepository.add(new Triangle(1, new Point(1, 1), new Point(2, 4), new Point(3, 1)));
        triangleRepository.update(new Triangle(1, new Point(2, 2), new Point(2, 4), new Point(3, 1)));
        List<Shape> expected = new ArrayList<>();
        expected.add(new Triangle(1, new Point(2, 2), new Point(2, 4), new Point(3, 1)));
        //when
        List<Shape> actual = triangleRepository.getAll();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemove() {
        //given
        triangleRepository.removeAll();
        triangleRepository.add(new Triangle(1, new Point(1, 1), new Point(2, 4), new Point(3, 1)));
        triangleRepository.remove(new Triangle(1, new Point(1, 1), new Point(2, 4), new Point(3, 1)));
        List<Shape> expected = new ArrayList<>();
        //when
        List<Shape> actual = triangleRepository.getAll();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testSortById(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = sortedById;
        //when
        triangleRepository.sort(comparatorById);
        List<Shape> actual = triangleRepository.getAll();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testSortByName(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = sortedById;
        //when
        triangleRepository.sort(comparatorByName);
        List<Shape> actual = triangleRepository.getAll();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testSortByFirstXCoordinate(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = sortedByFirstXCoordinate;
        //when
        triangleRepository.sort(comparatorByFirstXCoordinate);
        List<Shape> actual = triangleRepository.getAll();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testSortByFirstYCoordinate(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = sortedByFirstYCoordinate;
        //when
        triangleRepository.sort(comparatorByFirstYCoordinate);
        List<Shape> actual = triangleRepository.getAll();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testQueryGetAll(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = notSorted;
        //when
        List<Shape> actual = triangleRepository.getAll();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testQueryRemoveAll(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = new ArrayList<>();
        //when
        triangleRepository.removeAll();
        List<Shape> actual = triangleRepository.getAll();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testQuerySearchById(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = new ArrayList<>();
        expected.add(new Triangle(0, new Point(1, 1), new Point(3, 4), new Point(8, 35)));
        //when
        List<Shape> actual = triangleRepository.query(predicateById);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testQuerySearchByName(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = new ArrayList<>();
        expected.add(new Triangle(2, new Point(-3, -2), new Point(5, 5), new Point(9, 4)));
        //when
        List<Shape> actual = triangleRepository.query(predicateByName);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testQuerySearchBySquare(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = new ArrayList<>();
        expected.add(new Triangle(2, new Point(-3, -2), new Point(5, 5), new Point(9, 4)));
        expected.add(new Triangle(4, new Point(9, 3), new Point(-4, -3), new Point(9, 5)));
        //when
        List<Shape> actual = triangleRepository.query(predicateSquareBetween);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testQuerySearchByPerimeter(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = new ArrayList<>();
        expected.add(new Triangle(0, new Point(1, 1), new Point(3, 4), new Point(8, 35)));
        expected.add(new Triangle(2, new Point(-3, -2), new Point(5, 5), new Point(9, 4)));
        expected.add(new Triangle(3, new Point(6, 7), new Point(8, 5), new Point(8, 35)));
        expected.add(new Triangle(4, new Point(9, 3), new Point(-4, -3), new Point(9, 5)));
        //when
        List<Shape> actual = triangleRepository.query(predicatePerimeterBetween);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testQuerySearchDistanceToShapeBetween(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = new ArrayList<>();
        expected.add(new Triangle(0, new Point(1, 1), new Point(3, 4), new Point(8, 35)));
        //when
        List<Shape> actual = triangleRepository.query(predicateDistanceToShapeBetween);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "testQuery", dataProviderClass = TriangleRepositoryTestData.class)
    public void testQuerySearchAllShapesInFirstKvadrant(TriangleRepository triangleRepository) {
        //given
        List<Shape> expected = new ArrayList<>();
        expected.add(new Triangle(0, new Point(1, 1), new Point(3, 4), new Point(8, 35)));
        expected.add(new Triangle(1, new Point(6, 4), new Point(6, 5), new Point(8, 4)));
        expected.add(new Triangle(3, new Point(6, 7), new Point(8, 5), new Point(8, 35)));
        //when
        List<Shape> actual = triangleRepository.query(predicateShapesInFirstKvadrant);
        //then
        Assert.assertEquals(expected, actual);
    }
}