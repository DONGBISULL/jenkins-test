package com.example.jenkinstest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;

@Controller
@RequiredArgsConstructor
public class BaseController {

    private final ServletContext servletContext;

    @GetMapping("/")
    protected String index(Model model) {
        String serverInfo = servletContext.getServerInfo();
        model.addAttribute("serverInfo", serverInfo);
        return "index";
    }

}
