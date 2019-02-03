package by.epam.kvirikashvili.task1_2.converter;

import by.epam.kvirikashvili.task1_2.entity.Shape;

import java.util.List;

public interface CoordinatesConverter {
    List<Shape> convertAllCoordinates(List<String> coordinates);
    Shape convertCoordinates(String coordinates);
}
