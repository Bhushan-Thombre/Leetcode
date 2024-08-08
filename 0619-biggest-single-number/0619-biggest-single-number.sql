# Write your MySQL query statement below


select max(d.num) as num
from (select num, count(num) as count
from mynumbers
group by num
order by num desc) d
where d.count = 1
