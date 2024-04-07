package org.example.blog.service.blog;

import java.time.LocalDate;
import org.jsoup.Connection;
import org.jsoup.Jsoup;


public interface BlogService {
    default String getContent(String blogUrl)  {
        try {
            Connection connect = Jsoup.connect(blogUrl);
            return connect.get().body().toString();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    boolean isBetween7DaysBlogWrite(String blogUrl,LocalDate now);

    boolean isWrite(LocalDate now, String element);
}
