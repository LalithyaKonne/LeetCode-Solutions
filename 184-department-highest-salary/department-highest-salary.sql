# Write your MySQL query statement below
select d.name as department,e.name as Employee,e.salary
from Employee e left join Department d
on e.departmentId=d.id
where (e.departmentId,e.salary) in(
    select departmentId,max(salary)
    from Employee 
    group by departmentId
);