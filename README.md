# Technical Assessment — Issue Tracker Application

## Backend (Spring Boot)
- Java 17 + Spring Boot 3.2
- REST API for managing tasks
- H2 in‑memory database for development
- Spring Data JPA for persistence
- DTO and mapping layer
- Spring Security configuration with CORS and CSP
- Unit tests using:
  - JUnit 5
  - Mockito
  - Spring Boot Test
  - MockMvc

## Frontend (Angular 17)
- Standalone component architecture
- Angular Material UI
- Task list display with Material cards
- Landing page with navigation
- Router‑based navigation
- Signals for state management
- Jasmine and Karma unit tests

## Project Structure
```
sitepen-issue-tracker/
├── api/                              # Spring Boot backend
│   ├── src/main/java/com/sitepen/issuetracker/
│   │   ├── controller/               # REST controllers
│   │   ├── service/                  # Service interfaces and implementations
│   │   ├── dto/                      # Data Transfer Objects
│   │   ├── entity/                   # JPA entities
│   │   ├── enums/                    # TaskStatus, TaskPriority
│   │   ├── repository/               # JPA and CRUD with framework for custom queries
│   │   └── config/                   # Security and CORS configuration
│   └── src/test/java/                # JUnit and Mockito tests
│
└── ui/                               # Angular frontend
    └── src/
        ├── app/
        │   ├── landing/              # Landing page
        │   ├── app.routes.ts
        │   ├── app.component.ts
        │   ├── core/
		│   │	├──models/   	  	  # Object models for users, projects, and tasks
		│   │	└──services/   		  # API service
        │   └── features/
		│   	├──task-list/   	  # Task list feature module
		│   	├──task-details/   	  # Task details feature module
		│   	├──project-list/   	  # Project list feature module
		│   	└──project-details/   # Project details feature module
        └── tests/                    # Jasmine unit tests
```

## Getting Started

### Prerequisites

- Java (JDK 11 or higher recommended)
- Node.js and npm (for the frontend)

### Running the API

Navigate to the `api/` directory and follow the build instructions for your Java build tool (Maven or Gradle). For example, if using Maven:

```bash
cd api
./gradlew bootRun
```

This will automatically seed data to the H2 database and will make endpoints available to `http://localhost:8080`

For testing,

```bash
./gradlew test
```

### Accessing the H2 Database

After starting the API, navigate to `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:taskmanagerdb`
- Username: `sa` / Password: *(empty)*

### Running the Web Client

Navigate to the `web/` directory and install dependencies, then start the development server:

```bash
cd web
npm install
npm start
```

You will be able to access the web application at `http://localhost:4200`

For testing,

```bash
ng test
```

### If I had 2 more days (or more)
- [ ] Complete remaining functionality and refactor code
- [ ] Switch H2 to PostgreSQL for production
- [ ] Separate a "My Issues" page from a list of all issues
- [ ] Account for accessibility and responsiveness
- [ ] Drag and drop issues to change order
- [ ] Display % done of each project
- [ ] User preferences with notification history and ability to opt for email notifications instead