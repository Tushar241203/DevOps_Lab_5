# Jenkins + Docker CI/CD Starter

This is a minimal Node.js "Hello" app with a Dockerized Jenkins Pipeline (`Jenkinsfile`).
Stages:
1) Checkout
2) Unit tests inside a Docker container
3) Build and tag a Docker image
4) Push to Docker Hub
5) Deploy via `docker compose` (optional)

## Quick setup

1. Replace `YOUR_DOCKERHUB_USERNAME` in `Jenkinsfile` and `docker-compose.yml`.
2. In Jenkins, add credentials: **Kind** = Username with password, **ID** = `dockerhub-creds`.
3. Ensure Jenkins can access Docker:
   - If Jenkins runs on the host: add the `jenkins` user to the `docker` group and restart Jenkins.
   - If Jenkins runs in Docker: mount `/var/run/docker.sock` and `/usr/bin/docker` into the Jenkins container.
4. Create a Pipeline job pointing to this repo (Pipeline from SCM).
5. Build → after success, `docker compose up -d` will deploy the container on the Jenkins node.

Access the app at http://<jenkins-node-ip>:8080
