pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'sample-app'
        DOCKER_TAG = "${BUILD_NUMBER}"
        REGISTRY = 'localhost:5000' // Change to your registry
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
                    sh 'npm install'
                }
            }
        }
        
        stage('Run Tests') {
            steps {
                echo 'Running tests...'
                dir('app') {
                    sh 'npm test'
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
                    // Stop existing container if running
                    sh '''
                        docker stop sample-app-container || true
                        docker rm sample-app-container || true
                    '''
                    
                    // Run new container
                    sh """
                        docker run -d \
                        --name sample-app-container \
                        -p 3000:3000 \
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
            // Clean up workspace
            cleanWs()
        }
    }
}
