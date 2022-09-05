# SerenityWithJPA
This is a serenity project with the implementation of a connection to a MYSQL database using JPA with the Hibernate library.

##You can create MYSQL database using docker using the following steps (Docker needed):
```
docker run -p 3306:3306 --name mysql2 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
```

Then star mysql client:
```
docker exec -it mysql2 mysql -uroot -p
```

Now create the database
```
CREATE DATABASE serenity_automation;
```
```
USE serenity_automation;
```

And create de Users table:

```
CREATE TABLE users ( id smallint unsigned not null auto_increment, name varchar(20) not null,email varchar(30) not null, constraint pk_users primary key
(id));
```
You can insert data:
```
INSERT INTO users ( id, name, email) VALUES ( null, 'Travis Barker', 'travismail@mail.com');
```
