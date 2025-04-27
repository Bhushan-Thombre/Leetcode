with studentIdTable as (
    select id, student, row_number() over (order by id) as rn
    from seat
)

select s1.id,
    case when s1.id % 2 = 1 and s2.id is not null then s2.student
        when s1.id % 2 = 1 and s2.id is null then s1.student
        else s2.student end as student
from studentIdTable s1
left join studentIdTable s2
on (s1.id % 2 = 1 and s1.id + 1 = s2.id)
or (s1.id % 2 = 0 and s1.id - 1 = s2.id)