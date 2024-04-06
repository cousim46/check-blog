package org.example.blog.scheduler;

import java.time.LocalDate;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.example.blog.service.blog.BlogService;
import org.example.blog.service.message.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BlogCheckScheduler {
    private final Map<String, BlogService> blogServiceMap;
    private final MessageService messageService;
    @Value("${blog.type}")
    private String blogType;
    @Value("${blog.url}")
    private String blogUrl;

    @Scheduled(cron = "0 0 0 ? * MON")
    public void checkBlog() {
        boolean isWrite = blogServiceMap.get(blogType.toLowerCase())
            .isBetween7DaysBlogWrite(blogUrl, LocalDate.now());
        if(!isWrite) {
            messageService.send();
        }
    }
}
