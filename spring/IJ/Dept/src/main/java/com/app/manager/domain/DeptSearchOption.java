package com.app.manager.domain;


import lombok.*;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptSearchOption {

    private String searchType; // 부서이름 / 위치
    private String keyword; // 키워드

}
