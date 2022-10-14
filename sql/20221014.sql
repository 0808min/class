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

-- 테이블 별칭을 이용해서 컬럼 구별 
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno
;

-- using, natural
select * 
from emp e inner join dept d
on e.deptno = d.deptno;

select * 
from emp e inner join dept d
using(deptno);

select deptno
from emp e inner join dept d
using(deptno);

select *
from emp natural join dept
;

-- inner 를 빼도 된다
select * from emp join dept
on emp.deptno = dept.deptno;


-- self join : 자기 자신의 테이블과 조인
-- emp -> mgr : 상사의 사원번호
select ename, mgr from emp;

select ename from emp where empno=7839;

-- 각 사원들의 이름과 상사의 이름을 출력
select e1.ename as "사원이름", e2.ename as "상사이름"
from emp e1 , emp e2
where e1.mgr = e2.empno(+)
;

-- mysql
select e1.ename, e2.ename
from emp e1 left outer join emp e2
on e1.mgr = e2.empno
;
-- 좌우 변경
select e1.ename, e2.ename
from emp e1 right outer join emp e2
on e1.empno = e2.mgr
;

-- 'SCOTT' 사원의 사원번호와 이름, 직급, 부서이름, 부서위치를 출력
-- emp = 사원번호, 이름, 직급
-- dept = 부서이름, 위치

select empno, ename, job, dname, loc
from emp e, dept d
where e.deptno = d.deptno
      and e.ename = 'SCOTT'
;

-- inner join(mysql)
select empno, ename, job, dname, loc
from emp e join dept d
on e.deptno = d.deptno
where ename = 'SCOTT'
;

-- salgrade 테이블을 참조해서 사원들의 사번, 이름, 급여 등급을 출력
select * 
from salgrade;

select ename, losal, sal, hisal, grade
from emp e, salgrade s 
where e.sal between s.losal and s.hisal
;

--my sql

select ename, losal, sal, hisal, grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal
;

-- 판매내역 : 판매정보, 판매서적의 정보, 고객의 정보

desc orders;
desc customer;

select orders.orderdate, customer.name, book.bookname, book.price, orders.saleprice
from book, customer, orders
where orders.custid = customer.custid and orders.bookid = book.bookid

order by orders.orderdate desc
;

-- mysql
select o.orderdate, c.name, b.bookname, b.price, o.saleprice
from orders o join customer c
on o.custid = c.custid
join book b
on o.bookid = b.bookid
where name = '박지성'
;

select *from customer;

select c.name, count(*) as "구매회수"
from orders o join customer c
on o.custid = c.custid
join book b
on o.bookid = b.bookid


group by c.name
;







