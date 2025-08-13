FROM jenkins/inbound-agent:latest
USER root

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven git && \
    apt-get clean

USER jenkins
