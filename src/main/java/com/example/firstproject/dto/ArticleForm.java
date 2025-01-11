package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class ArticleForm {
    // 컨트롤러에서 폼 데이터를 받을 때 DTO(Data Transfer Object) 담아 받음!

    // 각 항목을 받을 필드 생성
    private String title;
    private String content;

    public ArticleForm(String title, String content) { 
        // 전송받은 제목과 내용을 필드에 저장하는 생성자 추가
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        // 데이터를 잘 받았는지 확인할 toString() 메서드
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        // DTO인 form 객체를 엔티티로 변환하는 역할, 폼 데이터를 담은 DTO 객체를 엔티티로 반환한다.
        // 전달값은 Article 클래스의 생성자 형식에 맞게 작성한다. Article은 매개변수로 id, title, content 를 가지고 있다.
        return new Article(null, title, content); // ArticleForm 객체에 id 정보는 없기 때문에 첫 번째 id의 값은 null 이다.
    }
}
