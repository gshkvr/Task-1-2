package by.epam.kvirikashvili.task1_2.converter;

import by.epam.kvirikashvili.task1_2.entity.Shape;
import by.epam.kvirikashvili.task1_2.entity.Triangle;
import by.epam.kvirikashvili.task1_2.validator.CoordinatesValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoordinatesToTrianglesConverter implements CoordinatesConverter {
    private final String splitRegex = "\\(|,|\\)";

    public List<Shape> convertAllCoordinates(List<String> coordinates) {
        List<Shape> triangles = new ArrayList<>();
        CoordinatesValidator coordinatesValidator = new CoordinatesValidator();
        for (String line : coordinates) {
            if (coordinatesValidator.validateCoordinates(line)) {
                Triangle triangle = convertCoordinates(line);
                triangles.add(triangle);
            }
        }
        return triangles;
    }

    public Triangle convertCoordinates(String coordinates) {
        List<String> strPoints = Arrays.asList(coordinates.split(splitRegex));
        Double[] points = strPoints.stream()
                .filter(str -> !str.isEmpty())
                .map(Double::parseDouble)
                .toArray(Double[]::new);
        return new Triangle(points);
    }
}
