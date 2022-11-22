package com.todo.todospring.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoDTO {

    private long tno;
    private String todo;
    private LocalDate dueDate;
    private boolean finished;

}
