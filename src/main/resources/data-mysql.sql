delete from users;
delete from roles;

INSERT INTO roles(id,name) VALUES(1,'ROLE_CUSTOMER');
INSERT INTO roles(id,name) VALUES(2,'ROLE_RESTAURANT_MANAGER');
INSERT INTO roles(id,name) VALUES(3,'ROLE_DELIVERY_MAN');
INSERT INTO roles(id,name) VALUES(4,'ROLE_ADMIN');

INSERT INTO users(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, USERNAME, ROLE_ID)
values(1, 'Admin','TEST', 'admin@email.com','$2a$10$uGJ6zgNNfTK6XHUX5GMR5.Z2JU2E2N.fNeIJKcOA5fliRKwE9U.kG','admin','4');

INSERT INTO users(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, USERNAME, ROLE_ID)
values(2, 'Delivery','TEST', 'delivery@email.com','$2a$10$uGJ6zgNNfTK6XHUX5GMR5.Z2JU2E2N.fNeIJKcOA5fliRKwE9U.kG','delivery','3');

INSERT INTO users(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, USERNAME, ROLE_ID)
values(3, 'RestaurantManager','TEST', 'manager@email.com','$2a$10$uGJ6zgNNfTK6XHUX5GMR5.Z2JU2E2N.fNeIJKcOA5fliRKwE9U.kG','manager','2');

INSERT INTO users(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, USERNAME, ROLE_ID)
values(4, 'Customer','TEST', 'customer@email.com','$2a$10$uGJ6zgNNfTK6XHUX5GMR5.Z2JU2E2N.fNeIJKcOA5fliRKwE9U.kG','customer','1');