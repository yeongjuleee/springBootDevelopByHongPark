package com.example.firstproject.repository;

import com.example.firstproject.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<Member, Long> {
    @Override
    ArrayList<Member> findAll(); // Override : 상속 받은 메서드를 자식 클래스에서 재정의하여 사용하는 것
}
