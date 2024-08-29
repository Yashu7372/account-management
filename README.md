PostMan Collection:
https://api.postman.com/collections/9724473-0476b538-04ba-4957-b23a-1130aaf5c8bf?access_key=PMAT-01J6FMVB0GHDTJCTN2H6TW8X9C

# Account Management API

This is a Spring Boot-based RESTful API for managing user accounts. The API allows for creating, retrieving, updating, and deleting user accounts, as well as changing user passwords.

## Features

- User registration with email and password validation.
- Secure password storage using BCrypt.
- CRUD operations for user accounts.
- CORS configuration for frontend integration.
- Auto-generated Swagger documentation for API endpoints.
- Comprehensive unit testing with high code coverage.

## Technologies Used

- Java 17
- Spring Boot 3.1.3
- Spring Data JPA
- Spring Security
- H2 Database (for development and testing)
- Maven (build tool)
- JUnit 5 (testing)
- Mockito (mocking for tests)
- AssertJ (fluent assertions)
 # Account Management API
Getting Started
Prerequisites
JDK 17 or higher
Maven 3.6.0 or higher
Running the Application
Clone the repository:
git clone https://github.com/yourusername/account-management.git
cd account-management
Build and Run Application:
mvn clean install
mvn spring-boot:run
Run Test Cases:
mvn test

Get Coverage:
mvn jacoco:report

API Endpoints
User Management
POST /api/accounts/users - Create a new user
GET /api/accounts/users/{id} - Get user by ID
GET /api/accounts/users - Get all users
PUT /api/accounts/users/{id} - Update user information
DELETE /api/accounts/users/{id} - Delete user
PATCH /api/accounts/users/{id} - Change user password
