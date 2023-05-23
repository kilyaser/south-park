--liquibase formatted sql

--changeset init_tables:1 endDelimiter:/
--comment встака данных
insert into public.technologist(name, email)
values ('Ivan', 'ivan@mail.ru'),
    ('Petr', 'petr@mail.ru'),
    ('Andrey', 'andrey@mail.ru');


