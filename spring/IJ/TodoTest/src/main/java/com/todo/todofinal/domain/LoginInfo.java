package com.todo.todofinal.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginInfo {

    private String uid;
    private String uname;
    private String uphoto;

}
