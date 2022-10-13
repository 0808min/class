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

