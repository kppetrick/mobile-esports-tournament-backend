# Mobile Esports Tournament Backend

This repository contains the backend for the mobile esports tournament platform. Built using Java with Spring Boot, it handles API requests, matchmaking, and database operations to power the platform's functionalities.

## Setup

### 1. Clone the repository
Clone this repository to your local machine:
```bash
git clone https://github.com/kppetrick/mobile-esports-tournament-backend.git
```

### 2. Navigate to the project directory
Go to the project folder:
```bash
cd mobile-esports-tournament-backend
```

### 3. Install dependencies
Ensure you have Maven installed and run the following command to download the necessary dependencies:
```bash
mvn install
```

### 4. Configure the database
Set up a PostgreSQL database and update the `application.properties` file with your database credentials:
```properties
spring.datasource.url=jdbc:postgresql://<your-database-url>:<port>/<database-name>
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```

### 5. Run the application
Start the backend server:
```bash
mvn spring-boot:run
```
The server will start at `http://localhost:8080`.

## Usage

Once the backend is running, it provides the following functionalities:

- **User Management:** APIs for user registration, authentication, and profile management.
- **Tournament Management:** Endpoints to create, update, and manage tournaments, teams, and schedules.
- **Matchmaking:** Real-time matchmaking logic for competitive play.
- **Payments:** Secure payment handling using Stripe API.
- **Live Updates:** WebSocket support for live match updates and notifications.
- **Statistics:** Serve player stats, leaderboards, and tournament details to the frontend and mobile app.

## Directory Structure
Here’s an overview of the project’s structure:
```
/mobile-esports-tournament-backend
├── /src/main/java            # Main Java source files
│   ├── /controllers          # REST API controllers
│   ├── /services             # Business logic and service layer
│   ├── /repositories         # Data access layer for database interaction
│   ├── /models               # Entity and data models
│   └── Application.java      # Main Spring Boot application entry point
├── /src/main/resources       # Configuration files
│   ├── application.properties # Spring Boot configuration file
│   └── static                # Static resources (if any)
├── /target                   # Compiled files after building
├── pom.xml                   # Maven configuration file
└── README.md                 # Documentation (this file)
```
## Key Folders and Files

### Project Structure

- `/src/main/java/controllers`: Contains all the API endpoint definitions.
- `/src/main/java/services`: Houses business logic, including matchmaking and payment handling.
- `/src/main/java/repositories`: Interfaces for interacting with the PostgreSQL database.
- `/src/main/java/models`: Defines the data models and entities used throughout the application.
- `application.properties`: Configuration file for database connections and other environment settings.


## Contributing

We welcome contributions! Follow these steps to contribute:

1. Fork this repository to your GitHub account.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with clear messages.
4. Push your changes to your forked repository.
5. Open a pull request describing your changes.

