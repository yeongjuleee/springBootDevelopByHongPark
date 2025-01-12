package com.example.firstproject.selfStudy.controller;

import com.example.firstproject.selfStudy.dto.SelfCheckUserForm;
import com.example.firstproject.selfStudy.entity.SelfCheckUser;
import com.example.firstproject.selfStudy.repository.SelfCheckUserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SelfCheckController02 {

    SelfCheckUserRepository selfCheckUserRepository;

    @GetMapping("/self/join")
    public String selfCheck02() {
        return "selfCheck/selfCheck02"; // templates의 selfCheck 디렉토리 아래에 있는 selfCheck02를 반환
    }

    @PostMapping("/self/136p")
    public String selfCheckJoin(SelfCheckUserForm form) {
        System.out.println("SelfCheckUserForm DTO를 잘 받았습니다 : " + form.toString());

        // 1. DTO를 엔티티로 변환시켜주기
        SelfCheckUser selfCheckUser = form.toEntity();
        System.out.println("selfCheckUser 엔티티로 잘 변환했습니다 : " + selfCheckUser.toString());

        // 2. Repository
        SelfCheckUser saved = selfCheckUserRepository.save(selfCheckUser); // 엔티티를 저장하기 위한 객체 생성. selfCheckUserRepository를 이용하여 저장한다.
        System.out.println("selfCheckUser 엔티티가 성공적으로 저장 되었습니다 : " + saved.toString());

        return "";
    }
}
