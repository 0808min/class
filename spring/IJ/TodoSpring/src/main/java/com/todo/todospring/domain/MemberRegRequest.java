package com.todo.todospring.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberRegRequest {

    private String uid;
    private String pw;
    private String uname;
    private MultipartFile uphoto;

    public Member toMember() {
        Member member = Member.builder()
                .uid(this.uid)
                .pw(this.pw)
                .uname(this.uname)
                .build();
        return member;
    }

}
