package com.firstcoding.mvc.springmvc.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {

    private String zipcode;
    private String address1;
    private String address2;
}
