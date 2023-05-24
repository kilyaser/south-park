DELETE FROM product;
DELETE FROM material;
DELETE FROM technologist;
ALTER SEQUENCE product_id_seq RESTART WITH 1;
ALTER SEQUENCE material_id_seq RESTART WITH 1;
ALTER SEQUENCE technologist_id_seq RESTART WITH 1;

insert into public.material(type)
values ('material');

insert into public.technologist(name, email)
values ('Ivan', 'ivan@mail.ru'),
       ('Petr', 'petr@mail.ru'),
       ('Andrey', 'andrey@mail.ru');

insert into public.product (product_title, product_type, written_program, material_id, end_date, preparation,
                     technologist_id)
values ('pro1', 'type1', true, 1, null, 'NEW', 1);