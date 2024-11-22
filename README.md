# Bookstore Project - Safaricom

## Overview
The Bookstore Project is a Spring Boot application designed to manage a collection of books. It provides RESTful APIs to perform CRUD operations, borrow books, and return borrowed books.

---

## Features
- CRUD operations for books (Add, Get, Update, Delete).
- API to allow users to borrow a book.
- API to return a borrowed book.

---

## Instructions on How to Run the Project
- Attached SQL scripts for table and Postman collection

### 1. Clone the Repository
To get started, clone the repository to your local machine:

```bash
git clone https://github.com/joyapisi/bookstore-safaricom.git
cd bookstore-safaricom


### 2. Configure the Database
spring.datasource.url=jdbc:mysql://localhost:3306/book_directory
spring.datasource.username=joy
spring.datasource.password=joy@123

3. Build the Project
Use Maven to build the project:

bash
mvn clean install

4. Run the Application
Start the Spring Boot application:

bash
mvn spring-boot:run
The application will start on http://localhost:8080.

