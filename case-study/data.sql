insert into customer_type
values (1,"Diamond"),(2,"Platinium"),(3,"Gold"),(4,"Silver"),(5,"Member");


insert into service_type
values (1,"Villa"),(2,"House"),(3,"Room");

insert into rent_type
values (1,100000000,"Year"),(2,10000000,"Month"),(3,500000,"Day"),(4,100000,"Hour");

insert into `position`
values (1,"Lễ Tân"),(2,"Phục Vụ"),(3,"Chuyên Viên"),(4,"Giám Sát"),(5,"Quản Lý"),(6,"Giám Đốc");

insert into education_degree
values (1,"Trung Cấp"),(2,"Cao Đẳng"),(3,"Đại Học"),(4,"Sau Đại Học");

insert into division
values (1,"Sale – Marketing"),(2,"Hành Chính"),(3,"Phục Vụ"),(4,"Quản Lý");


insert into customer (customer_code,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)
values("KH-0000",1,"Dương Dương",'1990-11-28',0,787656543,0909857601,'a@gmail.com','Đà Nẵng'),
("KH-0001",3,"Hoàng Anh",'1991-11-28',0,787656543,0909857602,'b@gmail.com','Huế'),
("KH-0002",2,"Nguyệt Ly",'1992-11-28',1,787656543,0909857603,'c@gmail.com','Nghệ An'),
("KH-0003",4,"Sở Dương",'1990-11-28',0,787656543,0909857604,'d@gmail.com','Đà Nẵng'),
("KH-0004",5,"Trúc Anh",'1991-11-28',1,787656543,0909857605,'e@gmail.com','Đà Nẵng'),
("KH-0005",3,"Diệc Phàm",'1992-11-28',0,787656543,0909857606,'c@gmail.com','Hà Nội'),
("KH-0006",4,"Tiêu Viêm",'1992-11-28',0,787656543,0909857607,'c@gmail.com','Nghệ An');

insert into service(service_code,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floor)
values("DV-0000",'Vip1',300,5000000,10,1,1,'5sao','Drink Free',30,5),
("DV-0002",'Vip2',200,4000000,15,1,1,'5sao','Drink Free',30,9),
("DV-0003",'Vip3',300,5000000,7,1,2,'5sao','Drink Free',35,7),
("DV-0004",'Vip4',200,4000000,10,1,2,'5sao','Drink Free',30,4),
("DV-0005",'Vip5',300,5000000,15,1,3,'5sao','Drink Free',50,9),
("DV-0006",'Vip6',200,4000000,9,1,3,'5sao','Drink Free',20,7);

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) 
values (1, 'tinhtuyet', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(2, 'linhlung', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
(3, 'tieuthanhi', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into app_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN');

insert into app_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_USER');

insert into user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1);

insert into user_role (ID, USER_ID, ROLE_ID) values (2, 1, 2);

insert into user_role (ID, USER_ID, ROLE_ID) values (3, 2, 2);
insert into user_role (ID, USER_ID, ROLE_ID) values (4, 2, 1);
insert into user_role (ID, USER_ID, ROLE_ID) values (5, 3, 2);

insert into employee (employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,user_id)
values ('Tình Tuyết',"1995-07-27",34346456,10000000,0909857611,'tinhtuyet@gmail','Đà Nẵng',6,4,4,1),
('Linh Lung','1998-11-30',3896456,8000000,0909857612,'linhlung@gmail','Huế',5,3,1,2),
('Tiểu Thần Hi','1995-10-04',35346456,7000000,0909857613,'tieuthanhi@gmail','Đà Nẵng',3,2,3,3),
('Thiên Vũ','1997-01-30',35346456,8000000,0909857614,'thienvu@gmail','Hà Nội',5,3,2,4),
('Bạch Quyết','1994-05-24',35346456,10000000,0909857615,'bachquyet@gmail','Quảng Bình',4,3,4,5);

insert into attach_service
values (1,500000,"Massage","empty",1),
(2,400000,"Karaoke","empty",1),
(3,200000,"Food","empty",1),
(4,100000,"Drinks","empty",1),
(5,500000,"Car","empty",1);

insert into contract (contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id)
values ('2020-1-1','2020-1-10',1000000,10000000,2,2,3),
('2020-11-19','2020-12-10',2000000,150000000,3,3,4),
('2020-1-1','2020-1-10',1000000,10000000,5,5,2),
('2020-1-1','2020-1-10',1000000,10000000,3,4,2),
('2020-1-1','2020-1-10',1000000,10000000,2,6,1); 

insert into contract_detail (contract_id,attach_service_id,quantity)
values (1,1,1),
(2,2,1),
(4,4,1),
(2,5,1),
(1,3,1),
(1,2,1);