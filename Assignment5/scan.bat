@echo off
echo Building Docker image...
docker build -t retail-app .

echo Scanning image with Trivy...
trivy image retail-app

echo Scan complete.
