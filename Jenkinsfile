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
                bat 'docker stop sample-app-container 2>nul || echo Container stopped'
                bat 'docker rm sample-app-container 2>nul || echo Container removed'  
                bat "docker run -d --name sample-app-container -p 3000:3000 ${DOCKER_IMAGE}:${DOCKER_TAG}"
                bat 'docker ps | findstr sample-app-container'
                echo 'Deployment completed successfully!'
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
