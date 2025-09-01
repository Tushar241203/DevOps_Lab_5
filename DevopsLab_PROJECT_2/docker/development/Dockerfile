# Development Dockerfile
FROM node:18-alpine

# Set working directory
WORKDIR /app

# Install Angular CLI
RUN npm install -g @angular/cli@17

# Copy package files
COPY angular-app/package*.json ./

# Install dependencies
RUN npm install

# Copy source code
COPY angular-app/ .

# Expose port
EXPOSE 4200

# Start development server with host binding
CMD ["ng", "serve", "--host", "0.0.0.0", "--port", "4200", "--poll", "1000"]