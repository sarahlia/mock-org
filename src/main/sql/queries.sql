CREATE DATABASE IF NOT EXISTS mockorg_db;

CREATE USER mockorg_user@localhost IDENTIFIED BY 'p@$$w0rd';
GRANT ALL ON mockorg_db.* TO mockorg_user@localhost;