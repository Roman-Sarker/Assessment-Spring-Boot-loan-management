# Car Loan Management System

## Overview
The **Car Loan Management System** is a Spring Boot application designed to manage car loans efficiently. It integrates modern technologies and best practices to provide a solution for car loan management.

---

## Features
- Manage loans and customer information.
- Database integration using JPA.
- Querying with custom DTOs for optimized data transfer.
- Used join query on Loan and Customer to fetch and present combined information efficiently.
- Used AOP for logging to centralize and simplify logging across the application.
- Unit testing with JUnit and Mockito.
- Extendable architecture for future API integrations.
- Structured project directory and Maven-based dependency management.

---

## Tech Stack
- **Backend**: Java 17, Spring Boot 3.4.1
- **Database**: H2 (for development)
- **Build Tool**: Maven
- **Testing**: JUnit 5, Mockito

---

## Prerequisites
- Java 17 installed.
- Maven 3.8+ installed.
- IDE (IntelliJ IDEA, Eclipse, or similar).

---

## Endpoints
### Loan Management
- `POST /localhost:8080/loans` - Create a new loan.
- `GET /localhost:8080/loans/search?loanId=&page=0&size=2` - Retrieve specific or all loan details with pagination.
- `GET /localhost:8080/loans/with-customers` - Retrieve loan and respective customer details by joining the query between two tables.
- `PUT /localhost:8080/loans/{id}` - Update loan by id.
- `DELETE /localhost:8080/loans/{id}` - Delete loan by id.
- `GET /localhost:8080/loans/{id}` - Retrieve loan details by id.
- `GET /localhost:8080/loans` - Retrieve all loans.

### Customer Management
- `GET /localhost:8080/customer/installmentHistory` - Called external API (https://dummyjson.com/c/e5f5-0745-49e8-acf5) from service class method
---

## Setup
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Roman-Sarker/Assessment-Spring-Boot-loan-management.git
   cd car-loan-management
   ```

2. **Build the Project**:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the Application by Postman**:
   - Postman Collection Added inside project (Assessment.postman_collection.json)
   
---

## Unit Testing
### Frameworks Used:
- **JUnit 5**: For writing and running tests.
- **Mockito**: For mocking dependencies in unit tests.

### Run Tests:
```bash
mvn test
```

---

## Project Structure
```
car-loan-management
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.carloan.management
│   │   │       ├── controller  # REST Controllers (LoanController and CustomerController)
│   │   │       ├── model       # Entities and DTOs 
│   │   │       ├── repository  # JPA Repositories (Query join table)
│   │   │       ├── service     # Business Logic (Service and Service Implementation)
│   │   │       ├── repository  # JPA Repositories (Query join table)
│   │   │       ├── aop     	# Logging Aspect for each Request, methods, and response
│   │   │       └── util	    # OpenFeign Client to call extarnal API
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql     # Database schema (Insert data on Loan and Customer table with the run of application)
│   ├── test
│       └── java
│           └── com.example.carloan.management
│               ├── controller  # Controller Tests
│               ├── service     # Service Tests
│               └── repository  # Repository Tests
├── pom.xml  # Maven Configuration
└── README.md
```

---

## Author
Developed by Roman Sarker, 
Senior Java Developer
(Web : https://romantechlife.blogspot.com/)


