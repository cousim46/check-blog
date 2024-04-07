package org.example.blog.service.blog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service(value = "tistory")
public class TistoryService implements BlogService {
    @Override
    public LocalDate findLastWroteAt(String html) {
        Document document = Jsoup.parse(html);
        String lastWroteAt = Objects.requireNonNull(document.selectFirst("#wrap > section > div > div > div:nth-child(1) > div > div > div.index-item-text > span")).text();
        return DateTimeFormatter.ofPattern("yyyy.MM.dd").parse(lastWroteAt, LocalDate::from);
    }
}
