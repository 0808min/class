package com.mini.librarymanager.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDTO {

   private String memberEmail; // 사용자 이메일
   private String memberPassword; // 사용자 비밀번호
   private String memberName; // 사용자 이름
   private int memberRank; // 사용자 랭크
   private int memberNormalReturn; // 사용자 정상 반납 숫자
   private int memberReturnAvailable; // 사용자 대여 가능 숫자

}
