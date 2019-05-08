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


insert into price(id, name, price)
VALUES ('1', 'Диагностика компьютера', 200);
insert into price(id, name, price)
VALUES ('2', 'Чистка компьютера', 300);

-- insert into roles(id, note, role)
-- VALUES ('1', 'Администратор', 'ADMIN');
-- insert into roles(id, note, role)
-- VALUES ('2', 'Директор', 'DIRECTOR');
-- insert into roles(id, note, role)
-- VALUES ('3', 'Менеджер', 'MANAGER');
-- insert into roles(id, note, role)
-- VALUES ('4', 'Сотрудник ремонта', 'EMPLOYEES');
--
--
-- insert into users(id, password, username, role_id)
-- VALUES ('1', 'admin', 'admin', 1);

-- insert into customer(id, lastname, name, telephone) VALUES ('1','test','test','test');

-- insert into orders(id, date, end_date, finish, note, serial, customer_id, price_id, status_id) VALUES ('1','01-05-2019',null,false,'выа','комп','1','1','2');
-- insert into orders(id, date, end_date, finish, note, serial, customer_id, price_id, status_id) VALUES ('2','01-05-2019',null,false,'выа','компfd','1','1','4');
-- insert into orders(id, date, end_date, finish, note, serial, customer_id, price_id, status_id) VALUES ('3','01-05-2019',null,false,'выа','компfdsffd','1','1','1');
-- insert into orders(id, date, end_date, finish, note, serial, customer_id, price_id, status_id) VALUES ('4','01-05-2019',null,false,'выа','компffdasdsffd','1','1','3');
-- insert into orders(id, date, end_date, finish, note, serial, customer_id, price_id, status_id) VALUES ('5','01-05-2019',null,true,'выа','компffdasfadsffd','1','1','3');