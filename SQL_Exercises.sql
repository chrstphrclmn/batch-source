--Select all records from the Employee table.

select * 
from "Employee";

--Select all records from the Employee table where last name is King.

select * 
from "Employee" 
where "LastName" = 'King';

--Select all albums in Album table and sort result set in descending order by title.

select * 
from "Album" 
order by "Title" desc;

--Select first name from Customer and sort result set in ascending order by city.

select "FirstName" 
from "Customer" 
order by "City" asc;

--Select all invoices with a billing address like “T%”.

select * 
from "Invoice" 
where "BillingAddress" like 'T%';

--Select the name of the longest track.

select "Name" 
from "Track" 
where "Milliseconds" = (
	select max("Milliseconds") 
	from "Track"
);

--Find the average invoice total.

select avg("Total") 
from "Invoice";

--Find the total number of employees in each position.

select "Title", Count("Title") 
from "Employee" 
group by "Title";

--Insert two new records into Genre table

insert into "Genre" 
values (26,'screamo'), (27, 'folkrockjazz');

--Insert two new records into Employee table

insert into "Employee" 
values (9,'McDervin','al', 'IT Staff', 6, '1993-05-04 00:00:00', '2019-05-04 00:00:00', 
		'45 Street St', 'Cityville', 'PA', 'United States', '17012', '+1 (717) 340-4400', 
		'+1 (717) 340-4401','al@chinookcorp.com'), 
		(10,'MacDervin','Dave', 'IT Staff', 6, '1998-03-04 00:00:00', '2019-05-04 00:00:00', 
		'450 Avenue St', 'Townville', 'PA', 'United States', '17014', '+1 (717) 340-4405', 
		'+1 (717) 340-4406','dave@chinookcorp.com');
	
--Insert two new records into Customer table 

insert into "Customer" 
values(60, 'James', 'Peach', 'Revature', '340 Tree St', 'Cityburg', 'AK', 'USA', '17078', 
	   '+1 (676) 676-6766', '+1 (676) 676-6767', 'james@james.com',4),
	  (61, 'Jimmy', 'Peaches', 'Revature', '341 Tree St', 'Cityburg', 'AK', 'USA', '17078', 
	   '+1 (676) 676-6769', '+1 (676) 676-6790', 'jimmy@jimmy.com',5);
	  
--Update Aaron Mitchell in Customer table to Robert Walter

update "Customer" 
set "FirstName" = 'Robert' , "LastName" = 'Walter' 
where "FirstName" = 'Aaron'  and "LastName" = 'Mitchell';

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

update "Artist" 
set "Name" = 'CCR' 
where "Name" = 'Creedence Clearwater Revival';

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

select "Customer"."FirstName", "Customer"."LastName", "Invoice"."InvoiceId" 
from "Customer" 
join "Invoice" 
on "Customer"."CustomerId" = "Invoice"."CustomerId";

--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

select "Invoice"."CustomerId", "Customer"."FirstName", "Customer"."LastName", "Invoice"."InvoiceId", "Invoice"."Total"
from "Customer" 
full join "Invoice" 
on "Customer"."CustomerId" = "Invoice"."CustomerId";

--Create a right join that joins album and artist specifying artist name and title.

select "Artist"."Name", "Album"."Title" 
from "Artist" 
join "Album" 
on "Artist"."ArtistId" = "Album"."ArtistId";

--Create a cross join that joins album and artist and sorts by artist name in ascending order.

select * 
from "Artist" 
cross join "Album" 
order by "Artist"."Name";

--Perform a self-join on the employee table, joining on the reportsto column.

select a.*, b.* 
from "Employee" as a 
join "Employee" as b 
on a."ReportsTo" = b."ReportsTo";
--or
select a.*, b.* 
from "Employee" a, "Employee" b 
where a."ReportsTo" = b."ReportsTo";

--Create a query that shows the customer first name and last name as FULL_NAME (you can use || to concatenate two strings)
-- with the total amount of money they have spent as TOTAL.

select "Customer"."FirstName" ||'  '|| "Customer"."LastName" as FULL_NAME, "Invoice_totals"."sum" as "TOTAL" 
from "Customer" 
join (
	select "CustomerId", sum("Invoice"."Total") 
	from "Invoice" 
	group by "Invoice"."CustomerId"
	) as "Invoice_totals" 
on "Customer"."CustomerId" = "Invoice_totals"."CustomerId";

--Create a query that shows the employee that has made the highest total value of sales (total of all invoices)

select "FirstName" || '  '|| "LastName" as "Full_Name", "sum" as "Total_Sales"
from "Employee"
join (
	select "Customer"."SupportRepId", sum("Invoice"."Total")
	from "Customer"  
	join "Invoice" 
	on "Customer"."CustomerId" = "Invoice"."CustomerId"
	group by "Customer"."SupportRepId"
	) as "repid_and_sum"
on "Employee"."EmployeeId" = "repid_and_sum"."SupportRepId"
order by "Total_Sales" desc
limit 1;

--Create a query which shows the number of purchases per each genre. Display the name of each genre
-- and number of purchases. Show the most popular genre first

select "Genre"."Name", "genre_id_total_purchases"."sum" as "Number_of_purchases" 
from "Genre" 
join (
	select sum("InvoiceLine"."Quantity"), "Track"."GenreId" 
	from "InvoiceLine" 
	join "Track" 
	on "InvoiceLine"."TrackId" = "Track"."TrackId" 
	group by "Track"."GenreId"
	) as "genre_id_total_purchases" 
on "Genre"."GenreId" = "genre_id_total_purchases"."GenreId" 
order by "Number_of_purchases" desc;

--Create a function that returns the average total of all invoices.

create or replace function avg_total_invoice ()
returns numeric(6,2)
language plpgsql
as $$
declare
average numeric(6,2) := (select avg("Total") from "Invoice");
begin
return average;
end;
$$

--select avg_total_invoice();

--Create a function that returns all employees who are born after 1968.

create or replace function emp_born_after_1968()
returns setof text
language plpgsql
as $$
declare
	names varchar;
begin	
	return Query select "FirstName"||'  '||"LastName"
	from "Employee" 
	where "BirthDate" > '1968-01-01 00:00:00';
end;
$$

--select emp_born_after_1968();

--Create a function that returns the manager of an employee, given the id of the employee.

create or replace function find_manager(emp_id "Employee"."EmployeeId" %type)
returns varchar
language plpgsql
as $$
declare
	manager_id "Employee"."ReportsTo" %type;
	manager_name varchar;
begin	
	select "ReportsTo" into manager_id
	from "Employee" 
	where "EmployeeId" = emp_id;

	select "Employee"."FirstName" || '  '|| "Employee"."LastName" into manager_name
	from "Employee"
	where "EmployeeId" = manager_id;
return manager_name;
end;
$$

--select find_manager(1);

--Create a function that returns the price of a particular playlist, given the id for that playlist.

create or replace function find_playlist_price(play_list_id integer)
returns numeric (10, 2)
language plpgsql
as $$
declare

	total numeric(10, 2);
	
begin
	
	total := (select sum("Track"."UnitPrice")
from "Track" 
join (
	  select * 
	  from "PlaylistTrack" 
	  where "PlaylistId" = play_list_id
	 ) as pid_and_tid
on "Track"."TrackId" = pid_and_tid."TrackId");
	
return total;
end;
$$
	
end

--select find_playlist_price(1) as "Playlist Price";
