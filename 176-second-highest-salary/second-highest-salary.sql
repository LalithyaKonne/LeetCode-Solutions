# Write your MySQL query statement below
with ranked as(
    select *,dense_rank() over(order by salary desc)as high_salary
    from Employee
)
select(
select distinct salary  
from ranked where high_salary=2
)as SecondHighestSalary;
