select w1.id
from Weather as w1, Weather as w2
where datediff(w1.recordDate, w2.recordDate) = 1 and w1.Temperature > w2.Temperature;