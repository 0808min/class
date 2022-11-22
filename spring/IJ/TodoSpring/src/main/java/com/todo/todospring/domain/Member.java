package com.todo.todospring.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {

    private int idx;
    private String uid;
    private String pw;
    private String uuid;
    private String uname;
    private String uphoto;

    public LoginInfo toLoginInfo(){
        return LoginInfo.builder()
                .uid(this.uid)
                .uname(this.uname)
                .uphoto(this.uphoto)
                .build();
    }

}
