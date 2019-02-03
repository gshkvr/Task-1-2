package by.epam.kvirikashvili.task1_2.input;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class FileReaderTestData {
    @DataProvider(name = "correctPath")
    public Object[][] readCorrectPath() {
        List<String> coordinatesCorrect = new ArrayList<>();
        coordinatesCorrect.add("(1,3)(1,1)(3,1)");
        coordinatesCorrect.add("(1,1)(2,3)(3,1)");
        coordinatesCorrect.add("(1,1)(3,4)(2,1)");
        coordinatesCorrect.add("(0,0)(1,1.732050807568877)(2,0)");
        List<String> coordinatesMixed = new ArrayList<>();
        coordinatesMixed.add("(1,1)(2,5)(5,3)");
        coordinatesMixed.add("z(1,1) (2,5) (5,3)");
        coordinatesMixed.add("(1,1) (2,5)");
        coordinatesMixed.add("(1,1)(2,5)(4,3)");

        return new Object[][]{
                {"./files/correctCoordinates.txt", coordinatesCorrect},
                {"./files/mixedCoordinates.txt", coordinatesMixed}
        };
    }

    @DataProvider(name = "incorrectPath")
    public static Object[] readIncorrectPath() {
        return new Object[]{
                "./files/corr444ectCoordinates.txt"
        };
    }
}
