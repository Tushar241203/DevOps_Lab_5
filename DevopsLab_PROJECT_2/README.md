# Angular Docker Project

Deploy an Angular application using Docker with separate configurations for development and production environments.

## Project Structure

```
DevopsLab_PROJECT_2/
├── angular-app/              # Angular application
├── docker/
│   ├── development/
│   │   └── Dockerfile        # Development container with hot reload
│   ├── production/
│   │   └── Dockerfile        # Multi-stage production build with Nginx
│   └── nginx/
│       └── nginx.conf        # Nginx configuration for production
├── docker-compose.yml        # Development environment
├── docker-compose.prod.yml   # Production environment
└── README.md
```

## Development Environment

### Start Development Server
```bash
# Build and start development container with hot reload
docker-compose up --build

# Access the application at http://localhost:4200
```

### Development Features
- Hot reload enabled
- Source code mounted as volumes
- Angular CLI development server
- File watching enabled for Windows

## Production Environment

### Build and Start Production Server
```bash
# Build and start production container
docker-compose -f docker-compose.prod.yml up --build

# Access the application at http://localhost:80
```

### Production Features
- Multi-stage Docker build
- Optimized Angular build
- Nginx web server
- Gzip compression
- Static file caching
- Security headers
- Health checks

## Commands

### Development
```bash
# Start development environment
docker-compose up -d

# View logs
docker-compose logs -f

# Stop development environment
docker-compose down

# Rebuild containers
docker-compose up --build
```

### Production
```bash
# Start production environment
docker-compose -f docker-compose.prod.yml up -d

# View logs
docker-compose -f docker-compose.prod.yml logs -f

# Stop production environment
docker-compose -f docker-compose.prod.yml down

# Rebuild containers
docker-compose -f docker-compose.prod.yml up --build
```

### Cleanup
```bash
# Remove all containers, networks, and images
docker-compose down --rmi all -v
docker-compose -f docker-compose.prod.yml down --rmi all -v
```

## Technologies Used

- **Angular 17** - Frontend framework
- **Docker** - Containerization
- **Docker Compose** - Multi-container orchestration
- **Nginx** - Production web server
- **Node.js 18** - Runtime environment