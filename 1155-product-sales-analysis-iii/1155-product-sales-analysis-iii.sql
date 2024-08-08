# Write your MySQL query statement below
select s.product_id, s.first_year, m.quantity, m.price
from (select distinct product_id, min(year) over (partition by product_id) as first_year
        from sales) s
join sales m 
on s.product_id = m.product_id
and s.first_year = m.year