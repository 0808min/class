-- 2022.10.19

-- Transaction : 일의 단위 => 여러 DML 들을 묶어둔것
-- commit : 작업의 완료 => 데이터의 물리적 저장
-- rollback : 작업실패 => 마지막 물리적 저장 상태로 복귀

drop table dept02;
create table dept02
as
select * from dept;

-- DDL 작업 후 자동 commit

select * from dept02;
-- 트렌젝션 시작
insert into dept02 values (50, '개발', '서울');
insert into dept02 values (60, '기획', '판교');
update dept02 set loc = '제주' where deptno = 60;

rollback;
commit;

-----------------------------------------------------------------

-- 가상테이블 view
-- 데이터를 제한 할 수 있고, 복잡한 sql을 단순하게 처리 할 수 있다
select empno, ename, deptno from emp where deptno=30;

-- View 생성
create or replace view emp_view30
as
select empno, ename, deptno from emp where deptno=30;

select * from emp_view30 where ename = 'JAMES';

select view_name, text from user_views;

drop view emp_view30;




























