package com.firstcoding.mvc.springmvc.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserRequest {
    private LocalDate date;

//    public void setDate(String date){
//        this.date = LocalDate.parse(date);
//    }


}
