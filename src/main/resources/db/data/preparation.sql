--liquibase formatted sql

--changeset init_tables:1 endDelimiter:/
--comment встака данных

insert into public.preparation(id, preparation) values (1, 'NOT_DONE');

insert into public.preparation(id, preparation) values (2, 'IN_PROGRESS');

insert into public.preparation(id, preparation) values (3, 'DONE');





