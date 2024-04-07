package org.example.blog.service.blog;

import java.time.LocalDate;

public interface BlogService {
    LocalDate findLastWroteAt(String html);
}
