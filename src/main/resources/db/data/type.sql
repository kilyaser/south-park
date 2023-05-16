--liquibase formatted sql

--changeset init_tables:1 endDelimiter:/
--comment встака данных

insert into public.type(id, type) values (1, 'NEW');

insert into public.type(id, type) values (2, 'REPEAT');

insert into public.type(id, type) values (3, 'CHANGE');

insert into public.type(id, type) values (4, 'NOT_MAKE');

insert into public.type(id, type) values (5, 'COOPERATION');




