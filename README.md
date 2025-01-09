# Full Stack E-Commerce Application

This project is designed to be a real-world example of a full-stack application, combining an Angular front-end with a Spring Boot back-end. The application communicates via REST APIs and uses MariaDB as its database.

---

## **Project Overview**

This e-commerce application features:
- **Communication**: Seamless communication between the front-end and back-end using REST APIs.
- **Full CRUD support**: For all core entities in the application.
- **Feature Highlights**:
    - Product listing and filtering.
    - Shopping cart functionality, including add, update, and delete operations.
    - Secure user login/logout.
    - Order checkout and previous order tracking for authenticated users.

---

## **Wireframes and Features**

### **Home Page**
- **Search bar**: Quickly find products.
- **Category navigation**: Shop by product category.
- **Product listing**: Display paginated product listings with essential details.

### **Product Details Page**
- View detailed information about a product, including:
    - Title, description, price, and availability.
    - Option to add the product to the shopping cart.

### **Shopping Cart Page**
- **Cart operations**: Increase or decrease item quantities, remove items, and view cart subtotals.
- **Checkout**: Proceed to checkout with a summarized total.

### **Checkout Page**
- Collect user details, shipping/billing information, and payment details.
- Review and confirm orders.

---

## **Development Milestones**

### **Release Plan**
1. **Version 1.0**: Product listing and display.
2. **Version 2.0**: Add shopping cart functionality and checkout.
3. **Version 3.0**: User authentication and order history tracking.

### **Database Schema**
The initial database schema includes:
- **Product Table**:
    - Fields: ID, SKU, name, description, price, image URL, active status, stock quantity, creation and update dates, and category ID.
- **Product Category Table**:
    - Fields: ID, category name.

This schema will grow as the project evolves, adding more functionality.

---

## **Technology Stack**

### **Back-End**
- **Spring Boot**:
    - REST APIs using Spring Data REST.
    - CRUD support through `JpaRepository`.
    - Dependency injection and application management.
- **Database**:
    - **MariaDB**: Store and manage product and order data.

### **Front-End**
- **Angular**:
    - Dynamic and responsive user interface.
    - Integration with the back-end via REST APIs.

### **Other Tools**
- **Lombok**:
    - Reduces boilerplate code for Java classes (e.g., getters and setters).
- **Gradle**:
    - Build and dependency management.

---

## **Getting Started**

### **Prerequisites**
Ensure you have the following installed:
- **Java Development Kit (JDK)**: Version 11 or higher.
- **Gradle**: For project build and dependency management.
- **MariaDB**: For the database.
- **Node.js and npm**: Required for Angular.

---

### **Setup Instructions**

#### **Database Setup**
1. Start MariaDB and create a user for the application:
   ```sql
   CREATE USER 'ecommerceapp'@'localhost' IDENTIFIED BY 'ecommerceapp';
   GRANT ALL PRIVILEGES ON *.* TO 'ecommerceapp'@'localhost';
   FLUSH PRIVILEGES;
   ```
2. Execute the database scripts:
    - **`01-create-user.sql`**: Sets up the database user.
    - **`02-create-products.sql`**: Creates tables and loads initial sample data.

#### **Back-End Setup**
1. Clone the repository.
2. Navigate to the `backend` directory and run:
   ```bash
   ./gradlew bootRun
   ```
3. The Spring Boot application will start on `http://localhost:8080`.

#### **Front-End Setup**
1. Navigate to the `frontend` directory and run:
   ```bash
   npm install
   ng serve
   ```
2. The Angular application will start on `http://localhost:4200`.

---

## **Development Highlights**

### **REST API with Spring Data REST**
- Automatically exposes CRUD REST endpoints for entities.
- Example: `ProductRepository` automatically provides endpoints like:
    - `GET /products`: Retrieve products.
    - `POST /products`: Add a product.
    - `PUT /products/{id}`: Update a product.
    - `DELETE /products/{id}`: Delete a product.

### **Advanced JPA Mappings**
- **Many-to-One**: Many products belong to one category.
- **One-to-Many**: One category has many products.

---

## **Future Enhancements**
- Implement advanced search and filter options.
- Add real-time order tracking.
- Integrate with a third-party payment gateway.
