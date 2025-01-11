package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    // 3.3.3 리파지터리로 엔티티를 DB에 저장하기(119p)
    @Autowired // 스프링부트가 미리 생성해 놓은 repository 객체 주입(DI: 의존성 주입, Dependency Injection). 스프링 부트가 아니면 ~new ArticleRepositoryImpl() 와 같은 구현체를 생성해야함.
    private ArticleRepository articleRepository; // articleRepository 객체 선언

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create") // URL 요청 접수
    public String createArticle(ArticleForm form) {
        // 폼에서 전송한 데이터를 createArticle 메서드의 매개변수로 받아오기 위해
        // DTO로 만든 클래스 이름 ArticleForm 타입의 form 객체를 매개변수로 선언
        System.out.println(form.toString()); // DTO에 폼 데이터가 잘 담겼는지 확인 => 로그 찍어서 보는 방식임.
        
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println(article.toString()); // DTO가 엔티티로 잘 변환되는지 로그 찍어보기 
        // 2. repository로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
        System.out.println(saved.toString()); // article이 DB에 잘 저장되었는지 로그 찍어보기
        
        return "";
    }
}
