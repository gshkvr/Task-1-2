package by.epam.kvirikashvili.task1_2.converter;

import by.epam.kvirikashvili.task1_2.entity.Point;
import by.epam.kvirikashvili.task1_2.entity.Shape;
import by.epam.kvirikashvili.task1_2.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesToTrianglesConverterTest {
    //private static final Logger LOGGER = LogManager.getLogger(FileReader.class);
    private CoordinatesToTrianglesConverter coordinatesConverter;

    @BeforeTest
    public void before(){
        coordinatesConverter = new CoordinatesToTrianglesConverter();
    }

    @Test(dataProvider = "correctCoordinates", dataProviderClass = CoordinatesToTrianglesConverterTestData.class)
    public void readCoordinates_correctCoordinates_successConvertation(List<String> correctCoordinates) {
        //given
        List<Shape> expected = new ArrayList<>();
        expected.add(new Triangle(0, new Point(1, 1), new Point(2, 2), new Point(3, 3)));
        expected.add(new Triangle(1, new Point(2, 2), new Point(3, 3), new Point(4, 4)));
        //when
        List<Shape> actual = coordinatesConverter.convertAllCoordinates(correctCoordinates);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "incorrectCoordinates", dataProviderClass = CoordinatesToTrianglesConverterTestData.class)
    public void readCoordinates_incorrectCoordinates_successConvertation(List<String> incorrectCoordinates) {
        //given
        List<Shape> expected = new ArrayList<>();
        //when
        List<Shape> actual = coordinatesConverter.convertAllCoordinates(incorrectCoordinates);
        //then
        Assert.assertEquals(expected, actual);
    }

}
