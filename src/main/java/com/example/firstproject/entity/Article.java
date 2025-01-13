package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor // Article() 생성자를 대체하는 어노테이션
@Getter
@ToString // toString() 메서드를 대체하는 어노테이션
public class Article {
    @Id
    @GeneratedValue // 자동 생성 기능 추가 (숫자가 자동으로 매겨진다.)
    private Long id;

    @Column // title 필드 선언, DB 테이블의 title 열과 연결된다.
    private String title;

    @Column
    private String content;
}
