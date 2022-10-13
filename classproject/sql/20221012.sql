select sal, comm
from emp;

select sal, ifnull(comm, 0)
from emp;

select sal+100
from emp;

select ename, job
from emp;

select concat(ename, ' is a ', job)
from emp;