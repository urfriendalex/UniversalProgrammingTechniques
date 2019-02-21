-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-01-23 10:53:48.09

-- foreign keys
ALTER TABLE groups_users
    DROP CONSTRAINT groups_users_groups;

ALTER TABLE groups_users
    DROP CONSTRAINT groups_users_users;

-- tables
DROP TABLE groups;

DROP TABLE groups_users;

DROP TABLE users;

-- End of file.

