package com.app.mall.domain.member;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberRegRequest {

    private String uid;
    private String password;
    private String uname;
    private MultipartFile uphoto;



}
