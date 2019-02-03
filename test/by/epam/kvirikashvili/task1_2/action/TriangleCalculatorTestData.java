package by.epam.kvirikashvili.task1_2.action;

import by.epam.kvirikashvili.task1_2.entity.Point;
import by.epam.kvirikashvili.task1_2.entity.Triangle;
import org.testng.annotations.DataProvider;

public class TriangleCalculatorTestData {

    @DataProvider(name = "calculateSquareData")
    public Object[][] calculateSquareData() {
        return new Object[][]{
                {new Triangle(new Point(1, 3), new Point(1, 1), new Point(3, 1)), 1.9999999999999993},
                {new Triangle(new Point(1, 1), new Point(2, 3), new Point(3, 1)), 2.0},
                {new Triangle(new Point(1, 1), new Point(3, 4), new Point(2, 1)), 1.5000000000000002},
                {new Triangle(new Point(0, 0), new Point(1, 1.732050807568877), new Point(2, 0)), 1.7320508075688767}
        };
    }

    @DataProvider(name = "calculatePerimeterData")
    public Object[][] calculatePerimeterData() {
        return new Object[][]{
                {new Triangle(new Point(1, 3), new Point(1, 1), new Point(3, 1)), 6.82842712474619},
                {new Triangle(new Point(1, 1), new Point(2, 3), new Point(3, 1)), 6.47213595499958},
                {new Triangle(new Point(1, 1), new Point(3, 4), new Point(2, 1)), 7.767828935632369},
                {new Triangle(new Point(0, 0), new Point(1, 1.732050807568877), new Point(2, 0)), 5.999999999999999}
        };
    }

    @DataProvider(name = "isTriangle")
    public Object[][] isTriangle() {
        return new Object[][]{
                {new Triangle(new Point(1, 1), new Point(2, 2), new Point(3, 3)), false},
                {new Triangle(new Point(1, 1), new Point(3, 4), new Point(2, 1)), true},
                {new Triangle(new Point(0, 0), new Point(1, 1.732050807568877), new Point(2, 0)), true}
        };
    }

    @DataProvider(name = "isEquilateral")
    public Object[][] isEquilateral() {
        return new Object[][]{
                {new Triangle(new Point(1, 3), new Point(1, 1), new Point(3, 1)), false},
                {new Triangle(new Point(1, 1), new Point(2, 3), new Point(3, 1)), false},
                {new Triangle(new Point(1, 1), new Point(3, 4), new Point(2, 1)), false},
                {new Triangle(new Point(0, 0), new Point(1, 1.732050807568877), new Point(2, 0)), true}
        };
    }

    @DataProvider(name = "isIsosceles")
    public Object[][] isIsosceles() {
        return new Object[][]{
                {new Triangle(new Point(1, 3), new Point(1, 1), new Point(3, 1)), true},
                {new Triangle(new Point(1, 1), new Point(2, 3), new Point(3, 1)), true},
                {new Triangle(new Point(1, 1), new Point(3, 4), new Point(2, 1)), false},
                {new Triangle(new Point(0, 0), new Point(1, 1.732050807568877), new Point(2, 0)), true}
        };
    }

    @DataProvider(name = "isRectangular")
    public Object[][] isRectangular() {
        return new Object[][]{
                {new Triangle(new Point(1, 3), new Point(1, 1), new Point(3, 1)), true},
                {new Triangle(new Point(1, 1), new Point(2, 3), new Point(3, 1)), false},
                {new Triangle(new Point(1, 1), new Point(3, 4), new Point(2, 1)), false},
                {new Triangle(new Point(0, 0), new Point(1, 1.732050807568877), new Point(2, 0)), false}
        };
    }

    @DataProvider(name = "isSharpCornered")
    public Object[][] isSharpCornered() {
        return new Object[][]{
                {new Triangle(new Point(1, 3), new Point(1, 1), new Point(3, 1)), false},
                {new Triangle(new Point(1, 1), new Point(2, 3), new Point(3, 1)), true},
                {new Triangle(new Point(1, 1), new Point(3, 4), new Point(2, 1)), false},
                {new Triangle(new Point(0, 0), new Point(1, 1.732050807568877), new Point(2, 0)), true}
        };
    }

    @DataProvider(name = "firstXCoordinate")
    public Object[][] getFirstXCoordinate() {
        return new Object[][]{
                {new Triangle(new Point(1, 3), new Point(1, 1), new Point(3, 1)), 1},
                {new Triangle(new Point(1, 1), new Point(2, 3), new Point(3, 1)), 1},
                {new Triangle(new Point(1, 1), new Point(3, 4), new Point(2, 1)), 1},
                {new Triangle(new Point(0, 0), new Point(1, 1.732050807568877), new Point(2, 0)), 0}
        };
    }

    @DataProvider(name = "firstYCoordinate")
    public Object[][] getFirstYCoordinate() {
        return new Object[][]{
                {new Triangle(new Point(1, 3), new Point(1, 1), new Point(3, 1)), 3},
                {new Triangle(new Point(1, 1), new Point(2, 3), new Point(3, 1)), 1},
                {new Triangle(new Point(1, 1), new Point(3, 4), new Point(2, 1)), 1},
                {new Triangle(new Point(0, 0), new Point(1, 1.732050807568877), new Point(2, 0)), 0}
        };
    }

    @DataProvider(name = "allPointsInFirstKvadrant")
    public Object[][] isAllPointsInFirstKvadrant() {
        return new Object[][]{
                {new Triangle(new Point(1, 3), new Point(1, 1), new Point(3, 1)), true},
                {new Triangle(new Point(1, 1), new Point(2, 3), new Point(-3, 1)), false},
                {new Triangle(new Point(1, 1), new Point(3, 4), new Point(2, -1)), false},
                {new Triangle(new Point(0, 0), new Point(-1, -1.732050807568877), new Point(2, 0)), false}
        };
    }

    @DataProvider(name = "distanceToShape")
    public Object[][] getDistanceToShape() {
        return new Object[][]{
                {new Triangle(new Point(1, 3), new Point(1, 5), new Point(3, 1)), 3.1622776601683795},
                {new Triangle(new Point(1, 4), new Point(2, 3), new Point(3, 1)), 3.1622776601683795},
                {new Triangle(new Point(1, 7), new Point(3, 4), new Point(2, 1)), 2.23606797749979},
                {new Triangle(new Point(0, 0), new Point(1, 1.732050807568877), new Point(2, 0)), 0}
        };
    }
}
