package org.example.blog.service.blog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service(value = "velog")
public class VelogService implements BlogService {
    @Override
    public LocalDate findLastWroteAt(String html) {
        Document document = Jsoup.parse(html);
        String lastWroteAt = Objects.requireNonNull(document.selectFirst("body > div > div.BasicLayout_block__6bmSl > div.responsive_mainResponsive___uG64 > main > div > section > div.VelogPosts_block__nfCQF > div.FlatPostCardList_block__VoFQe > div:nth-child(1) > div.FlatPostCard_subInfo__cT3J6 > span:nth-child(1)")).text();
        return DateTimeFormatter.ofPattern("yyyy년 M월 d일").parse(lastWroteAt, LocalDate::from);
    }
}
