package com.app.emp.domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpDTO {

    private int empno;
    private String ename;
    private String job;
    private String mgr;
    private String hiredate;
    private String sal;
    private String comm;
    private String deptno;


}
