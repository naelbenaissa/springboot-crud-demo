﻿# Spring Boot CRUD API

A simple RESTful CRUD API built with **Spring Boot**, **Hibernate**, **MySQL**, and **Maven**.

This project demonstrates basic Create, Read, Update, and Delete operations on a `Person` entity.

## 💠 Technologies Used

* Java 17+
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Maven

## 📦 Features

* Get all persons
* Get a person by ID
* Create a new person
* Update an existing person
* Delete a person by ID

## 📱 API Endpoints

All endpoints are prefixed with `/api/persons`.

| Method | Endpoint            | Description         |
| ------ | ------------------- | ------------------- |
| GET    | `/api/persons`      | Get all persons     |
| GET    | `/api/persons/{id}` | Get person by ID    |
| POST   | `/api/persons`      | Create a new person |
| PUT    | `/api/persons/{id}` | Update person by ID |
| DELETE | `/api/persons/{id}` | Delete person by ID |

### 📅 Example Request Body (JSON)

```json
{
  "name": "John Doe",
  "city": "Paris",
  "phoneNumber": "0123456789"
}
```

## ⚙️ Configuration

Update `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## ▶️ How to Run

Make sure MySQL is running and the database is created.

Then run the project:

```bash
mvn clean install
mvn spring-boot:run
```

## 🗂 Project Structure

```
crud-springboot/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/naelbenaissa/crud_springboot/
│       │       ├── CrudSpringbootApplication.java
│       │       ├── Person.java
│       │       ├── PersonController.java
│       │       └── PersonRepository.java
│       └── resources/
│           └── application.properties
├── test/
├── target/
├── pom.xml
├── README.md
├── .gitignore
└── mvnw, mvnw.cmd
```
