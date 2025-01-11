package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    
    @Column
    private String email;
    
    @Column
    private String password;

    public Member(Long id, String email, String password) {
        // Member 객체의 생성 및 초기화를 위한 생성자
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        // 서버에 데이터가 잘 들어왔는지 확인하기 위한 메서드
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
