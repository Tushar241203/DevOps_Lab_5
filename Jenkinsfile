pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'sample-app'
        DOCKER_TAG = "${BUILD_NUMBER}"
        REGISTRY = 'localhost:5000'
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
                    bat 'npm install'  // Changed from sh to bat
                }
            }
        }
        
        stage('Run Tests') {
            steps {
                echo 'Running tests...'
                dir('app') {
                    bat 'npm test'     // Changed from sh to bat
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                script {
                    dir('app') {
                        def image = docker.build("${DOCKER_IMAGE}:${DOCKER_TAG}")
                        docker.image("${DOCKER_IMAGE}:${DOCKER_TAG}").tag("${DOCKER_IMAGE}:latest")
                    }
                }
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                script {
                    // Use bat commands for Windows
                    bat '''
                        docker stop sample-app-container || echo "Container not running"
                        docker rm sample-app-container || echo "Container not found"
                    '''
                    
                    bat """
                        docker run -d ^
                        --name sample-app-container ^
                        -p 3000:3000 ^
                        ${DOCKER_IMAGE}:${DOCKER_TAG}
                    """
                }
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
