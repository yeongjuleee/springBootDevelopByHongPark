package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
public class MemberForm {
    // 컨트롤러에서 폼 데이터를 받을 때 사용하는 DTO로, 셀프체크 문제

    private String email;
    private String password;

    public Member toEntity() {
        // DTO인 form 객체를 엔티티로 변환하는 역할로 폼 데이터를 담은 DTO 객체를 엔티티로 반환한다.
        // 전달값은 Member 클래스의 생성자 형식에 맞게 작성(단, MemberForm은 id 값이 없으니 id 값은 null로)
        return new Member(null, email, password);
    }
}
