package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") // URL 요청 접수. 이것이 없으면 URL을 찾을 수 없어서 404가 나옴
    public String niceToMeetYou() {
        return "greetings";
    }
}
