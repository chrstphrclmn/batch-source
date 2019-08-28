select * from "Employee";

select * from "Employee" where "LastName" = 'King';

select * from "Album" order by "Title" Desc;

select "FirstName" from "Customer" order by "City" asc;

select * from "Invoice" where "BillingAddress" like 'T%'; 

select "Name" from "Track" where length("Name") = (select max(length("Name")) from "Track");

select avg("Total") from "Invoice";

select count("EmployeeId"), "Title" from "Employee" group by "Title";

insert into "Genre" values (26, 'aaa');
insert into "Genre" values (27, 'bbb');

insert into "Employee" values (9, 'aaa', 'adf','efwe', 4 ,'09/30/2001','09/30/2001','asf','fewe','few'); 
insert into "Employee" values (10, 'abb', 'bdf','afwe', 3 ,'01/30/2011','09/30/2011','adsf','fsewe','fxew'); 

insert into "Customer" values (60, 'Json', 'Shen', null, '4, uuuk st', 'London', 'NY', 'UN', '1123', '84 9839 2389', null, 'jfiek@fj.com', 3);
insert into "Customer" values (61, 'Jsson', 'Ashen', null, '5, uauk st', 'London', 'NY', 'UN', '11233', '843 983 1289', null, 'jrrik@fj.com', 3);

update "Customer" set "FirstName" = 'Robert', "LastName" = 'Walter' where "FirstName" = 'Aaron';

select i."InvoiceId", c."FirstName", c."LastName" from "Invoice" i inner join "Customer" c on i."CustomerId" = c."CustomerId";

select c."CustomerId", c."FirstName", c."LastName", i."InvoiceId", i."Total" from "Invoice" i full outer join "Customer" c on i."CustomerId" = c."CustomerId";

select a2."Name" as Artist_Name, a."Title" from "Album" a right join "Artist" a2 on a."AlbumId" = a2."ArtistId";

select * from "Album" cross join "Artist" a order by a."Name"; 

select * from "Employee" e, "Employee" e2 where e."ReportsTo" = e2."ReportsTo"; 