package org.example.blog.service.blog;

import java.time.LocalDate;
import org.example.blog.reader.WriteReader;
import org.springframework.stereotype.Service;

@Service(value = "tistory")
public class Tistoryservice implements BlogService {

    @Override
    public boolean isBetween7DaysBlogWrite(String blogUrl, LocalDate now) {
        String content = getContent(blogUrl);
        System.out.println("tisory");
        return WriteReader.isTistoryWrite(now, content);
    }
}
