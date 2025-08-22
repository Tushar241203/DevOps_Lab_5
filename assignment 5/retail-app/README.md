# Retail Company Spring Boot Application

A comprehensive Spring Boot application for retail company management with Docker containerization support.

## Features

- Product management (CRUD operations)
- Category-based product filtering
- Product search functionality
- Price range filtering
- Stock management
- RESTful API endpoints
- Docker containerization
- PostgreSQL database support
- H2 in-memory database for development

## Technologies Used

- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database (Development)
- PostgreSQL (Production)
- Docker & Docker Compose
- Maven

## Quick Start

### Prerequisites

- Java 17+
- Maven 3.6+
- Docker & Docker Compose

### Running with Maven

```bash
# Build the application
mvn clean package

# Run the application
mvn spring-boot:run
```

### Running with Docker

```bash
# Build and run with Docker Compose
docker-compose up --build

# Or build the image manually
docker build -t retailcompany/retail-app:1.0.0 .
docker run -p 8080:8080 retailcompany/retail-app:1.0.0
```

## API Endpoints

- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create new product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product
- `GET /api/products/category/{category}` - Get products by category
- `GET /api/products/search?q={term}` - Search products
- `GET /api/products/out-of-stock` - Get out-of-stock products
- `GET /api/products/price-range?min={min}&max={max}` - Get products by price range
- `GET /api/health` - Health check endpoint

## Database Configuration

- Development: H2 in-memory database (accessible at http://localhost:8080/h2-console)
- Production: PostgreSQL with Docker Compose

## Docker Image Scanning

To scan the Docker image for vulnerabilities:

```bash
# Using Docker Scout (requires Docker Desktop)
docker scout quickview retailcompany/retail-app:1.0.0

# Using Trivy
trivy image retailcompany/retail-app:1.0.0

# Using Grype
grype retailcompany/retail-app:1.0.0
```

## Development

The application uses Spring Boot's development tools for hot reloading. Make sure to enable Spring DevTools in your IDE for the best development experience.

## License

This project is licensed under the MIT License.
