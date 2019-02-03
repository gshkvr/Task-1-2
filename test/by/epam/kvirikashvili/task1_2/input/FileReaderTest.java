package by.epam.kvirikashvili.task1_2.input;

import by.epam.kvirikashvili.task1_2.exception.IncorrectInputFileException;
import by.epam.kvirikashvili.task1_2.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class FileReaderTest {
    //private static final Logger LOGGER = LogManager.getLogger(FileReader.class);
    private FileReader coordinatesReader;

    @BeforeClass
    public void before() {
        coordinatesReader = new FileReader();
    }

    @Test(dataProvider = "correctPath", dataProviderClass = FileReaderTestData.class)
    public void readCoordinates_correctPath_coordinatesRead(String path, List<String> expected) throws IncorrectInputFileException {
        //when
        List<String> actual = coordinatesReader.readCoordinates(path);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(dataProvider = "incorrectPath", dataProviderClass = FileReaderTestData.class,
            expectedExceptions = IncorrectInputFileException.class)
    public void readCoordinates_correctPath_getException(String path) throws IncorrectInputFileException {
        //when
        List<String> actual = coordinatesReader.readCoordinates(path);
    }

}
