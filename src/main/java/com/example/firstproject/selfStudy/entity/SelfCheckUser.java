package com.example.firstproject.selfStudy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SelfCheckUser {
    // 혼자 다시 셀프 체크 문제 복습해보기!

    // 1. 필드 생성
    @Id @GeneratedValue
    private Long id; // pk

    @Column
    private String name;

    @Column
    private String password;

    // 2. 객체를 초기화하고 값을 저장할 생성자 생성
    public SelfCheckUser(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // 3. 서버에서 엔티티에 값이 잘 들어갔는지 확인하기 위한 메서드
    @Override
    public String toString() {
        return "SelfCheckUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
