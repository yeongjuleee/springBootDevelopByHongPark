package com.example.firstproject.selfStudy.dto;

import com.example.firstproject.selfStudy.entity.SelfCheckUser;

public class SelfCheckUserForm {
    // 1. 값을 전달하기 위한 필드 생성
    private String name;
    private String password;

    // 2. 전달 받을 값을 저장할 생성자 생성
    public SelfCheckUserForm(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // 3. 전달 받은 값이 서버에 잘 전달 되었는지 확인하기 위한 메서드
    @Override
    public String toString() {
        return "SelfCheckUserForm{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // 4. DTO를 엔티티로 변환하기
    public SelfCheckUser toEntity() {
        return new SelfCheckUser(null, name, password); // SelfCheckUserForm 객체에 id 값이 선언 X => null, 그 다음은 필드에 있으니 다 받아오기
    }
}
