-- 20221018

-- inline view - rownum
-- from 절 뒤에 오는 서브쿼리 -> inline view
-- select -> 결과도 테이블

select * from emp;

select rownum, emp.* from emp order by hiredate;

-- rownum : 사용자가 생성하는 컬럼이 아니다, 시스템에서 제공하는 컬럼

select rownum, t.*
from (select * from emp order by hiredate) t
;
-- top3
-- 입사일이 가장 오래된 3명을 구하자

select rownum, t.*
from (select * from emp order by hiredate) t
where rownum <= 3
;

-- my sql select * from emp order by hiredate (rownum = limit) 0, 3;







