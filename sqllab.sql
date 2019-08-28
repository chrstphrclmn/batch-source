-- Michael Zhang

--2.X

--2.1.1: Select all columns from employee table
select * 
from "Employee";

--2.1.2: Select all columns from employee table where last name is King
select *
from "Employee"
where "LastName" = 'King';

--2.1.3: Select all albums in Album table and sort result set in descending order by title.
select *
from "Album"
order by "Title" desc;

--2.1.4: Select first name from Customer and sort result set in ascending order by city.
select "FirstName"
from "Customer"
order by "City" asc;

--2.1.5: Select all invoices with a billing address like “T%”.
select *
from "Invoice"
where "BillingAddress" like('T%');

--2.1.6: Select the name of the longest track.
select "Name"
from "Track"
where "Milliseconds" = (
    select max("Milliseconds")
    from "Track"
);

--2.1.7: Find the average invoice total.
select avg("Total")
from "Invoice";

--2.1.8: Find the total number of employees in each position.
select "Title", count("Title")
from "Employee"
group by "Title";

--2.2.1: Insert two new records into Genre table
insert into "Genre"
values((select max("GenreId" + 1) from "Genre"), 'Movie');

insert into "Genre"
values((select max("GenreId" + 1) from "Genre"), 'Electronic');

--2.2.2: Insert two new records into Employee table
insert into "Employee"("EmployeeId", "FirstName", "LastName")
values((select max("EmployeeId" + 1) from "Employee"), 'Rick', 'Fox'); 

insert into "Employee"("EmployeeId", "FirstName", "LastName")
values((select max("EmployeeId" + 1) from "Employee"), 'Kevin', 'Chen'); 

--2.2.3: Insert two new records into Customer table 
insert into "Customer"("CustomerId", "FirstName", "LastName", "Email")
values((select max("CustomerId" + 1) from "Customer"), 'Austin', 'Bae', 'throwaway@gmail.com');

insert into "Customer"("CustomerId", "FirstName", "LastName", "Email")
values((select max("CustomerId" + 1) from "Customer"), 'Harrison', 'Ding', 'throwaway@yahoo.com');

--2.3.1: Update Aaron Mitchell in Customer table to Robert Walter
update "Customer"
set "FirstName" = 'Robert', "LastName" = 'Walter'
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';

--2.3.2: Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update "Artist"
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

--3.1.1: Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c."FirstName", c."LastName", i."InvoiceId"
from "Customer" as c
join "Invoice" as i
on c."CustomerId" = i."CustomerId";

--3.2.1: Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select c."CustomerId", c."FirstName", c."LastName", i."InvoiceId", i."Total"
from "Customer" as c
full join "Invoice" as i
on c."CustomerId" = i."CustomerId";


