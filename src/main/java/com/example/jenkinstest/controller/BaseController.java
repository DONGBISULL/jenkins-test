package com.example.jenkinstest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
public class BaseController {

    private final ServletContext servletContext;

    @GetMapping("/")
    protected String index(Model model) {
        String serverInfo = servletContext.getServerInfo();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        model.addAttribute("serverInfo", serverInfo);
        model.addAttribute("today", formattedDate);
        return "index";
    }

}
