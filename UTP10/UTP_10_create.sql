-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-01-23 10:53:48.09

-- tables
-- Table: groups
CREATE TABLE groups (
    group_id integer  NOT NULL,
    group_name varchar2(30)  NOT NULL,
    group_description varchar2(1000)  NOT NULL,
    CONSTRAINT groups_pk PRIMARY KEY (group_id)
) ;

-- Table: groups_users
CREATE TABLE groups_users (
    user_id integer  NOT NULL,
    group_id integer  NOT NULL,
    CONSTRAINT groups_users_pk PRIMARY KEY (user_id,group_id)
) ;

-- Table: users
CREATE TABLE users (
    user_id integer NOT NULL,
    user_login varchar2(30) NOT NULL,
    user_password varchar2(30)  NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (user_id)
) ;

-- foreign keys
-- Reference: groups_users_groups (table: groups_users)
ALTER TABLE groups_users ADD CONSTRAINT groups_users_groups
    FOREIGN KEY (group_id)
    REFERENCES groups (group_id);

-- Reference: groups_users_users (table: groups_users)
ALTER TABLE groups_users ADD CONSTRAINT groups_users_users
    FOREIGN KEY (user_id)
    REFERENCES users (user_id);

-- End of file.

