package by.epam.kvirikashvili.task1_2.reader;

import by.epam.kvirikashvili.task1_2.exception.IncorrectInputFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader implements CoordinatesReader {
    public List<String> readCoordinates(String path) throws IncorrectInputFileException {
        Path filePath = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(filePath)) {
            return lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new IncorrectInputFileException("Incorrect reader file path", e);
        }
    }
}
