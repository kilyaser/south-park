
insert into public.material(type)
values ('material');

insert into public.technologist(name, email)
values ('Nikolay', 'nikolay@mail.ru'),
       ('Bob', 'bob@mail.ru'),
       ('Maria', 'maria@mail.ru');

insert into public.product (product_title, product_type, written_program, material_id, end_date, preparation,
                            technologist_id)
values ('pro1', 'type1', true, 1, null, 'NEW', 1),
       ('pro2', 'type2', true, 1, null, 'NEW', 2),
       ('pro3', 'type3', true, 1, null, 'NEW', 3);