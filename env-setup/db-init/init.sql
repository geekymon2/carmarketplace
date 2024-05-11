-- create a mysql user and allow connection remotely
CREATE USER 'mon2'@'%' IDENTIFIED BY <password>;
GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION; -- TODO: this needs to be improved to only grant the minimum required.
FLUSH PRIVILEGES;

-- create schemas for local development
CREATE DATABASE IF NOT EXISTS carinfodbdev
CREATE DATABASE IF NOT EXISTS carlistingdbdev
CREATE DATABASE IF NOT EXISTS userdbdev

-- create schemas for ci environment
CREATE DATABASE IF NOT EXISTS carinfodbci
CREATE DATABASE IF NOT EXISTS carlistingdbci
CREATE DATABASE IF NOT EXISTS userdbci
-- create tables

-- create data
