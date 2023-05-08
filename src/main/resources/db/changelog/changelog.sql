--liquibase formatted sql

--changeset your.name:1 labels:example-label context:example-context
--comment: create table person
create table person (
    id SERIAL primary key not null,
    name varchar(50) not null,
    address1 varchar(50),
    address2 varchar(50),
    city varchar(30)
)
--rollback DROP TABLE person;

--changeset your.name:2 labels:example-label context:example-context
--comment: create table company
create table company (
    id SERIAL primary key not null,
    name varchar(50) not null,
    address1 varchar(50),
    address2 varchar(50),
    city varchar(30)
)
--rollback DROP TABLE company;

--changeset other.dev:3 labels:example-label context:example-context
--comment: alter table person
alter table person add column country varchar(2)
--rollback ALTER TABLE person DROP COLUMN country;

--changeset other.dev:4
ALTER TABLE person DROP COLUMN country
--rollback alter table person add column country varchar(2)

--changeset samit.kumar:5
alter table person add column country varchar(2)
--rollback ALTER TABLE person DROP COLUMN country;

--changeset samit:6
alter table person add column age int
--rollback ALTER TABLE person DROP COLUMN age;