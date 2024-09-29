# Write your MySQL query statement below
select t1.employee_id, t1.name, count(t2.reports_to) as reports_count, round(avg(t2.age)) as average_age
from employees t1
join employees t2
on t2.reports_to = t1.employee_id 
group by t1.employee_id, t1.name
order by t1.employee_id