/*
 * 
 * SQL Lab	

Setting up Chinook
In this section you will begin the process of working with the Chinook database
Task – (If you haven’t already)  Execute the chinook setup script found here. You can download it and open it in DBeaver or copy and paste the commands into the SQL editor.

When it’s completed, you should see the tables created under table.

If you double click on the Tables tab. It will default to the Properties tab on the top, if you go to the ER Diagram tag, it will show you the Entity Relationship Diagram

Mark each solution to each part with a descriptive comment and upload your .sql file to your branch by Friday at 5pm.

2.0 Queries and DML
2.1 SELECT
Select all records from the Employee table.
*/
select * from "Employee";

/*
Select all records from the Employee table where last name is King.
*/

select "LastName"  from "Employee" where "LastName"='King'   ;
/*
Select all albums in Album table and sort result set in descending order by title.
*/

select* from "Album" order by "Title" desc;

/*Select first name from Customer and sort result set in ascending order by city.
*/

select "FirstName" from "Customer" order by "City"

/*Select all invoices with a billing address like “T%”.
*/
select* from "Invoice" where "BillingAddress"='T%';

/*Select the name of the longest track.
*/

select* from "Track" 
order by length("Name") desc
limit 1;


/*
Find the average invoice total.
*/

select AVG("Total")
from "Invoice";



/*
Find the total number of employees in each position.
*/

select max("EmployeeId") 
from "Employee"; 
/*
2.2 INSERT INTO
Insert two new records into Genre table
*/

select*from "Genre";

select max("GenreId") from "Genre";


insert into "Genre"("GenreId","Name")
values(26,'Lo-Fi hiphop');

insert into "Genre"("GenreId","Name")
values(27,'salsa');
/*
Insert two new records into Employee table

*/

select*from "Employee";
select max("EmployeeId") from "Employee";


insert into "Employee"("EmployeeId","LastName",
"FirstName","Title","ReportsTo","BirthDate",
"HireDate","Address","City","State","Country",
"PostalCode","Phone","Fax","Email"
)
values(9,'Cabezas','Andres','IT Staff'
,6,to_timestamp('2017-03-31 9:30:20','YYYY-MM-DD HH:MI:SS'),
to_timestamp('2017-03-31 9:30:20','YYYY-MM-DD HH:MI:SS')
,'8020 Koluder Ct','Lorton',
'VA','USA',
'22079','5715266689','5715266689','anfelipecq@yahoo.es');

insert into "Employee"("EmployeeId","LastName",
"FirstName","Title","ReportsTo","BirthDate",
"HireDate","Address","City","State","Country",
"PostalCode","Phone","Fax","Email"
)
values(10,'Ceballos','Andres','IT Staff'
,6,to_timestamp('2015-03-31 9:30:20','YYYY-MM-DD HH:MI:SS'),
to_timestamp('2018-03-31 9:30:20','YYYY-MM-DD HH:MI:SS')
,'8020 Koluder Ct','Lorton',
'VA','USA',
'22079','5715266689','5715266689','anfelipecq@yahoo.es');
/*
Insert two new records into Customer table 
*/
select*from "Customer";
select max("CustomerId") from "Customer";


insert into "Customer" ("CustomerId", "FirstName", 
"LastName", "Company", "Address", "City", "State", 
"Country", "PostalCode", "Phone", "Fax", "Email", 
"SupportRepId"
)
values (60, 'lucas', 'galves', 'forex'
, '12021 av Americas', 
'Coruña', '23061', 
'Espana', '12227-000', '+55 (12) 3923-5555',
'+55 (12) 3923-5566', 'lucasGalves@forex.com.es', 8);

insert into "Customer" ("CustomerId", "FirstName", 
"LastName", "Company", "Address", "City", "State", 
"Country", "PostalCode", "Phone", "Fax", "Email", 
"SupportRepId"
)
values (61, 'andrea', 'galves', 'forex'
, '12021 av Americas', 
'Coruña', '23061', 
'Espana', '12227-000', '+55 (12) 3923-5555',
'+55 (12) 3923-5566', 'lucasGalves@forex.com.es', 8);

/*
2.3 UPDATE
Update Aaron Mitchell in Customer table to Robert Walter
*/
select* from "Customer";

update "Customer" set "FirstName"='Robert' where "FirstName"='Aaron';
update "Customer" set "LastName"='Walter' where "LastName"='Mitchell';

select "FirstName","LastName" from "Customer" where "FirstName"='Robert';
/*
Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/
select* from "Artist" ;

update "Artist" set "Name"='CCR' where "Name"='Creedence Clearwater Revival';
select "Name" from "Artist" where "Name"='CCR' ;

/*
3.0 Joins
In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
3.1 INNER
Create an inner join that joins customers and orders
 and specifies the name of the customer and the invoiceId.
*/

select*from "Customer";


select 
	"InvoiceId","FirstName","LastName"
from
	"Customer" inner join "Invoice" 
	on "Customer"."CustomerId"="Invoice"."CustomerId";


/*

3.2 OUTER
Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/

select 
	"InvoiceId","FirstName","LastName","Total"
from
	"Customer" full outer join "Invoice" 
	on "Customer"."CustomerId"="Invoice"."CustomerId";
/*
3.3 RIGHT
Create a right join that joins album and artist specifying 
artist name and title.
*/
select
	"Name","Title"
