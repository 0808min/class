package com.todo.todospring.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberRegRequest {

    @NotEmpty(message = "uid는 필수 항목")
    private String uid;

    @NotEmpty
    private String pw;

    @NotEmpty
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
