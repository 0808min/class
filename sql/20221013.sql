

select ename, lower(ename) from emp;


-- 문자함수
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

-- 변환함수

-- to_char(원본, 'formet') 2022. 10. 13 14:39 
-- date -> varchar2
select sysdate, 
       to_char(sysdate, 'YYYY-MM-DD'), 
       to_char(sysdate, 'YYYY.MM.DD'),
       to_char(sysdate, 'YYYY.MM.DD. HH24:MI:SS')
from dual;

-- number -> varchar2
select to_char(123456789, '000,000,000,000'), 
       to_char(123456789, '999,999,999,999'),
       to_char(123456789, 'L999,999,999,999')
from dual;

select ename, sal, to_char(sal*1400, 'L999,999,999,999')
from emp;

-- vardate2 => date 
-- to_date(문자열, '날짜형식')
-- 1999-12-13
select to_date ('1999-12-13', 'YYYY-MM-DD')
from dual;

-- vardate2 => number
select 
   to_number('20,000','999,999') - to_number('10,000','999,999')
from dual;

-- dcode 함수 => 여러가지 비교를 통해 결과 출력 swich-case 유사
select 
   ename,
   deptno,
   decode( deptno, 10, 'ACCOUNTING'
                , 20, 'RESEARCH'
                , 30, 'SALES'
                , 40, 'OPERATIONS'
   ) as dname
from emp;

select distinct job from emp;
-- 8. 직급에 따라 급여를 인상하도록 하자. 
-- 직급이 'ANALYST'인 사원은 5%, 
-- 'SALESMAN'인 사원은 10%, 
-- 'MANAGER'인 사원은 15%,
-- 'CLERK'인 사원은 20%인 인상한다. 

select 
    ename, job, sal,
    nvl(
    decode( job, 'ANALYST', sal*1.05,
                 'SALESMAN', sal*1.1,
                 'MANAGER', sal*1.15,
                 'CLERK', sal*1.2
    ),sal) as upSal
from emp;

-- case ~ when ~ then
select ename, deptno,
    case when deptno=10 then 'accounting'
         when deptno=20 then 'research'
         when deptno=30 then 'sales'
         when deptno=40 then 'operations'
    end as dname
from emp;


































