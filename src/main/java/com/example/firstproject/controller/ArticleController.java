package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j // 로깅 기능을 위한 어노테이션 추가
public class ArticleController {

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
        log.info("dto에 값이 담겼는지 확인 : " + form.toString()); // DTO에 폼 데이터가 잘 담겼는지 확인 => 로그 찍어서 보는 방식임.

        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info("dto가 entity로 변환 : " + article.toString()); // DTO가 엔티티로 잘 변환되는지 로그 찍어보기

        // 2. repository로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
        log.info("db 저장 완료 : " + saved.toString()); // article이 DB에 잘 저장되었는지 로그 찍어보기
        
        return "redirect:/articles/" + saved.getId(); // 리다이렉트를 작성할 위치, 작성방법 : redirect:URL_주소 + 새 글의 id
    }

    // 5.2 단일 데이터 조회하기, URL에 id값을 입력하여 해당 게시글 볼 수 있도록 만들기
    @GetMapping("/articles/{id}") // 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model) {
        // @PathVariable : URL 요청으로 들어온 전달값을 컨트롤러의 매개변수로 가져오는 어노테이션
        // 매개변수로 id 값 가져오기.
        log.info("id : " + id); // id 값을 잘 받아오는지 확인하는 로그

        // 1. id를 조회해 데이터 가져오기 : 데이터를 가지고 오는 주체는 Repository. repository 구현 객체는 @Autowired 를 통해 주입
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 모델에 데이터 등록하기 : show() 메서드의 매개변수로 model 객체를 가져오기
        model.addAttribute("article", articleEntity);

        // 3. 뷰 페이지 반환하기
        return "articles/show";
    }

    // 5.3 데이터 목록 조회하기
    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        
        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList); // articleEntityList 등록
        
        // 3. 뷰 페이지 설정하기
        return "articles/index";
    }
}
