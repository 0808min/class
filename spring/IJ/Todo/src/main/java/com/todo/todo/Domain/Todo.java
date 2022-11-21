package com.todo.todo.Domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Todo {

    private long tno;
    private String tname;
    private String dueDate;
    private boolean finished;

}
