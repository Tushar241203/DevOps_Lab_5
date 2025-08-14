# Dockerfile (production)

# 1) Build stage
FROM node:20-alpine AS builder
WORKDIR /app
COPY package*.json ./
RUN npm ci || npm install
COPY . .
# Vite build output goes to /app/dist by default
RUN npm run build

# 2) Serve stage with Nginx
FROM nginx:1.27-alpine
# Clean default content
RUN rm -rf /usr/share/nginx/html/*
# Copy built assets
COPY --from=builder /app/dist /usr/share/nginx/html
# SPA routing config
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
