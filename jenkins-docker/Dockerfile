# Use the official Jenkins LTS image as the base
FROM jenkins/jenkins:lts

# Switch to root to install extra packages
USER root

# Install Docker CLI + Node.js + npm
RUN apt-get update && \
    apt-get install -y curl docker.io docker-compose && \
    curl -fsSL https://deb.nodesource.com/setup_18.x | bash - && \
    apt-get install -y nodejs && \
    rm -rf /var/lib/apt/lists/*

# Verify Node.js & npm
RUN node -v && npm -v

# Add Jenkins user to the docker group
RUN groupadd -f docker && usermod -aG docker jenkins

# Switch back to the Jenkins user
USER jenkins
