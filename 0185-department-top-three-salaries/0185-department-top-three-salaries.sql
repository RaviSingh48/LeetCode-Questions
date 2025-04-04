# Write your MySQL query statement below
select Department,Employee ,Salary 
from
(select d.name as Department, e.name as Employee , e.Salary as Salary, 
dense_rank() over(partition by d.name order by e.salary desc) rnk 
from employee e  
join department d on d.id=e.departmentId 
order by d.id desc) as emp
where rnk <=3