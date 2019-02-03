package by.epam.kvirikashvili.task1_2.action;

import by.epam.kvirikashvili.task1_2.entity.Shape;
import by.epam.kvirikashvili.task1_2.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TriangleCalculatorTest {
    //private static final Logger LOGGER = LogManager.getLogger(FileReader.class);
    private TriangleCalculator triangleCalculator;

    @BeforeTest
    public void before() {
        triangleCalculator = TriangleCalculator.INSTANCE;
    }

    @Test(dataProvider = "calculateSquareData", dataProviderClass = TriangleCalculatorTestData.class)
    public void testCalculateSquare(Shape triangle, double expected) {
        //when
        double actual = triangleCalculator.calculateSquare(triangle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "calculatePerimeterData", dataProviderClass = TriangleCalculatorTestData.class)
    public void testCalculatePerimeter(Shape triangle, double expected) {
        //when
        double actual = triangleCalculator.calculatePerimeter(triangle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "isTriangle", dataProviderClass = TriangleCalculatorTestData.class)
    public void testIsTriangle(Triangle triangle, boolean expected) {
        //when
        boolean actual = triangleCalculator.isTriangle(triangle.getPoints());
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "isEquilateral", dataProviderClass = TriangleCalculatorTestData.class)
    public void testIsEquilateral(Triangle triangle, boolean expected) {
        //when
        boolean actual = triangleCalculator.isEquilateral(triangle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "isIsosceles", dataProviderClass = TriangleCalculatorTestData.class)
    public void testIsIsosceles(Triangle triangle, boolean expected) {
        //when
        boolean actual = triangleCalculator.isIsosceles(triangle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "isRectangular", dataProviderClass = TriangleCalculatorTestData.class)
    public void testIsRectangular(Triangle triangle, boolean expected) {
        //when
        boolean actual = triangleCalculator.isRectangular(triangle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "isSharpCornered", dataProviderClass = TriangleCalculatorTestData.class)
    public void testIsSharpCornered(Triangle triangle, boolean expected) {
        //when
        boolean actual = triangleCalculator.isSharpCornered(triangle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "firstXCoordinate", dataProviderClass = TriangleCalculatorTestData.class)
    public void testGetFirstXCoordinate(Triangle triangle, double expected) {
        //when
        double actual = triangleCalculator.getFirstXCoordinate(triangle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "firstYCoordinate", dataProviderClass = TriangleCalculatorTestData.class)
    public void testGetFirstYCoordinate(Triangle triangle, double expected) {
        //when
        double actual = triangleCalculator.getFirstYCoordinate(triangle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "allPointsInFirstKvadrant", dataProviderClass = TriangleCalculatorTestData.class)
    public void testIsAllPointsInFirstKvadrant(Triangle triangle, boolean expected) {
        //when
        boolean actual = triangleCalculator.isAllPointsInFirstKvadrant(triangle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "distanceToShape", dataProviderClass = TriangleCalculatorTestData.class)
    public void testGetDistanceToShape(Triangle triangle, double expected) {
        //when
        double actual = triangleCalculator.getDistanceToShape(triangle);
        //then
        Assert.assertEquals(expected, actual);
    }

}
