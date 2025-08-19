# Use the official Jenkins LTS image as the base
FROM jenkins/jenkins:lts

# Switch to root to install extra packages
USER root

# Install Docker CLI (so Jenkins can run docker commands)
RUN apt-get update && \
    apt-get install -y docker.io docker-compose && \
    rm -rf /var/lib/apt/lists/*

# Add Jenkins user to the docker group
RUN groupadd -f docker && usermod -aG docker jenkins

# Switch back to the Jenkins user
USER jenkins
