create table users (
    id serial primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    account_no int not null,
    foreign key (account_no) references accounts(id)
);