package by.epam.kvirikashvili.task1_2.validator;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CoordinatesValidatorTest {
    //private static final Logger LOGGER = LogManager.getLogger(FileReader.class);
    private CoordinatesValidator coordinatesValidator;

    @BeforeTest
    public void before() {
        coordinatesValidator = new CoordinatesValidator();
    }

    @Test(dataProvider = "correctCoordinates", dataProviderClass = CoordinatesValidatorTestData.class)
    public void validateCoordinates_correctCoordinates_successValidate(String correctCoordinates) {
        //when
        boolean actual = coordinatesValidator.validateCoordinates(correctCoordinates);

        //then
        Assert.assertTrue(actual);
    }

    @Test(dataProvider = "incorrectCoordinates", dataProviderClass = CoordinatesValidatorTestData.class)
    public void validateCoordinates_incorrectCoordinates_unsuccessValidate(String incorrectCoordinates) {
        //when
        boolean actual = coordinatesValidator.validateCoordinates(incorrectCoordinates);

        //then
        Assert.assertFalse(actual);
    }
}
