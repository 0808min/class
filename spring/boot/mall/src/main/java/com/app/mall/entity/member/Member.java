package com.app.mall.entity.member;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "mall_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Integer ucd;

    @Column(nullable = false)
    private String uid;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String uname;

    @Column
    private String uphoto;



}
