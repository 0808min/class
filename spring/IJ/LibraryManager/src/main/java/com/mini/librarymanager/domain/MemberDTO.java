package com.mini.librarymanager.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDTO {

   private String email;
   private String password;
   private String name;
   private int rank;

}
