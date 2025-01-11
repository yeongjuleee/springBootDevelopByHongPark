package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create") // URL 요청 접수
    public String createArticle(ArticleForm form) {
        // 폼에서 전송한 데이터를 createArticle 메서드의 매개변수로 받아오기 위해
        // DTO로 만든 클래스 이름 ArticleForm 타입의 form 객체를 매개변수로 선언
        System.out.println(form.toString()); // DTO에 폼 데이터가 잘 담겼는지 확인 => 로그 찍어서 보는 방식임.
        return "";
    }
}
