# Movie Service
You can test this app following by [link](http://zapara-movie.herokuapp.com/). 
Just look at items 7 and 8 in [Setup](#setup) for this.
## Table of Contents

- [Description](#description)
- [Features](#features)
- [Technologies](#technologies)
- [Setup](#setup)

## Description
The main purpose of this project is to show my skills in Java and its popular frameworks as Hibernate and Spring. 
In this project I use such principles as OOP, SOLID, DI, REST.

## Features
- Registration of a user `POST: /register`
- Users and admins can be shown: cinema halls `GET: /cinema-halls`,
  available movie sessions `GET: /movie-sessions/available`,
  movies `GET: /movies`, some specific movie session `GET: /movie-sessions/{id}`. Also, you can logout `GET: /logout`
- Admins can add new cinema halls `POST: /cinema-halls`, movies `POST: /movies`,
movie sessions `POST: /movie-sessions`
- Admins can update and delete movie session `PUT: /movie-sessions/{id}`, 
`DELETE: /movie-sessions/{id}` and get some user by email `GET: /users/by-email`
- Users can get their orders and shopping carts `GET: /orders`, `GET: /shopping-carts/by-user`, 
complete orders `POST: /orders/complete` and add tickets to some movie session to the shopping cart `PUT: /shopping-carts/movie-sessions`

## Technologies
- Java (JDK version 11)
- Hibernate (version 5.4.27.Final)
- Spring (Spring Core, Spring Web, Spring Security)
- MySQL (version 8.0.22)
- Tomcat (version 9.0.54), to run application locally

## Setup
1. Download and install MySQL.
2. Download and install Tomcat (version 9.0.54).
3. Fork this project and clone it to your Java IDE.
4. Create schema (download MySQL Workbench if you need).
5. Add your information in `db.properties` file in `src/main/resources` folder.

```
#MySQL properties
db.driver=YOUR_DRIVER
db.url=YOUR_DATABASE_URL
db.user=YOUR_USERNAME
db.password=YOUR_PASSWORD

#Hibernate properties
hibernate.show_sql=true
hibernate.hbm2ddl.auto=create
hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

Username and password is data which you used to connect to MySQL Server (in Workbench, Database tool in IDE etc.).
Example of URL: `jdbc:mysql://localhost:3306/movie_service?serverTimezone=UTC`.
Example of Driver: `com.mysql.cj.jdbc.Driver`.
If you use another DBMS change `hibernate.dialect`, as well.

6. Run this app with Tomcat local server.
7. You will be redirected to login page. You can use username `alice12@mail.com` with password `12345` to login as admin or
username `bobby@mail.ua` with password `qwerty` to login as user.
8. If you want to send another requests instead GET use [POSTMAN](https://www.postman.com/) or other similar app.
