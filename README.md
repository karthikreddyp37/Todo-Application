# Todo Application

This is a simple Todo application built with Spring Boot and MySQL.

## Features

- Create, read, update, and delete todo items
- User authentication and session management using Spring Security
- JSP for view rendering
- CRUD operations with Spring Data JPA and MySQL

## Requirements

- Java 21 or higher
- Maven
- MySQL
- Git


## Running the Application

1. The application will start on `http://localhost:8080`.

## Accessing the Application

- The login page can be accessed at `http://localhost:8080/`
- Use the following credentials to log in:
  - Username: `karthikrp`
  - Password: `reddy`

### Main Classes and Files

#### `MyfirstwebappApplication.java`

This is the main class for starting the Spring Boot application.

#### `application.properties`

Contains configuration settings for the Spring Boot application, including database connection details and view resolver settings.

#### `ToDo.java`

This is the entity class representing a Todo item. It includes fields for ID, username, description, target date, and completion status.

#### `TodoControllerJpa.java`

This controller handles HTTP requests for managing Todo items. It provides methods for listing, adding, updating, and deleting todos.

#### `TodoRepository.java`

This is a Spring Data JPA repository interface for the `ToDo` entity.

#### `TodoService.java`

This service class provides business logic for managing Todo items.

#### `WelcomeController.java`

This controller handles the welcome page and retrieves the logged-in username from the security context.

#### `SpringSecurityConfiguration.java`

This class configures Spring Security for the application, setting up in-memory user details and security filters.

## JSP Views
The application uses JSP files for rendering views. These files are located in src/main/resources/META-INF/resources/WEB-INF/jsp/:

listTodos.jsp: Displays the list of todo items.
todo.jsp: Form for adding and updating todo items.
welcome.jsp: Welcome page after login.

## Logging
The application.properties file also configures logging settings for the application:
logging.level.org.springframework=debug

## Database Initialization using Docker

 Launch MySQL using Docker:
    ```sh
    docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle
    ```

The application uses an `application.properties` file to configure the MySQL database connection and following dependency. Make sure to set up the database as described in the installation steps (BELOW).

```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/todos
spring.datasource.username=todos-user
spring.datasource.password=dummytodos
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

```dependency
<dependency>
<groupId>com.mysql</groupId>
<artifactId>mysql-connector-j</artifactId>
<version>8.3.0</version>
</dependency>
```

MySQL Shell Commands

To interact with the MySQL database using MySQL Shell, use the following commands:

```Start MySQL Shell:
mysqlsh
```

```Connect to the database:
\connect todos-user@localhost:3306
```

```Switch to SQL mode:
\sql
```

```Use the todos database:
use todos;
```

```Query the todo table:
select * from to_do;
```

```Exit MySQL Shell:
\quit
```

Docker Commands

To manage the Docker container, use the following commands:

```List running containers:
docker container ls
```

```Stop a container:
docker container stop <container_id>
```
