create table login (
	username VARCHAR(50) not null,
	password VARCHAR(50) not null,
	constraint login_pk primary key(username)
);
insert into login (username, password) values ('skearney0', 'I5A6YI18KYgl');
insert into login (username, password) values ('rcanizares1', 'Npy1Fee');
insert into login (username, password) values ('cmelior2', 'Hq2ULFUxQI3');
insert into login (username, password) values ('maisthorpe3', 'h47gaL');
insert into login (username, password) values ('rmartignoni4', 'jp8wFSOY');

create table account (
	accountnum INT,
	accounttype VARCHAR(8),
	value DECIMAL(7,2),
	primary key(accountnum)
);
insert into account (accountnum, accounttype, value) values (1, 'savings', 66.46);
insert into account (accountnum, accounttype, value) values (2, 'savings', 71.17);
insert into account (accountnum, accounttype, value) values (3, 'savings', 80.51);
insert into account (accountnum, accounttype, value) values (4, 'checking', 23.66);
insert into account (accountnum, accounttype, value) values (5, 'checking', 50.43);

create table session (
	accountnum INT,
	username VARCHAR(50),
	primary key(accountnum, username)
);
insert into session (accountnum, username) values (3, 'skearney0');
insert into session (accountnum, username) values (3, 'rcanizares1');
insert into session (accountnum, username) values (5, 'skearney0');
insert into session (accountnum, username) values (5, 'rcanizares1');
insert into session (accountnum, username) values (4, 'cmelior2');
insert into session (accountnum, username) values (1, 'maisthorpe3');
insert into session (accountnum, username) values (2, 'rmartignoni4');

create table transaction (
	transactionid INT,
	accountnum INT,
	username VARCHAR(50),
	transfer DECIMAL(5,2),
	primary key(transactionid)
);
insert into transaction (transactionid, accountnum, username, transfer) values (1, 2, 'rmartignoni4', 32.12);
insert into transaction (transactionid, accountnum, username, transfer) values (2, 1, 'maisthorpe3', 66.46);
insert into transaction (transactionid, accountnum, username, transfer) values (3, 4, 'cmelior2', 23.66);
insert into transaction (transactionid, accountnum, username, transfer) values (4, 5, 'skearney0', 20.81);
insert into transaction (transactionid, accountnum, username, transfer) values (5, 3, 'skearney0', 140.51);
insert into transaction (transactionid, accountnum, username, transfer) values (6, 5, 'skearney0', 29.62);
insert into transaction (transactionid, accountnum, username, transfer) values (7, 2, 'rmartignoni4', 39.05);
insert into transaction (transactionid, accountnum, username, transfer) values (8, 3, 'rcanizares1', -60.00);


