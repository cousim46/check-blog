package org.example.blog.service.blog;

import java.time.LocalDate;
import org.example.blog.reader.WriteReader;
import org.springframework.stereotype.Service;

@Service(value = "velog")
public class VelogService implements BlogService{

    @Override
    public boolean isBetween7DaysBlogWrite(String blogUrl, LocalDate now) {
        String content = getContent(blogUrl);
        return WriteReader.isVelogWrite(now, content);
    }
}
