-- 20221014

-- join : 관계있는 테이블의 스키마를 붙이는 것
select *
from emp, dept
where emp.deptno = dept.deptno
;
-- mysql
-- select *from emp, CROSS JOIN dept;

-- 14 * 4 = cross join의 결과 행
select emp.ename, dept.dname
from emp, dept
where emp.deptno = dept.deptno
;

-- 생략가능
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno
;









