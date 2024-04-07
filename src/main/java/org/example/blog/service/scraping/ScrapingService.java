package org.example.blog.service.scraping;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ScrapingService {
    public String getHtml(String blogUrl) throws IOException {
        Connection connect = Jsoup.connect(blogUrl);
        return connect.get().body().toString();
    }
}
