# Write your MySQL query statement below
with cons as(
    select num,
    lead(num,1) over() num1,
    lead(num,2) over() num2
    from logs
)
select distinct num as ConsecutiveNums 
from cons where (num=num1) and (num=num2)