Backend Challenge Solution Documentation
Overview

This repository contains the solution for the backend challenge focused on building an event-sourced CQRS application using the Axon framework. The application simulates a platform that offers loans to Real Estate Developers and allows Investors to invest in these loans.

## Table of Contents

- Content/Structure
- Technical Stack
- Getting Started
- API Endpoints
- Database Schema
- Testing
- Additional Resources

## Content / Structure

Used AskTheCode

The repository for the backend challenge seems to be a Java-based project, structured using Gradle. Here's a brief overview of the repository structure:

1. **Docker and Compose Files**:
   - Dockerfile: Contains the Docker configuration for the project.
   - compose.yaml: Docker Compose configuration file.

2. **Documentation**:
   - HELP.md: Might contain help or troubleshooting information.
   - README.md: The main documentation file that usually contains an introduction, setup instructions, and other relevant information.

3. **Gradle Configuration**:
   - build.gradle: Contains build configurations and dependencies.
   - settings.gradle: Contains settings for the Gradle build.
   - gradlew and gradlew.bat: Gradle wrapper scripts for Unix and Windows respectively.
   - gradle/wrapper/: Contains the Gradle wrapper JAR and properties.

4. **Source Code**:
   - src/main/java/com/linus/finance/challenge/: Contains the main application code.
   - BackendApplication.java: The main application entry point.
   - aggregate/: Contains aggregates like LoanAggregate.java.
   - command/: Contains command classes like CreateLoanCommand.java and LoanRepaymentCommand.java.
   - config/: Configuration files like AxonConfig.java.
   - controller/: Contains controller classes like LoanController.java and LoanQueryController.java.
   - event/: Contains event classes like LoanCreatedEvent.java and LoanRepaymentEvent.java.
   - handlers/: Contains handler classes like LoanCommandHandler.java and LoanEventHandler.java.
   - model/: Contains model classes like Investor.java and Loan.java.
   - projections/: Contains projection classes like LoanProjection.java and related view and repository.
   - src/main/resources/: Contains resources like application.properties.

5. **Tests**:
   - src/test/java/com/linus/finance/challenge/: Contains test classes.
   - BackendApplicationTests.java: Test for the main application (empty. See aggregate/LoanAggregateTest.kt)
   - aggregate/: Contains tests for aggregates like LoanAggregateTest.kt.


## Technical Stack

- Language: Java and Kotlin
- Framework: Spring Boot
- Event Sourcing: Axon Framework
- Database: H2 in-memory database

## Getting Started

### Prerequisites

- Java 11
- Docker (optional for containerized deployment)

### Running the Application

 1. Clone the repository:

    ```bash
    git clone https://github.com/Eskabore/1693381999427_backend_challenge.git
    ```
    
2. Navigate to the project directory and run the application using Gradle:

    ```bash
    ./gradlew bootRun
    ```

3. For containerized deployment, use the provided Dockerfile and compose.yaml.

### Configuration
The application is pre-configured to use an in-memory H2 database for ease of development and testing. The H2 console is enabled for direct database access and can be accessed at http://localhost:8080/h2-console.

## API Endpoints

- Loan Repayment Command Endpoint: Trigger a loan repayment command.
- Fetch Loan Repayments: Retrieve loan repayments based on Loan ID.
- Fetch Investor Repayments: Retrieve investor repayments based on Investor Name.

## Database Schema

### Loan

- id: Unique identifier for the loan.
- name: Name or description of the loan.
- principal: Principal amount of the loan.
- interest: Interest associated with the loan.

### Investor

- id: Unique identifier for the investor.
- name: Name of the investor.
- amountInvested: Amount invested by the investor.
- interest: Interest rate for the invested amount.
- loanId: Reference to the associated loan.

## Testing

Tests have been written to cover the primary functionalities of the application. To run the tests, use the following command:

```bash
./gradlew test
 ```



## Content / Structure

Used AskTheCode

The repository for the backend challenge seems to be a Java-based project, structured using Gradle. Here's a brief overview of the repository structure:
    
1. **Docker and Compose Files**:
        - Dockerfile: Contains the Docker configuration for the project.
        - compose.yaml: Docker Compose configuration file.

2. **Documentation**:
        - HELP.md: Might contain help or troubleshooting information.
        - README.md: The main documentation file that usually contains an introduction, setup instructions, and other relevant information.

3. **Gradle Configuration**:
        - build.gradle: Contains build configurations and dependencies.
        - settings.gradle: Contains settings for the Gradle build.
        - gradlew and gradlew.bat: Gradle wrapper scripts for Unix and Windows respectively.
        - gradle/wrapper/: Contains the Gradle wrapper JAR and properties.

4. **Source Code**:
        - src/main/java/com/linus/finance/challenge/: Contains the main application code.
            - BackendApplication.java: The main application entry point.
            - aggregate/: Contains aggregates like LoanAggregate.java.
            - command/: Contains command classes like CreateLoanCommand.java and LoanRepaymentCommand.java.
            - config/: Configuration files like AxonConfig.java.
            - controller/: Contains controller classes like LoanController.java and LoanQueryController.java.
            - event/: Contains event classes like LoanCreatedEvent.java and LoanRepaymentEvent.java.
            - handlers/: Contains handler classes like LoanCommandHandler.java and LoanEventHandler.java.
            - model/: Contains model classes like Investor.java and Loan.java.
            - projections/: Contains projection classes like LoanProjection.java and related view and repository.
        - src/main/resources/: Contains resources like application.properties.

5. **Tests**:
        - src/test/java/com/linus/finance/challenge/: Contains test classes.
            - BackendApplicationTests.java: Test for the main application (empty. See aggregate/LoanAggregateTest.kt)
            - aggregate/: Contains tests for aggregates like LoanAggregateTest.kt.