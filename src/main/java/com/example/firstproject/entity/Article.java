package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Article {
    @Id
    @GeneratedValue // 자동 생성 기능 추가 (숫자가 자동으로 매겨진다.)
    private Long id;

    @Column // title 필드 선언, DB 테이블의 title열과 연결된다.
    private String title;

    @Column
    private String content;

    public Article(Long id, String title, String content) {
        // Article 객체의 생성 및 초기화를 위한 생성자 추가하기
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        // 서버에 데이터가 잘 들어왔는지 확인하기 위한 메서드
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
