package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    // JPA에서 제공하는 리파지토리 인터페이스를 활용하여 CRUD(생성,조회,수정,삭제) 엔티티 기능을 관리하는 인터페이스를 상속받는다.
    // Article : 관리 대상 엔티티 클래스 타입
    // Long : 관리 대상 엔티티의 대푯값
}
