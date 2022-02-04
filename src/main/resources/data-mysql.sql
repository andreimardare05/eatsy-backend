delete from user_order_item;
delete from menu_item;
delete from user_order;
delete from restaurant_managers;
delete from restaurant;
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
