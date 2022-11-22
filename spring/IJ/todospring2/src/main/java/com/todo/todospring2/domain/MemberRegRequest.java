package com.todo.todospring2.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MemberRegRequest {

    private String uid;
    private String pw;
    private String uname;
    private MultipartFile uphoto;




    public Member toMember() {
        Member member = Member.builder()
                .uname(this.uname)
                .pw(this.pw)
                .uid(this.uid)
                .build();

        return member;
    }

}
