**Click [here](http://fsp-demo.herokuapp.com/#/) for a live demo of [this](https://github.com/experiment322/fullstack-project-backend) combined with [fullstack-project-frontend](https://github.com/experiment322/fullstack-project-frontend).**

This project was bootstrapped with [SPRING INITIALIZR](https://start.spring.io/).

Below you will find some information on how to perform common tasks.

## Table of Contents

- [Adding a frontend](#adding-a-frontend)
- [Connecting to MySQL](#connecting-to-mysql)
- [Building](#building)
- [Running](#running)

## Adding a frontend

Spring Boot will automatically add static web resources located within any of the following directories:
* `/src/main/resources/static/`
* `/src/main/resources/public/`

Here you can add `index.html` which will be automatically mapped to `/`, the rest of the files being mapped to their path relative to one of the directories mentioned above.

>Note: Make sure to have the paths of the resources(css, js etc.) in frontend relative to this public path.

## Connecting to MySQL

First of all, make sure that MySQL server is running by executing **`service mysql status`**.

Then create a new schema and change the following in `/src/main/resources/application.properties`:
```INI
spring.datasource.url=jdbc:mysql://localhost:3306/[insert_new_schema_name_here]?useSSL=false
spring.datasource.username=[insert_your_mysql_username_here]
spring.datasource.password=[insert_your_mysql_password_here]
```

## Building

To build this project you need to have Maven installed and available on `PATH`. Check it with **`mvn -v`**.

After Maven is installed run **`mvn package`** in the root folder of the project. This will build a standalone `.jar` with all the dependencies needed inside.

## Running

After building the project you can run it by typing **`java -jar target/backend-[version].jar`** in the project's root path and the rocket will take off! :rocket:

Test it by accessing `http://localhost:8080/`.

>Note: You can find the version in `pom.xml`, i.e. `<version>1.0.0-RELEASE</version>`
