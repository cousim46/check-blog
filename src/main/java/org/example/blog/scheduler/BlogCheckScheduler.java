package org.example.blog.scheduler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.example.blog.service.blog.BlogService;
import org.example.blog.service.message.MessageService;
import org.example.blog.service.scraping.ScrapingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BlogCheckScheduler {
    private final Map<String, BlogService> blogServiceMap;
    private final MessageService messageService;
    private final ScrapingService scrapingService;
    @Value("${blog.type}")
    private String blogType;
    @Value("${blog.url}")
    private String blogUrl;

    @Scheduled(cron = "0 0 0 ? * MON")
    public void checkBlog() {
        try {
            LocalDate now = LocalDate.now();
            String html = scrapingService.getHtml(blogUrl);
            BlogService blogService = blogServiceMap.get(blogType.toLowerCase());
            LocalDate lastWroteAt = blogService.findLastWroteAt(html);
            if(now.isAfter(lastWroteAt.plusDays(7))) {
                messageService.send();
            }
        } catch (Exception e) {
            if (e instanceof IOException) {
                System.out.println("HTML을 가져오는데 실패했습니다.");
                e.printStackTrace();
            } else {
                System.out.println("알 수 없는 에러가 발생했습니다.");
                e.printStackTrace();
            }
        }
    }
}
