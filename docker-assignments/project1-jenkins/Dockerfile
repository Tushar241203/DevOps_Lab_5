# Multi-stage build
FROM openjdk:11-jdk AS build
COPY App.java /usr/src/myapp/
WORKDIR /usr/src/myapp
RUN javac App.java

# Runtime stage
FROM openjdk:11-jre-slim
WORKDIR /usr/src/myapp
COPY --from=build /usr/src/myapp/App.class .
EXPOSE 8080
CMD ["java", "App"]