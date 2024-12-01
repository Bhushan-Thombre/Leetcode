select employee_id, department_id from 
(select employee_id, department_id, count(employee_id) over(partition by employee_id) as c, primary_flag
from employee) as e
where e.primary_flag = 'Y' or e.c = 1;

