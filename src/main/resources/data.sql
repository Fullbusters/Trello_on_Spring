
-- Create table
DROP TABLE IF EXISTS APP_USER;
create table APP_USER
(
  user_id           BIGINT not null AUTO_INCREMENT PRIMARY KEY ,
  User_Name         VARCHAR(36) not null,
  Encryted_Password VARCHAR(128) not null,
  Enabled           BIT not null
) ;

alter table APP_USER
  add constraint APP_USER_UK unique (User_Name);


-- Create table
DROP TABLE IF EXISTS APP_ROLE;
create table APP_ROLE
(
  Role_Id   BIGINT not null AUTO_INCREMENT PRIMARY KEY ,
  Role_Name VARCHAR(30) not null
) ;

alter table APP_ROLE
  add constraint APP_ROLE_UK unique (Role_Name);


-- Create table
DROP TABLE IF EXISTS USER_ROLE;
create table USER_ROLE
(
  Id      BIGINT not null AUTO_INCREMENT PRIMARY KEY ,
  User_Id BIGINT not null,
  Role_Id BIGINT not null
);

alter table USER_ROLE
  add constraint USER_ROLE_UK unique (User_Id, Role_Id);

alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (User_Id)
references APP_USER (User_Id);

alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (Role_Id)
references APP_ROLE (Role_Id);



insert into App_User ( User_Name, Encryted_Password, Enabled)
values ( 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into App_User (User_Name, Encryted_Password, Enabled)
values ( 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);



insert into app_role ( Role_Name)
values ( 'ROLE_ADMIN');

insert into app_role ( Role_Name)
values ( 'ROLE_USER');



insert into user_role ( User_id, Role_Id)
values ( 1, 1);

insert into user_role ( User_id, Role_Id)
values ( 1, 2);

insert into user_role ( User_id, Role_Id)
values ( 2, 2);

