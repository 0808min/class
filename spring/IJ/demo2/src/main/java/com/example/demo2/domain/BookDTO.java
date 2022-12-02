package com.example.demo2.domain;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookDTO {

    private String bookISBN; // 도서 ISBN -- Primary Key
    private String bookTitle; // 도서 제목
    private String bookAuthor; // 도서 저자
    private String bookGenre; // 도서 장르
    private String bookPublisher; // 도서 출판사
    private String bookImage; // 도서 이미지
    private int bookCount; // 도서 재고수
    private String bookSummary; // 도서 한줄 줄거리
    private int bookHit; // 대여당한 횟수
    private Date bookDate; // 도서 추가 날짜
}
