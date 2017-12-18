DROP DATABASE IF EXISTS trello;
create DATABASE trello CHARACTER SET utf8;
use trello;

-- Create table
DROP TABLE IF EXISTS App_User;
create table App_User
(
  User_Id            BIGINT not null AUTO_INCREMENT PRIMARY KEY ,
  User_Name          VARCHAR(36) not null,
  Encrypted_Password VARCHAR(128) not null,
  Enabled            BIT not null
) ;

alter table App_User
  add constraint APP_USER_UK unique (User_Name);


-- Create table
DROP TABLE IF EXISTS App_Role;
create table App_Role
(
  Role_Id   BIGINT not null AUTO_INCREMENT PRIMARY KEY ,
  Role_Name VARCHAR(30) not null
) ;

alter table App_Role
  add constraint APP_ROLE_UK unique (Role_Name);


-- Create table
DROP TABLE IF EXISTS User_Role;
create table User_Role
(
  Id      BIGINT not null AUTO_INCREMENT PRIMARY KEY ,
  User_Id BIGINT not null,
  Role_Id BIGINT not null
);

alter table User_Role
  add constraint USER_ROLE_UK unique (User_Id, Role_Id);

alter table User_Role
  add constraint USER_ROLE_FK1 foreign key (User_Id)
references App_User (User_Id);

alter table User_Role
  add constraint USER_ROLE_FK2 foreign key (Role_Id)
references App_Role (Role_Id);


DROP TABLE IF EXISTS Board;
create table Board
(
  Id BIGINT not null AUTO_INCREMENT PRIMARY KEY ,
  Name         VARCHAR(36) not null,
  Creator_Id BIGINT,
  Creator_Timestamp BIGINT not null

);
alter table Board
  add constraint CREATOR_FK foreign key (Creator_Id)
references App_User (User_Id);

insert into App_User ( User_Name, Encrypted_Password, Enabled)
values ( 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into App_User (User_Name, Encrypted_Password, Enabled)
values ( 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);



insert into App_Role ( Role_Name)
values ( 'ROLE_ADMIN');

insert into App_Role ( Role_Name)
values ( 'ROLE_USER');



insert into User_Role ( User_id, Role_Id)
values ( 1, 1);

insert into User_Role ( User_id, Role_Id)
values ( 1, 2);

insert into User_Role ( User_id, Role_Id)
values ( 2, 2);

