package by.epam.kvirikashvili.task1_2.reader;

import by.epam.kvirikashvili.task1_2.exception.IncorrectInputFileException;

import java.util.List;

public interface CoordinatesReader {
    List<String> readCoordinates(String path) throws IncorrectInputFileException;
}
