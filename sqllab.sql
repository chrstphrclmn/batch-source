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


--3.3.1: Create a right join that joins album and artist specifying artist name and title.
select ar."Name", al."Title"
from "Album" as al
right join "Artist" as ar
on al."ArtistId" = ar."ArtistId";

--3.4.1: Create a cross join that joins album and artist and sorts by artist name in ascending order.
select ar."Name", al."Title"
from "Album" as al
cross join "Artist" as ar
order by ar."Name" asc;

--3.5.1: Perform a self-join on the employee table, joining on the reportsto column.
select e1."FirstName", e1."LastName", e2."ReportsTo"
from "Employee" as e1, "Employee" as e2
where e1."EmployeeId" = e2."EmployeeId";

--3.6.1: Create a query that shows the customer first name and last name as FULL_NAME (you can use || to concatenate two strings) with the total amount of money they have spent as TOTAL.
select c."FirstName" || ' ' || c."LastName" as "FULL_NAME", m.total as "TOTAL"
from (
    select i."CustomerId", sum(i."Total") as total
    from "Invoice" as i
    group by i."CustomerId"
) as m
join "Customer" as c
on c."CustomerId" = m."CustomerId";

--3.6.2: Create a query that shows the employee that has made the highest total value of sales (total of all invoices).
select e."EmployeeId", e."FirstName", e."LastName", s.total
from(
    select k.id, k.total
    from(
        select m.id as id, sum(m.total) as total
        from(
            select c."SupportRepId" as id, s.total as total
                from (
                    select i."CustomerId", sum(i."Total") as total
                    from "Invoice" as i
                    group by i."CustomerId"
                ) as s
                join "Customer" as c
            on c."CustomerId" = s."CustomerId"
        ) as m
        group by m.id
    ) as k
    where k.total = (select max(k.total)
        from(
        select m.id as id, sum(m.total) as total
        from(
            select c."SupportRepId" as id, s.total as total
                from (
                    select i."CustomerId", sum(i."Total") as total
                    from "Invoice" as i
                    group by i."CustomerId"
                ) as s
                join "Customer" as c
            on c."CustomerId" = s."CustomerId"
        ) as m
        group by m.id
    ) as k)
    ) as s
join "Employee" as e
on e."EmployeeId" = s.id

--3.6.3: Create a query which shows the number of purchases per each genre. Display the name of each genre and number of purchases. Show the most popular genre first.
select g."Name", sub3.counts
from(
    select sub2."GenreId", sum(sub2.counts) as counts
    from(
        select t."GenreId", sub1.counts
        from (
            select il."TrackId", count(il."TrackId") as counts
            from "InvoiceLine" as il
            group by il."TrackId"
        ) as sub1
        join "Track" as t
        on t."TrackId" = sub1."TrackId"
    ) as sub2
    group by sub2."GenreId"
) as sub3
join "Genre" as g
on g."GenreId" = sub3."GenreId"
order by sub3.counts desc;

--4.0.1: Create a function that returns the average total of all invoices.

create function average_total()
returns numeric(7, 2)
language plpgsql
as $$
begin
    return (
        select avg(i."Total")
        from "Invoice" as i
    );
end;
$$

select average_total();

--4.0.2: Create a function that returns all employees who are born after 1968.
create or replace function after1968()
returns table(
    FirstName varchar(50),
    LastName varchar(50)
)
language plpgsql
as $$
declare
    year date := '1968-1-1';
begin
    return query(
        select e."FirstName", e."LastName" from "Employee" as e where e."BirthDate" >= year
    );
end;
$$

select after1968();

--4.0.3: Create a function that returns the manager of an employee, given the id of the employee.
create or replace function get_manager(id integer)
returns table(
    FirstName varchar(50),
    LastName varchar(50)
)
language plpgsql
as $$
begin
    return query(
        select e."FirstName", e."LastName"
        from(
            select *
            from "Employee" as e
            where e."EmployeeId" = id
        ) as sub1
        join "Employee" as e
        on e."EmployeeId" = sub1."ReportsTo"
    );
end;
$$

select get_manager(3);

--4.04: Create a function that returns the price of a particular playlist, given the id for that playlist.
create or replace function get_playlist_price(id integer)
returns numeric(7, 2)
language plpgsql
as $$
begin
    return(
        select sum(sub2."UnitPrice")
        from(
            select t."UnitPrice"
            from(
                select pl."TrackId"
                from "PlaylistTrack" as pl
                where pl."PlaylistId" = id
            ) as sub1
            join "Track" as t
            on sub1."TrackId" = t."TrackId"
        )  as sub2
    );
end;
$$


select get_playlist_price(14);