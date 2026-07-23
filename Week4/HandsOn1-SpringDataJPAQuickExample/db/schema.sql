-- Run manually in MySQL before starting the app (ddl-auto=validate expects the table to exist)
-- mysql -u root -p
-- mysql> create schema ormlearn;
-- mysql> use ormlearn;
-- mysql> source schema.sql;

create table country(co_code varchar(2) primary key, co_name varchar(50));
