# Angular Docker Application

This project demonstrates how to deploy an Angular application using Docker with both development and production configurations.

## Features

- ✅ Angular CLI application
- ✅ Multi-stage Docker build
- ✅ Development and Production environments
- ✅ Docker Compose configuration
- ✅ Nginx for production serving
- ✅ Optimized for performance and security

## Quick Start

### Development Environment

```bash
# Build and run development environment
docker-compose -f docker-compose.dev.yml up --build

# Access the application
open http://localhost:4200
```

### Production Environment

```bash
# Build and run production environment
docker-compose up --build

# Access the application
open http://localhost:80
```

## Manual Docker Commands

### Development

```bash
# Build development image
docker build -f Dockerfile.dev -t angular-app:dev .

# Run development container
docker run -p 4200:4200 -v $(pwd):/app -v /app/node_modules angular-app:dev
```

### Production

```bash
# Build production image
docker build -t angular-app:prod .

# Run production container
docker run -p 80:80 angular-app:prod
```

## Project Structure

```
project-2/
├── src/                    # Angular source code
├── Dockerfile             # Production Docker configuration
├── Dockerfile.dev         # Development Docker configuration
├── docker-compose.yml     # Production Docker Compose
├── docker-compose.dev.yml # Development Docker Compose
├── nginx.conf             # Nginx configuration for production
├── package.json           # Node.js dependencies
└── angular.json           # Angular CLI configuration
```

## Environment URLs

- **Development**: http://localhost:4200
- **Production**: http://localhost:80

## Technologies Used

- Angular 16
- Docker & Docker Compose
- Nginx (for production)
- Node.js 18
- TypeScript
