package library.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate stringToDate(String dateString) {
        return LocalDate.parse(dateString, formatter);
    }

    public static String dateToString(LocalDate date) {
        return date.format(formatter);
    }
}