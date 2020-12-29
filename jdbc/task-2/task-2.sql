select * from listexpenses.expenses;
select * from listexpenses.receivers;

select paydate, value, name 
from listexpenses.expenses, listexpenses.receivers 
where receiver=receivers.num and value > 3000;