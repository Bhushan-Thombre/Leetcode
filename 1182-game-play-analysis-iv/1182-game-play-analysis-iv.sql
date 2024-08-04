# Write your MySQL query statement below
select round(sum(datediff(a.event_date, firstLogin.minDate) = 1) / count(distinct a.player_id) , 2) as fraction
from (select player_id, min(event_date) as minDate 
        from activity 
        group by player_id) firstLogin
join activity a
on a.player_id = firstLogin.player_id