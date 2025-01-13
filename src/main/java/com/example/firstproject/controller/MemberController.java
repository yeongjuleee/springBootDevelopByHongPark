package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MemberController {
    // 3장 마무리, 셀프체크 136p 회원 가입 페이지로 이 페이지를 보기 및 처리하기 위한 컨트롤러, DTO, 엔티티, 리파지터리를 구현하기
    // 뷰 템플릿은 member 디렉토리 생성 후  `new.mustache` 를 이용

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUpPage() {
        return "members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm memberForm) {
        log.info("MemberForm DTO 값 :" + memberForm.toString()); // DTO에 폼 데이터가 잘 담겼는지 확인
        
        // 1. DTO를 엔티티로 변환
        Member member = memberForm.toEntity();
        log.info("Member Entity 값 : "+member.toString()); // DTO가 엔티티로 잘 변환되는지 확인하는 로그
        
        // 2. repository로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member); // member 엔티티를 저장해 saved 객체에 변환
        log.info("DB에 저장된 값 :" + saved.toString());

        return "";
    }
}
