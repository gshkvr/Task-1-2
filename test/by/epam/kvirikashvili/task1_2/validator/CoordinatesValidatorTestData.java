package by.epam.kvirikashvili.task1_2.validator;

import org.testng.annotations.DataProvider;

public class CoordinatesValidatorTestData {
    @DataProvider(name = "correctCoordinates")
    public Object[] validateCorrectCoordinates() {
        return new Object[]{"(1,1)(2,5)(5,3)"};
    }

    @DataProvider(name = "incorrectCoordinates")
    public Object[] validateIncorrectCoordinates() {
        return new Object[]{"1,1 2,3 (3,4)"};
    }

}
