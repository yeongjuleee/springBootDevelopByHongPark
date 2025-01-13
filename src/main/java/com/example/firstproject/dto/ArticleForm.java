package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.*;

@AllArgsConstructor // 생성자를 자동으로 만들어주는 코드. 이것이 없으면 생성자를 따로 작성해야함!
@ToString // 코드가 제대로 작동하는지 로그 찍어보기 위한 코드. 이것이 없으면 toString() 메서드를 따로 생성해야함!
@Getter // 값을 받아 전달해야 하기 때문에 Getter 선언
public class ArticleForm {
    // 컨트롤러에서 폼 데이터를 받을 때 DTO(Data Transfer Object) 담아 받음!

    // 각 항목을 받을 필드 생성
    private String title;
    private String content;


    public Article toEntity() {
        // DTO인 form 객체를 엔티티로 변환하는 역할, 폼 데이터를 담은 DTO 객체를 엔티티로 반환한다.
        // 전달값은 Article 클래스의 생성자 형식에 맞게 작성한다. Article은 매개변수로 id, title, content 를 가지고 있다.
        return new Article(null, title, content); // ArticleForm 객체에 id 정보는 없기 때문에 첫 번째 id의 값은 null 이다.
    }
}
