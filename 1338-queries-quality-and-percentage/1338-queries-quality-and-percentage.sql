select query_name, round(avg(rating / position), 2) as quality, round(count(case when rating < 3 then 1 end) * 100 / count(rating), 2) as poor_query_percentage
from queries
where query_name is not null
group by query_name