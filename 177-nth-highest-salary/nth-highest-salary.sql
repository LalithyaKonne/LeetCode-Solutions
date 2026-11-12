CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      with ranked as(
        select *,dense_rank() over(order by salary desc)as nth_salary
        from Employee
      )
      select(
        select distinct salary
        from ranked where nth_salary=n
      )as getNthHighestSalary
  );
END