package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    /* JPA 에서 제공하는 리파지토리 인터페이스를 활용하여 CRUD(생성,조회,수정,삭제) 엔티티 기능을 관리하는 인터페이스를 상속받는다.
     Article : 관리 대상 엔티티 클래스 타입, Long : 관리 대상 엔티티의 대푯값
     ArticleRepository 는 CrudRepository 를 상속받고 있음. 데이터 모음을 보기 위해서는 findAll() 메서드가 필요한데, 이것은 Crud.. 가 가지고 있음.
     따라서 @Override 를 하여 사용하도록 함. */

    @Override
    ArrayList<Article> findAll(); // Override : 상위 클래스가 가지고 있는 메서드를 하위 클래스가 재정의해서 사용 -> Iterable 타입을 ArrayList 로 변경.
}
