-- create a mysql user and allow connection remotely
CREATE USER 'mon2'@'%' IDENTIFIED BY <password>;
GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION; -- TODO: this needs to be improved to only grant the minimum required.
FLUSH PRIVILEGES;

-- create schemas

-- create tables

-- create data
