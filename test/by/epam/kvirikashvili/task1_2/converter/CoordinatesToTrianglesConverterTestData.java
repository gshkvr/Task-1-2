package by.epam.kvirikashvili.task1_2.converter;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesToTrianglesConverterTestData {
    @DataProvider(name = "correctCoordinates")
    public Object[] readCorrectCoordinates() {
        List<String> coordinates = new ArrayList<>();
        coordinates.add("(1,1)(2,2)(3,3)");
        coordinates.add("(2,2)(3,3)(4,4)");
        return new Object[]{coordinates};
    }

    @DataProvider(name = "incorrectCoordinates")
    public Object[] readIncorrectCoordinates() {
        List<String> coordinates = new ArrayList<>();
        coordinates.add("(1,1) 2,4 3,3");
        coordinates.add("2,2 3,3 (4,4)");
        return new Object[]{coordinates};
    }
}
