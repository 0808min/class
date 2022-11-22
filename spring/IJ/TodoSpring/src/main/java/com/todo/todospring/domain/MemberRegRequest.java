package com.todo.todospring.domain;

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
                .idx()
                .uuid()
                .pw()
                .uid()
                .uname()
                .uphoto()
                .build()
    }

}
