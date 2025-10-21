# Spring Security Example

A simple, end-to-end Spring Boot application that demonstrates how to secure a web app using Spring Security. It includes form-based login, role-based authorization, sample data bootstrapping, a basic domain model (Users, Customers, Products, Carts, Orders), and a Thymeleaf UI.

![](https://img.shields.io/badge/Editor-IntelliJ-informational?style=flat&logo=intellij-idea)
![](https://img.shields.io/badge/Java-1.8-blue?style=flat&logo=java)
![](https://img.shields.io/badge/Spring%20Boot-2.2.6-brightgreen?style=flat&logo=spring-boot)
![](https://img.shields.io/badge/Spring%20Security-enabled-green?style=flat&logo=springsecurity)
![](https://img.shields.io/badge/Build-Maven-orange?style=flat&logo=apache-maven)


## Table of Contents
- Overview
- Features
- Tech Stack
- Security and Access Rules
- Default Users
- Getting Started
  - Prerequisites
  - Run Locally
  - Build a JAR
- Useful Routes
- Testing
- Troubleshooting


## Overview
This project showcases common Spring Security building blocks in a traditional MVC application:
- A login form at a custom endpoint
- Role-based access to controller endpoints
- In-memory H2 database with JPA entities and repositories
- Sample data loaded on startup for quick exploration


## Features
- Form login with a custom login page (`/login`)
- Role-based authorization:
  - Customers have access to customer-related routes
  - Admins have access to administrative user routes
- Public product catalogue pages
- JPA/Hibernate persistence with H2 (runtime)
- Thymeleaf views and Bootstrap via WebJars


## Tech Stack
- Java 8
- Spring Boot 2.2.6
- Spring Security
- Spring Data JPA (Hibernate)
- H2 Database (runtime)
- Thymeleaf, WebJars (Bootstrap, jQuery)
- Maven (with Maven Wrapper)


## Security and Access Rules
Configured in `SpringSecConfig`:
- Public:
  - `/product/**`
  - `/webjars/**`
  - `/**/favicon.ico`
- Authenticated:
  - `/customer/**`
- Admin only:
  - `/user/**` (requires `ADMIN` authority)
- Custom pages:
  - Login page: `/login`
  - Access denied: `/access_denied`

Note: The configuration includes H2 console specific handling. If you enable the H2 console (see Troubleshooting), remember this is for development only.


## Default Users
On startup, sample users and roles are created in `SpringJPABootStrap`:

- Username: `mweston` — Password: `password` — Roles: `CUSTOMER`
- Username: `fglenanne` — Password: `password` — Roles: `CUSTOMER`, `ADMIN`
- Username: `saxe` — Password: `password` — Roles: `CUSTOMER`

All users are associated with a `Customer` entity and get sample carts, orders, and products.


## Getting Started
### Prerequisites
- Java 8 (or newer compatible with Spring Boot 2.2.x)
- Git
- Optional: Maven installed (the project provides the Maven Wrapper)

### Run Locally (recommended)
From the project root:

- Windows: `mvnw.cmd spring-boot:run`
- macOS/Linux: `./mvnw spring-boot:run`

The app starts on http://localhost:8080

### Build a JAR
- Windows: `mvnw.cmd clean package`
- macOS/Linux: `./mvnw clean package`

Then run:
- `java -jar target/demo-0.0.1-SNAPSHOT.jar`


## Useful Routes
- Home: `/`
- Products (public): `/product` and `/product/{id}`
- Customers (auth required): `/customer` and related CRUD routes
- Users (admin only): `/user` and related CRUD routes
- Login: `/login`
- Access denied: `/access_denied`


## Testing
Run the test suite with:
- Windows: `mvnw.cmd test`
- macOS/Linux: `./mvnw test`


## Troubleshooting
- H2 Console: To enable the H2 console for development, add the following to `src/main/resources/application.properties` and restart:
  - `spring.h2.console.enabled=true`
  - Access at `http://localhost:8080/h2-console`

- Port already in use: Change the port by adding `server.port=8081` to `application.properties`.

- Clean state: If you encounter issues after code changes, try `mvnw.cmd clean` (Windows) or `./mvnw clean` (macOS/Linux) and run again.


## License
No explicit license file is provided. If you plan to use this code in your own projects, verify licensing requirements for your use case.
