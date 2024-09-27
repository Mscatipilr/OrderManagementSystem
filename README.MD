
# Order Management System

This project is a simple **Order Management System** built with **Spring Boot**. It allows you to manage orders and products, and supports basic CRUD operations for both. Additionally, products are seeded into the database when the application starts.

[Jump to Docker Set-Up](#order-management-system---docker-setup)

## Features

- Create, read, update, and delete orders and products.
- Automatic product seeding on application startup.
- Date auto-generation for orders when they are created.
- REST API support for easy integration.
- Product management with price information.

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (for development and testing)
- **Lombok** (for reducing boilerplate code)
- **JUnit 5** (for unit testing)

## Getting Started

### Prerequisites

To run this project, you need the following installed on your system:

- **Java 17**
- **Maven 3.8+** (to build and manage dependencies)

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/order-management-system.git
   ```

2. Navigate to the project directory:

   ```bash
   cd order-management-system
   ```

3. Build the project with Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. The application will start on port 8080 by default.

### Accessing the H2 Database Console

You can access the H2 database console by visiting:

```
http://localhost:8080/h2-console
```

Use the following credentials to log in:
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## API Endpoints

Here are the available REST API endpoints for managing orders and products:

### Orders

- **Create Order**: `POST /orders`
  ```json
  {
      "productNames": ["Apple", "Banana"],
      "totalPrice": 1.50
  }
  ```

- **Get All Orders**: `GET /orders`

- **Update Order**: `PUT /orders/{id}`

- **Delete Order**: `DELETE /orders/{id}`

### Products

- **Create Product**: `POST /products`
  ```json
  {
      "name": "Apple",
      "price": 1.00
  }
  ```

- **Get All Products**: `GET /products`

- **Update Product**: `PUT /products/{id}`

- **Delete Product**: `DELETE /products/{id}`

## Seeding Products on Startup

On application startup, the following products are added to the database by default:

- Apple ($1.00)
- Banana ($0.50)
- Orange ($0.75)

This is achieved through the `CommandLineRunner` interface, which seeds the database upon initialization.

## Auto-Generated Order Date

When an order is created, the current date is automatically set for the `date` field. This is done using the `@PrePersist` annotation in the `Orders` entity.

## Running Tests

To run the unit tests, execute the following command:

```bash
mvn test
```
# Order Management System - Docker Setup

## Prerequisites

- Docker installed on your machine
- (Optional) Docker Compose if you're using multiple services

## Steps to Build and Run the Docker Container

### 1. Build the Docker Image

Run the following command to build the Docker image:

```bash
docker build -t order-management-system .
```
### 2. Exit
Ctrl C to shut down the system.