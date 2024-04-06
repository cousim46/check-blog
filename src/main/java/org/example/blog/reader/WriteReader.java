package org.example.blog.reader;

import java.time.LocalDate;
import java.util.List;
import org.example.blog.convert.DateFormatConverter;

public class WriteReader {


    public static boolean isTistoryWrite(LocalDate now, String element) {
        for (int i = 1; i <= 7; i++) {
            LocalDate localDate = now.minusDays(i);
            List<String> convertDates = DateFormatConverter.convertTistoryDateToString(localDate);
            boolean isWrite = convertDates.stream().filter(element::contains).count() > 0;
            if (isWrite) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVelogWrite(LocalDate now, String element) {
        for (int i = 1; i <= 7; i++) {
            LocalDate localDate = now.minusDays(i);
            List<String> convertDates = DateFormatConverter.convertVelogDateToString(localDate);
            boolean isWrite = convertDates.stream().filter(element::contains).count() > 0;
            if (isWrite) {
                return true;
            }
        }
        return false;
    }

}
