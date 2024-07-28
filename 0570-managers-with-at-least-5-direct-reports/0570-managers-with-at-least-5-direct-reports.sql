select m.name
from employee m, employee e
where e.managerId = m.id
group by e.managerId
having count(e.managerId) >= 5