package com.example.firstproject.dto;

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
}
