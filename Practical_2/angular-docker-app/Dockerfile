# Stage 1: Build Angular app
FROM node:18-alpine as build

WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Stage 2: Nginx to serve Angular app
FROM nginx:alpine

# Copy built files from Stage 1
COPY --from=build /app/dist/angular-docker-app /usr/share/nginx/html

# Copy custom nginx config (optional)
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
