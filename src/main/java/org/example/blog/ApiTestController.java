package org.example.blog;

import lombok.RequiredArgsConstructor;
import org.example.blog.service.message.CoolMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiTestController {
    private final CoolMessageService coolMessageService;

    @GetMapping
    void test() {
        coolMessageService.send();
    }

}
