# Java Spring Boot Maven Project

A simple Java Spring Boot application with REST API endpoints, Docker support, and Jenkins CI/CD pipeline configuration.

## Project Structure

```
java-maven-project/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/demo/
│   │           ├── DemoApplication.java
│   │           └── HelloController.java
│   └── test/
│       └── java/
│           └── com/example/demo/
│               └── DemoApplicationTests.java
├── Dockerfile
├── Jenkinsfile
├── pom.xml
├── .gitignore
└── README.md
```

## Features

- **Spring Boot 3.3.4** with Java 17
- REST API endpoints:
  - `GET /hello` - Returns a welcome message
  - `GET /api/health` - Health check endpoint
- **Docker** containerization support
- **Jenkins** CI/CD pipeline configuration
- **Maven** build system

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Docker (optional, for containerization)
- Jenkins (optional, for CI/CD)

## Building the Project

```bash
mvn clean compile
```

## Running the Application

```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## API Endpoints

- `GET /hello` - Returns "Hello from Java Spring Boot Application!"
- `GET /api/health` - Returns "Application is running successfully!"

## Docker Build

To build the Docker image:

```bash
docker build -t java-demo-app:1.0.0 .
```

To run the Docker container:

```bash
docker run -p 8080:8080 java-demo-app:1.0.0
```

## Jenkins Pipeline

The project includes a Jenkinsfile for CI/CD pipeline that includes:
- Code checkout
- Build and compile
- Testing
- Packaging
- Docker image building
- Docker image pushing (to configured registry)
- Deployment

## Configuration

Update the following in the Jenkinsfile:
- `DOCKER_REGISTRY` - Your Docker registry URL
- `IMAGE_NAME` - Your desired image name
- `VERSION` - Version tag for the image
- Git repository URL in the checkout stage

## Development

The project follows standard Maven structure and includes:
- Spring Boot auto-configuration
- REST controller with sample endpoints
- Unit test structure
- Proper dependency management
