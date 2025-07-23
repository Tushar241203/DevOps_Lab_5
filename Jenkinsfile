pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'sample-app'
        DOCKER_TAG = "${BUILD_NUMBER}"
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }
        
        stage('Build Application') {
            steps {
                echo 'Building the application...'
                dir('app') {
                    bat 'npm install'
                }
            }
        }
        
        stage('Run Tests') {
            steps {
                echo 'Running tests...'
                dir('app') {
                    bat 'npm test'
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                script {
                    dir('app') {
                        bat "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                        bat "docker tag ${DOCKER_IMAGE}:${DOCKER_TAG} ${DOCKER_IMAGE}:latest"
                    }
                }
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                
                powershell '''
                    # Stop and remove existing container (ignore errors)
                    try { docker stop sample-app-container } catch { Write-Host "Container not running" }
                    try { docker rm sample-app-container } catch { Write-Host "Container not found" }
                    
                    # Deploy new container
                    docker run -d --name sample-app-container -p 3000:3000 sample-app:$env:BUILD_NUMBER
                    
                    # Verify deployment
                    Start-Sleep -Seconds 2
                    docker ps | Where-Object { $_ -match "sample-app-container" }
                    Write-Host "Deployment completed successfully!"
                '''
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline completed!'
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
        cleanup {
            cleanWs()
        }
    }
}
