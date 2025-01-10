package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") // URL 요청 접수. 이것이 없으면 URL을 찾을 수 없어서 404가 나옴
    public String niceToMeetYou(Model model) { // model 객체 받아오기
        model.addAttribute("username", "영"); // model.addAttribute("변수명", 변숫값)
        return "greetings";
    }

    @GetMapping("/bye") // URL 요청 접수
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "녕"); // model 변수 등록하기
        return "goodbye";
    }
}
