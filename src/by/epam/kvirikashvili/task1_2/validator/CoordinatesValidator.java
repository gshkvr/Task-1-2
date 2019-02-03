package by.epam.kvirikashvili.task1_2.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinatesValidator {

    private final String pattern = "^(\\([0-9]+(\\.[0-9]+)?\\,[0-9]+(\\.[0-9]+)?\\)){3}$";

    public boolean validateCoordinates(String coordinates) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(coordinates);
        return matcher.matches();
    }
}
