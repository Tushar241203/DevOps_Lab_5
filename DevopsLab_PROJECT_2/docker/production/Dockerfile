FROM nginx:alpine

# Remove default nginx files first
RUN rm -rf /usr/share/nginx/html/*

# Copy Angular browser files (where the actual app is)
COPY angular-app/dist/angular-app/browser/ /usr/share/nginx/html/

COPY docker/nginx/nginx.conf /etc/nginx/nginx.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]