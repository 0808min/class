package com.todo.todospring.domain;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoDTO {

    private long tno;

    @NotEmpty
    private String todo;

    @Future
    private LocalDate dueDate;
    private boolean finished;

}
