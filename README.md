# To-Do App (In-Memory Version)


This is an in-memory version of a simple **To-Do Application** built with **Spring Boot** and **Spring Security**. The application allows users to manage their tasks, including adding, updating, and deleting to-dos. It uses **JSP for views**, **Spring Security for authentication**, and **in-memory storage for tasks**.

## Features
- **User Authentication** using Spring Security (In-Memory Users)
- **CRUD Operations** for To-Do items
- **JSP-Based UI** with Bootstrap styling
- **Role-Based Access Control** (Admin & User roles)
- **Form Validation** using Spring's `@Valid`
- **Basic Date Picker Integration**

## Technologies Used
- **Spring Boot** (MVC, Security, Validation)
- **JSP & JSTL** (Frontend UI)
- **Bootstrap** (Styling)
- **Jakarta Persistence (JPA)** (For future database migration)
- **Maven** (Build & Dependency Management)

## Setup & Installation
 **Prerequisites**
- Java 17+
- Maven
- An IDE (Eclipse, IntelliJ, or VS Code)

**Clone the Repository**

git clone https://github.com/your-username/todo-app.git

cd todo-app

**Run the Application**
mvn spring-boot:run

**To Access the application**
Open a browser and go to: http://localhost:8080
Login Credentials:
Username: Vishali, Password: dummy

# Project Structure
- **Controller**: Handles HTTP requests

- **Model**: Represents the Todo entity

- **Repository**: TodoRepo (Not used in this version)

- **Security**: Spring Security configuration

- **Service**: Contains business logic for managing to-dos

- **Static Resources**: CSS and JavaScript files

- **Templates**: JSP views

- **Configuration**: application.yml (Spring configurations)


