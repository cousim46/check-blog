package org.example.blog.service.blog;

import java.time.LocalDate;
import java.util.List;
import org.example.blog.convert.DateFormatConverter;
import org.springframework.stereotype.Service;

@Service(value = "tistory")
public class Tistoryservice implements BlogService {

    @Override
    public boolean isBetween7DaysBlogWrite(String blogUrl, LocalDate now) {
        String content = getContent(blogUrl);
        System.out.println("tisory");
        return isWrite(now, content);
    }

    @Override
    public boolean isWrite(LocalDate now, String element) {
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
}