from "Album" right join "Artist" 
on "Album"."ArtistId" = "Artist"."ArtistId";
/*
3.4 CROSS
Create a cross join that joins album and artist and sorts 
by artist name in ascending order.
*/
select*
from "Album" cross join "Artist"
order by "Name" asc;
/*3.5 SELF
Perform a self-join on the employee table, joining on the reportsto column.
 */

select*
from "Employee";

select
	e."FirstName" as "Employee",m."FirstName" as "Reports To"
from
	"Employee" e inner join "Employee" m 
	on e."ReportsTo"=m."EmployeeId";


/*
 * 3.6 Joined Queries
Create a query that shows the customer first name and last name as 
FULL_NAME (you can use || to concatenate two strings) with the total 
amount of money they have spent as TOTAL.
*/

select*
from "Customer";

select
	concat("FirstName",' ',"LastName") as "FullName",
	"Total" as "Total"
	
from
	"Customer"
inner join "Invoice" on "Customer"."CustomerId"="Invoice"."CustomerId";

/*
Create a query that shows the employee that has made the 
highest total value of sales (total of all invoices).
*/
create view middle
as select "Employee"."FirstName"||' '||"Employee"."LastName" as "Employee",
		"Partial"."Total" 
		from "Employee" join(
						select sum("Invoice"."Total")  as "Total",
						"Customer"."SupportRepId" as "SupportRepId"
						
						from "Invoice" join "Customer"  on "Invoice"."CustomerId"="Customer"."CustomerId" 
						group by "Customer"."SupportRepId"
						
						) as "Partial" on "Employee"."EmployeeId"="Partial"."SupportRepId" 

select "Employee"."FirstName"||' '||"Employee"."LastName" as "Employee",
		"Partial"."Total" 
		from "Employee" join(
						select sum("Invoice"."Total")  as "Total",
						"Customer"."SupportRepId" as "SupportRepId"
						
						from "Invoice" join "Customer"  on "Invoice"."CustomerId"="Customer"."CustomerId" 
						group by "Customer"."SupportRepId"
						
						) as "Partial" on "Employee"."EmployeeId"="Partial"."SupportRepId" 
						
						where "Partial"."Total"=(
						select max("Total") from middle
						
						);
						

					


/*
Create a query which shows the number of purchases per each genre. 
Display the name of each genre and number of purchases. 
Show the most popular genre first.
*/

create or replace view genreTrack as
select "Genre"."Name", "Track"."TrackId"  from "Track" inner  join "Genre"   on "Track"."GenreId"= "Genre"."GenreId";  
select "Name","TrackId" from genretrack ;

create or replace view gtInvoice as
select genreTrack."Name",genreTrack."TrackId", "InvoiceLine"."Quantity" 
from genretrack inner join "InvoiceLine" 
on genreTrack."TrackId"="InvoiceLine"."TrackId";

select*from gtInvoice;

select "Name", sum("Quantity") from gtinvoice group by"Name";

/*
4.0 User Defined Functions
Create a function that returns the average total of all invoices.
*/


select* from "Invoice";

create or replace function averageInvoice()
returns numeric(7,2)
language plpgsql
as $$
declare	
promedio numeric(7,2);
begin
	select round(avg("Total"),2) into promedio 
	from "Invoice"; 
	return promedio;

end;
$$

select averageInvoice();

/*

Create a function that returns all employees who are born 
after 1968.*/

select* from "Employee";

create or replace function afterD()
returns setof "Employee"
language plpgsql
as $$
declare 


begin
	return query 
	select* 
	from "Employee"
	where to_timestamp('1/1/1968','MM/DD/YYYY HH24:MI:SS')<="BirthDate";
	
end;
$$

select afterD();


/*
Create a function that returns the manager of an employee, given the 
id of the employee.
*/
select*from "Employee";


create or replace function employeemanager(id numeric)
returns  varchar
language plpgsql
as $$
declare 
mid integer;
mname varchar;
begin
	mid:=(select "ReportsTo" from "Employee" where "EmployeeId"=id);
	 
	select "FirstName"||' '||"LastName" into mname
	from"Employee" where "EmployeeId"=mid;

	return mname;	

end;
$$

select employeemanager(6);


/*
Create a function that returns the price of a particular playlist, given the id for that playlist.
*/

select*from "Playlist"; 

create or replace view ptrack as 
select "Playlist"."Name","Playlist"."PlaylistId","PlaylistTrack"."TrackId"
from "Playlist" inner join "PlaylistTrack" 
on "Playlist"."PlaylistId"="PlaylistTrack"."PlaylistId"; 

create or replace view unitp as 
select  ptrack."PlaylistId",sum("Track"."UnitPrice") 
	from ptrack inner join "Track"
	on ptrack."TrackId"="Track"."TrackId"
	group by ptrack."PlaylistId"
	
create or replace function pricePlaylist(pid numeric)
returns  numeric(7,2) 
language plpgsql
as $$
declare
price integer;
begin
	
	price:=(select sum from unitp where "PlaylistId"=pid);
	return price; 
end;
$$ 

select pricePlaylist(5);




/*























