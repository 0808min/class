
-- 문자함수

select ename, lower(ename) from emp;

select Upper('scott') from dual;

select initcap('scott') from dual;

-- substr (원본, 시작포인트 반활할 개수)
select substr('안녕하세요 박민입니다.', 2, 8) from dual;
select substr('안녕하세요 박민입니다.', 5) from dual;

select length('안녕하세요 박민입니다.') from dual;

-- lpad, rpad 특정 자리수를 지정하고, 자리수에 데이터가 없는경우 특정 패턴으로 채우는 함수
-- 00010, 00020, 00030, 00040
select dname, deptno, lpad(deptno, 5, '0'), rpad(deptno, 5, 'A')
from dept;

select '     ABC', trim('     ABC'),'ABC     ', trim('ABC     ')
from dual;

select replace('Steven King', 'Steven', 'S.'),replace('Steven King', 'Steven', '') -- 치환(바꾸는거)
from dual;

-- 숫자함수
select -10, abs(-10)
from dual;

select 2.1, 2.9, floor(2.9)
from dual;

select 1234.567, round(1234.527, 1), round(1234.527, -1), round(1234.567)
from dual;

select 1234.567, trunc(1234.567, 1), trunc(1234.567, -1),trunc(1234.567)
from dual;

select mod(1,3), mod(2,3), mod(3,3), mod(0,3), mod(3,0)
from dual;



-- 날짜함수

-- 현재날짜
select sysdate 
from dual;

select months_between(sysdate,'21/12/13') from dual;
select add_momths(sysdate, -6) from dual;
select next_day(sysdate, 7) from dual;
select last_day(sysdate) from dual;
select round(sysdate) from dual;
select trunc(sysdate) from dual;

