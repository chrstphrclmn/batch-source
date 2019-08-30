--2.1
select * 
from "Employee";

select * 
from "Employee"
where "LastName" = 'King';

select *
from "Album"
order by "Title" Desc;

select "FirstName" 
from "Customer"
order by "City" asc;

select * 
from "Invoice"
where "BillingAddress" like 'T%'; 

select "Name"
from "Track"
where length("Name") = (select max(length("Name")) from "Track");

select avg("Total")
from "Invoice";

select count("EmployeeId"), "Title"
from "Employee"
group by "Title";

--2.2

insert into "Genre" values (26, 'aaa');
insert into "Genre" values (27, 'bbb');

insert into "Employee" values (9, 'aaa', 'adf','efwe', 4 ,'09/30/2001','09/30/2001','asf','fewe','few'); 
insert into "Employee" values (10, 'abb', 'bdf','afwe', 3 ,'01/30/2011','09/30/2011','adsf','fsewe','fxew'); 

insert into "Customer" values (60, 'Json', 'Shen', null, '4, uuuk st', 'London', 'NY', 'UN', '1123', '84 9839 2389', null, 'jfiek@fj.com', 3);
insert into "Customer" values (61, 'Jsson', 'Ashen', null, '5, uauk st', 'London', 'NY', 'UN', '11233', '843 983 1289', null, 'jrrik@fj.com', 3);

--2.3
update "Customer"
set "FirstName" = 'Robert', "LastName" = 'Walter'
where "FirstName" = 'Aaron';

update "Artist"
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

--3.1
select i."InvoiceId", c."FirstName", c."LastName"
from "Invoice" i 
inner join "Customer" c 
on i."CustomerId" = c."CustomerId";

--3.2
select c."CustomerId", c."FirstName", c."LastName", i."InvoiceId", i."Total"
from "Invoice" i
full outer join "Customer" c 
on i."CustomerId" = c."CustomerId";
 
--3.3
select a2."Name" as Artist_Name, a."Title"
from "Album" a
right join "Artist" a2
on a."AlbumId" = a2."ArtistId";

--3.4
select *
from "Album"
cross join "Artist" a
order by a."Name"; 

--3.5
select * 
from "Employee" e, "Employee" e2
where e."ReportsTo" = e2."ReportsTo"; 

--3.6
select c."FirstName" || c."LastName", c."CustomerId", i."Total"
from "Customer" c
full outer join "Invoice" i
on c."CustomerId" = i."CustomerId";

select * 
from(select e."EmployeeId" id, e."FirstName" || e."LastName" as names 
from "Employee" e) as e    
where e.id = 
(select sum_total.id 
from(select sum(i."Total") sum_, c."SupportRepId" id, c."CustomerId" 
from "Invoice" i 
right join "Customer" c 
on i."CustomerId" = c."CustomerId"
group by c."CustomerId") as sum_total 
where sum_total.sum_  =
(select max(customer_total2.sum_) 
from (select i."CustomerId" id, sum(i."Total") sum_
from "Invoice" i
group by i."CustomerId") as customer_total2));

select g."Name", count(i."Quantity") count_
from "Genre" g 
full outer join
"Track" t 
on g."GenreId" = t."GenreId"
full outer join "InvoiceLine" i
on i."TrackId" = t."TrackId"
group by g."GenreId"
order by count_ desc;

--4.0
create or replace function findAvgTotal()
returns numeric(10,2)
language plpgsql
as $$
declare
		avgTotal numeric(10,2);
begin
		select round(avg("Invoice"."Total"), 2) into avgTotal
		from "Invoice";
		return avgTotal;
end;
$$

select findAvgTotal();


create or replace function bron()
returns setof "Employee"
language plpgsql
as $$
begin
	return Query select *
	from "Employee" e
	where e."BirthDate" > '1968-01-01 00:00:00';
end;
$$
select bron();


create or replace function manager(id "Employee"."EmployeeId"%type)
returns varchar
language plpgsql
as $$
declare
		manager varchar;
begin
		select e."FirstName" into manager from "Employee" e where e."EmployeeId" =
		(select e."ReportsTo"
		from "Employee" e where e."EmployeeId" = id);
		return manager;
end;
$$

select "manager"(7);


create or replace function playlist(id "PlaylistTrack"."PlaylistId"%type)
returns numeric(7,2)
language plpgsql
as $$
declare
		price numeric(7,2);
begin
		select sum(t."UnitPrice") into price from "Track" t right join 
		(select p."TrackId" from "PlaylistTrack" p where p."PlaylistId" = id) as p on p."TrackId" = t."TrackId";
		return price;
end;
$$

select "playlist"(5);

