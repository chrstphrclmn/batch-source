
--2.1.a Select all from Employee table.
select * from "Employee";

--2.1.b select all records from Employee table where the last name is king.
select * from "Employee" where "LastName"='King';

--2.1.c Select all albums in Album table and sort result set in descending order by title.
select * from "Album" order by "Title" desc;

--2.1.d Select first name from Customer and sort result set in ascending order by city.
select "FirstName" from "Customer" order by "City" asc;

--2.1.e Select all invoices with a billing address like “T%”.
select * from "Invoice" where "BillingAddress" like 'T%';

--2.1.f Select the name of the longest track.
select "Name" from "Track" where "Milliseconds"=(select max("Milliseconds") from "Track");

--2.1.g Find the average invoice total.
select avg("Total") from "Invoice";

--2.1.h Find the total number of employees in each position.
select "Title", count("Title") from "Employee" group by "Title";


--2.2.a Insert two new records into Genre table
insert into "Genre" ("GenreId","Name") values (26, 'Horror'), (27,'Musical');

--2.2.b Insert two new records into Employee table
insert into "Employee" ("EmployeeId", "LastName", "FirstName") values (9, 'John','Smith'), (10, 'Jane', 'Smith');

--2.2.c Insert two new records into Customer table 
insert into "Customer" ("CustomerId", "FirstName", "LastName", "Email") values (60, 'John', 'Smith', 'john.smith@smith.com'),
	(61, 'Jane', 'Smith', 'jane.smith@smith.com');

--2.3.a Update Aaron Mitchell in Customer table to Robert Walter
update "Customer" set "FirstName"='Robert', "LastName"='Walter'
where "FirstName" = 'Aaron' and "LastName"='Mitchell';

--2.3.b Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
update "Artist"
set "Name"='CCR'
where "Name"='Creedence Clearwater Revival';

--3.1.a Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c."FirstName", c."LastName", i."InvoiceId"
from "Customer" c inner join "Invoice" i
on c."CustomerId" = i."CustomerId";

--3.2.a Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select c."CustomerId", c."FirstName", c."LastName", i."InvoiceId", i."Total"
from "Customer" c full join "Invoice" i
on c."CustomerId"=i."CustomerId";

--3.3.a Create a right join that joins album and artist specifying artist name and title.
select ar."Name", al."Title"
from "Album" al right join "Artist" ar
on al."ArtistId"=ar."ArtistId";

--3.4.a Create a cross join that joins album and artist and sorts by artist name in ascending order.
select *
from "Album" al cross join "Artist" ar
order by ar."Name" asc;

--3.5.a Perform a self-join on the employee table, joining on the reportsto column.
select *
from "Employee" e join "Employee" f
on e."EmployeeId"=f."ReportsTo";

--3.6.a Create a query that shows the customer first name and last name as FULL_NAME 
--(you can use || to concatenate two strings) with the total amount of money they have spent as TOTAL.
select c."FirstName"||c."LastName" as "FULL_NAME", sum(i."Total") as "TOTAL"
from "Customer" c join "Invoice" i
on c."CustomerId"=i."CustomerId"
group by i."CustomerId", c."FirstName", c."LastName";

--3.6.b Create a query that shows the employee that has made the highest total value of sales (total of all invoices).

select e."FirstName", e."LastName", f."total"
from "Employee" e join (
select c."SupportRepId", sum(i."Total") as "total"
from "Customer" c join "Invoice" i
on c."CustomerId"=i."CustomerId"
group by c."SupportRepId") f
on e."EmployeeId"=f."SupportRepId"
where	"total"=(
select max("total")
from (
select c."SupportRepId", sum(i."Total") as "total"
from "Customer" c join "Invoice" i
on c."CustomerId"=i."CustomerId"
group by c."SupportRepId") g);

--3.6.c Create a query which shows the number of purchases per each genre. 
--Display the name of each genre and number of purchases. Show the most popular genre first.

select g."Name", h."NumOfPurchases"
from "Genre" g join 
(select t."GenreId", count(t."GenreId") as "NumOfPurchases"
from "InvoiceLine" il join "Track" t
on il."TrackId" = t."TrackId"
group by "GenreId") h
on g."GenreId"=h."GenreId"
order by "NumOfPurchases" desc;

--4.0.a Create a function that returns the average total of all invoices.

create function invoiceAvrg()
returns numeric(7,2) as $$
begin
return(
	select avg("Total")
	from "Invoice");
end $$
language plpgsql;

select invoiceAvrg()

--4.0.b Create a function that returns all employees who are born after 1968.
create or replace function birthday()
returns table (firstname character varying, lastname character varying) as $$
begin
	return query 
	select e."FirstName", e."LastName"
	from "Employee" e
	where e."BirthDate"::date > date '1968-12-31';
	
end; $$
language plpgsql;

--4.0.c Create a function that returns the manager of an employee, given the id of the employee.
create or replace function manager(cid int)
returns int as $$
begin
	return (
	select e."ReportsTo"
	from "Employee" e
	where e."EmployeeId"=cid);
end; $$
language plpgsql;

--4.0.d Create a function that returns the price of a particular playlist, given the id for that playlist
create or replace function price(id int)
returns numeric(7,2) as $$
begin
	return (
	select sum(t."UnitPrice")
	from "PlaylistTrack" p join "Track" t
	on p."TrackId"=t."TrackId"
	where p."PlaylistId"=id
	group by p."PlaylistId"
	);
	
end; $$
language plpgsql;

select * from price(3);






