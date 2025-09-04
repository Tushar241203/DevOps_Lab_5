# Stage 1: Build Angular app
FROM node:20-alpine AS build
WORKDIR /app

# Copy package files and install dependencies
COPY package*.json ./
RUN npm install

# Copy all source files and build Angular app
COPY . .
RUN npm run build --prod

# Stage 2: Serve with Nginx
FROM nginx:alpine
# Remove default nginx page
RUN rm -rf /usr/share/nginx/html/*

# Copy built Angular files from Stage 1
COPY --from=build /app/dist/my-angular-app/browser/ /usr/share/nginx/html/

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
