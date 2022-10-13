


-- 20221012

-- 사용 가능한 테이블 정보
select * from tab;

-- 테이블의 구조 확인
desc dept;


select ename --* 
from emp;

select deptno, job, sal, ename
from emp;

--select[distinct] 컬럼의 이름, 컬럼이름, ...
--from 테이블의 이름

select * from dept; -- 행을 선택하는 조건이 없기 떄문에 모든 행이 결과로 출력

select deptno, dname from dept;

select sal, nvl(comm, 0) from emp;

-- null : 정해지지 않은 값

-- select 의 표현영역에서는 산술연산이 가능하다
select sal + comm
from emp;

select sal, sal - 100 
from emp;

select sal * 12
from emp;

select sal / 2
from emp;


-- 사원 테이블에서 사원의 이름과 월 급여, 연봉을 출력
select ename, sal, sal*12
from emp;

select ename, sal, sal*12, sal*12+comm
from emp;

-- null의 값을 치환 해주는 함수 : nvl(원본데이터, null 일때 치환되는 값)
select ename, sal, sal*12 as yearSal1, sal*12+nvl(comm, 0) as yealSal2
from emp;

-- 문자열 연산
select ename || 'is a ' || job
from emp;

--distinct : 중복된 데이터를 생략하고 출력
select deptno
from emp;

select distinct deptno
from emp;

-- 행을 찾는 조건 
-- select 
-- from
-- where 조건식 <- 행을 찾는 조건식
-- 급여를 3000 이상 받는 사원의 이름과 직급 리스트
select ename, job
from emp
where sal >= 3000;

-- 부서테이블에서 부서 번호가 10번인 사원의 리스트를 출력
-- deptno = 10
select *
from emp
where deptno = 10;

-- 10번 부서 소속이 아닌 사원들의 리스트 출력
select * 
from emp
where deptno <> 10;

-- 이름으로 검색 => 문자열은 작은 따움표로 표시
-- ename = 'SCOTT'
-- 이름이 SCOTT 인 사원의 정보를 출력
select *
from emp
where ename = 'SCOTT';  -- 저장된 문자열은 대소문자를 구별하기 때문에 주의.

select *
from emp
where hiredate = '81/11/17'; -- 날짜 비교시에도 작은 따움표를 사용해서 비교

-- 논리연산 -> 비교연산을 여러개 사용해서 결과를 만든다.
-- and, or, not

-- 10번 부서의 매니저(직급)를 검색하자. emp
select *
from emp
where deptno = 10 and job = 'MANAGER';

-- 10번 부서에 소속한 사원들과 매니저들을 출력 or
select *
from emp
where deptno = 10 or job = 'MANAGER';


-- 10번 부서 소속이 아닌 사원들의 리스트 출력
select *
from emp
where not deptno = 10;

-- 10번 부서 소속인 사원들 중에서 직급이 MANAGER인 사람을 검색하여 
-- 사원명, 부서번호, 직급을 출력하려고 한다면 두 가지 조건을 제시해야 합니다
select ename, deptno, job
from emp
where deptno = 10 and job = 'MANAGER';

-- 10번 부서에 소속된 사원이거나 -> (or) 직급이 MANAGER인 사람을 검색하여 
-- 사원명, 부서번호, 직급을 출력합시다
select ename, deptno, job
from emp
where deptno = 10 or job = 'MANAGER';

-- 2000에서 3000 사이의 급여를 받는 사원
select *
from emp
where sal >= 2000 and sal <= 3000;

select *
from emp
where sal between 2000 and 3000;

-- 1987년에 입사한 사원 리스트
select *
from emp
where hiredate between '87/01/01' and '87/12/31';

-- 커미션이 300이거나 500이거나 1400인 사원을 검색하기
select *
from emp
where comm=300 or comm=500 or comm=1400 or comm=0;

select *
from emp
where comm in (300, 500, 1400, 0);

-- 이름검색 : ename = 'SC'
-- like키워드를 이용한 패턴 검색

-- 이름을 'F'로 시작하는 이름을 검색 
select *
from emp
-- where ename like 'F%'; -- %는 뒤에 뭐가와도 상관없음. 
-- where ename like '%N'; -- %가 앞에 붙으면 ??가 끝에있을때
where ename like 'S%';

-- 이름의 두번째 글자가 A인 사원 검색
select *
from emp
where ename like '__A%';
 
-- null 여부를 확인하는 is null
-- null = 비교연산자를 사용할 수 없다. = null X

-- 커미션을 받지않는 사원
select *
from emp
where comm is null or comm=0;

-- 커미션이 등록된 사원의 리스트
select *
from emp
where comm is not null ;

-- 결과 행의 정렬 : order by 컬럼 asc | desc
-- asc : 오름차순, 생략하면 기본 값
-- desc : 내림차순

-- 급여 컬럼을 기준 오름차순으로
select *
from emp
-- where
order by sal desc --asc
;

-- 사원 리스트를 이름순으로 출력
select *
from emp
order by ename desc;

-- 입사일이 가장 오래된 사원 순으로 사원의 리스트를 출력
select *
from emp
order by hiredate ;

-- 가장 최근 입사자부터 출력하는 리스트
select *
from emp
order by hiredate desc, job asc ;

select *
from emp
order by sal, ename desc;





