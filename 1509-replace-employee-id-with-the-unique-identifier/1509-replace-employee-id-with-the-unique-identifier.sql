# Write your MySQL query statement below
select euni.unique_id , e.name 
from Employees as e 
LEFT JOIN EmployeeUNI as euni 
on e.id=euni.id;