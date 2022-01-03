CREATE TABLE user_info(
user_id int primary key auto_increment,
user_name varchar(10) not null,
user_password varchar(18) not null);

CREATE TABLE user_password(
target_password_id int primary key auto_increment,
user_id int not null,
target_name varchar(20) not null,
target_password varchar(30) not null,
target_information text not null,
FOREIGN KEY (user_id) REFERENCES user_info(user_id));

