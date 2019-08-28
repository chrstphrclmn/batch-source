
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