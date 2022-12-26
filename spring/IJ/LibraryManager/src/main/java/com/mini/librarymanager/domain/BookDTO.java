package com.mini.librarymanager.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookDTO {

    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int count;
    private String summary;
    private String image;
}
