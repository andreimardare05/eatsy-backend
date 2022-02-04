delete from user_order_item;
delete from menu_item;
delete from user_order;
delete from restaurant_managers;
delete from restaurant;
delete from address;
delete from users;
delete from roles;

INSERT INTO roles(id,name) VALUES(1,'ROLE_CUSTOMER');
INSERT INTO roles(id,name) VALUES(2,'ROLE_RESTAURANT_MANAGER');
INSERT INTO roles(id,name) VALUES(3,'ROLE_DELIVERY');
INSERT INTO roles(id,name) VALUES(4,'ROLE_ADMIN');

INSERT INTO users(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, ROLE_ID, TYPE)
values(1, 'Admin','TEST', 'admin@email.com','$2a$10$uGJ6zgNNfTK6XHUX5GMR5.Z2JU2E2N.fNeIJKcOA5fliRKwE9U.kG','4', 'admin');

INSERT INTO users(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, ROLE_ID,TYPE)
values(2, 'Delivery','TEST', 'delivery@email.com','$2a$10$uGJ6zgNNfTK6XHUX5GMR5.Z2JU2E2N.fNeIJKcOA5fliRKwE9U.kG','3','delivery');

INSERT INTO users(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, ROLE_ID,TYPE)
values(3, 'RestaurantManager','TEST', 'manager@email.com','$2a$10$uGJ6zgNNfTK6XHUX5GMR5.Z2JU2E2N.fNeIJKcOA5fliRKwE9U.kG','2','manager');

INSERT INTO users(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, ROLE_ID,TYPE)
values(4, 'Customer','TEST', 'customer@email.com','$2a$10$uGJ6zgNNfTK6XHUX5GMR5.Z2JU2E2N.fNeIJKcOA5fliRKwE9U.kG','1','customer');

INSERT INTO users(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, ROLE_ID,TYPE)
values(5, 'RestaurantManager','TEST', 'manager3@email.com','$2a$10$uGJ6zgNNfTK6XHUX5GMR5.Z2JU2E2N.fNeIJKcOA5fliRKwE9U.kG','2','manager');

INSERT INTO users(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, ROLE_ID,TYPE)
values(6, 'RestaurantManager','TEST', 'manager2@email.com','$2a$10$uGJ6zgNNfTK6XHUX5GMR5.Z2JU2E2N.fNeIJKcOA5fliRKwE9U.kG','2','manager');

INSERT INTO address(ID, LONGITUDE, LATITUDE, ADDRESS)
values(3, 26.066123845484555, 44.44859563228468, 'Soseaua Orhideelor, nr. 457 - Sector 6, Bucuresti');

INSERT INTO restaurant(ID, NAME, ADDRESS_ID, DESCRIPTION, CONTACT, opening_time, closing_time )
values(3, 'Rigattoni',3, 'This is a short description for Rigattoni Restaurant','0725427587', 10,22);

insert into menu_item(id,description,name,price,restaurant_id)
values(3, 'Spaghetti pasta, tomatoes sauce, beaf meat, condiments','Spaghetti Bolognese', 28.99, 3 );

insert into menu_item(id,description,name,price,restaurant_id)
values(4, 'Spaghetti pasta, white sauce, bacon, condiments, eggs','Spaghetti Carbonara', 30.99, 3 );

insert into menu_item(id,description,name,price,restaurant_id)
values(5, 'White flour, mozzarela, mushrooms, meat, olives','Quattro Stagioni', 25.99, 3 );

INSERT INTO address(ID, LONGITUDE, LATITUDE, ADDRESS)
values(4, 26.07630744958263, 44.44651087287511, 'Gara de Nord, Strada Petru Raresm nr. 457, Bucuresti');

INSERT INTO restaurant(ID, NAME, ADDRESS_ID, DESCRIPTION, CONTACT, opening_time, closing_time )
values(2, 'Salsa',4, 'This is a short description for Salsa Restaurant','0725413587',10,22);

insert into menu_item(id,description,name,price,restaurant_id)
values(6, 'Spaghetti pasta, tomatoes sauce, beaf meat, condiments','Spaghetti Bolognese', 28.99, 2);

insert into menu_item(id,description,name,price,restaurant_id)
values(7, 'Spaghetti pasta, white sauce, bacon, condiments, eggs','Spaghetti Carbonara', 30.99, 2 );

insert into menu_item(id,description,name,price,restaurant_id)
values(8, 'White flour, mozzarela, mushrooms, meat, olives','Quattro Stagioni', 25.99, 2 );

INSERT INTO address(ID, LONGITUDE, LATITUDE, ADDRESS)
values(2, 26.13020912194588, 44.43119013598689, 'Calea Calarasilor nr. 423, Bucuresti');

INSERT INTO restaurant(ID, NAME, ADDRESS_ID, DESCRIPTION, CONTACT, opening_time, closing_time )
values(1, 'King Restaurant',2, 'This is a short description for Salsa Restaurant','0725413587',10,22);



insert into menu_item(id,description,name,price,restaurant_id)
values(9, 'Spaghetti pasta, tomatoes sauce, beaf meat, condiments','Spaghetti Bolognese', 28.99, 1 );

insert into menu_item(id,description,name,price,restaurant_id)
values(10, 'Spaghetti pasta, white sauce, bacon, condiments, eggs','Spaghetti Carbonara', 30.99, 1 );

insert into menu_item(id,description,name,price,restaurant_id)
values(11, 'White flour, mozzarela, mushrooms, meat, olives','Quattro Stagioni', 25.99, 1 );

INSERT INTO restaurant_managers(restaurant_id, id)
values(2,5);
INSERT INTO restaurant_managers(restaurant_id, id)
values(1,3);
INSERT INTO restaurant_managers(restaurant_id, id)
values(3,6);

insert into menu_item(id,description,name,price,restaurant_id)
values(11, 'White flour, mozzarela, mushrooms, meat, olives','Quattro Stagioni', 25.99, 1 );

#insert into user_order(id, status, total, address_id, customer_id, )
