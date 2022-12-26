package com.app.board.domain;

<<<<<<< HEAD

=======
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
<<<<<<< HEAD
@Builder
@ToString
=======
@ToString
@Builder
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
public class BoardDTO {

    private int bno;
    private String title;
    private String content;
    private String writer;
    private String photo;
    private LocalDate regdate;
    private LocalDate updatedate;


<<<<<<< HEAD

=======
>>>>>>> 3aa1e3fdc5efc0706080da8a500529ce5ee28135
}
