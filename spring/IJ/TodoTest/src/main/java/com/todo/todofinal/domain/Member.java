package com.todo.todofinal.domain;


import lombok.*;


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


}
