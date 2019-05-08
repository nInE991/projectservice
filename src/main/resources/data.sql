insert into orders_status(id, note)
values ('1', 'Заказ принят');
insert into orders_status(id, note)
values ('2', 'В Ожидании');
insert into orders_status(id, note)
values ('3', 'Выпоолняется');
insert into orders_status(id, note)
values ('4', 'Выполнено');
insert into orders_status(id, note)
values ('5', 'Отменено');

insert into users(id, enable, password, position, role, username)
values ('500', true, '$2a$12$xWdXesKXe3iHLvODjCr0QeQvA90NT.433pZka8MzO7nYk75A4.elK', 'Администратор', 'ROLE_Admin',
        'admin');