FROM jenkins/jenkins:lts-jdk17

# Switch to root to install packages
USER root

# Preinstall plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Install Python, pip, git, Docker CLI
RUN apt-get update && \
    apt-get install -y python3 python3-pip git curl jq && \
    curl -fsSL https://download.docker.com/linux/debian/gpg | gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg && \
    echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/debian $(. /etc/os-release && echo $VERSION_CODENAME) stable" > /etc/apt/sources.list.d/docker.list && \
    apt-get update && apt-get install -y docker-ce-cli && \
    rm -rf /var/lib/apt/lists/*

# Optional: Load JCasC on first boot
ENV CASC_JENKINS_CONFIG=/usr/share/jenkins/ref/casc.yaml
COPY casc.yaml /usr/share/jenkins/ref/casc.yaml

# Switch back to jenkins user
USER jenkins
