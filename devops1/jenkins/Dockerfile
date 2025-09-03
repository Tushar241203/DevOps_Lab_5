FROM jenkins/jenkins:lts-jdk17

# Switch to root to install packages
USER root

# Install required packages: python3, pip, docker CLI, git, curl, jq
RUN apt-get update && apt-get install -y \
    python3 python3-pip docker-ce-cli git curl jq \
    && rm -rf /var/lib/apt/lists/*

# Preinstall Jenkins plugins
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Optional: Load JCasC on first boot
ENV CASC_JENKINS_CONFIG=/usr/share/jenkins/ref/casc.yaml
COPY casc.yaml /usr/share/jenkins/ref/casc.yaml

# Switch back to Jenkins user
USER jenkins
