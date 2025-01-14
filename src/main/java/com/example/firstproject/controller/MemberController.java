package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class MemberController {
    // 3장 마무리, 셀프체크 136p 회원 가입 페이지로 이 페이지를 보기 및 처리하기 위한 컨트롤러, DTO, 엔티티, 리파지터리를 구현하기
    // 뷰 템플릿은 member 디렉토리 생성 후  `new.mustache` 를 이용

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String newMemberForm() { // 회원 가입 링크를 누르면 오는 링크
        return "members/new";
    }

    @GetMapping("/signup")
    public String signUpPage() {
        return "members/new";
    }

    @PostMapping("/members/new")
    public String join(MemberForm memberForm) {
        log.info("MemberForm DTO 값 :" + memberForm.toString()); // DTO에 폼 데이터가 잘 담겼는지 확인
        
        // 1. DTO를 엔티티로 변환
        Member member = memberForm.toEntity();
        log.info("Member Entity 값 : "+member.toString()); // DTO가 엔티티로 잘 변환되는지 확인하는 로그
        
        // 2. repository로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member); // member 엔티티를 저장해 saved 객체에 변환
        log.info("DB에 저장된 값 :" + saved.toString());

        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        // 1. 데이터를 리포지토리에
        Member memberEntity = memberRepository.findById(id).orElse(null);

        // 2. 모델 변환
        model.addAttribute("member", memberEntity);
        // 3. 뷰 반환
        return "members/show"; // 상세보기 페이지
    }

    @GetMapping("/members")
    public String index(Model model) {
        // 1. 데이터 묶음에 모든 데이터 가져오기
        List<Member> memberEntityList = memberRepository.findAll(); // 주의사항, ArrayList를 사용할 수 있도록 MemberRepository에서 CrudRepository의 메서드 findAll()을 Override 하여, Iterable 타입을 ArrayList로 바꿔 사용하기!

        // 2. 모델에 묶음 데이터 전달
        model.addAttribute("memberList", memberEntityList);

        // 3. 사용자 화면 반환
        return "members/index"; // 목록보기 페이지

    }
}
