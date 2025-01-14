package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString
@Getter // 외부의 데이터를 읽기 위해 추가한 어노테이션
public class Member {

    @Id @GeneratedValue
    private Long id;
    
    @Column
    private String email;
    
    @Column
    private String password;

}
