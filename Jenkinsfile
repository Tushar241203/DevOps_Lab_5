pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'tanvi', url: 'https://github.com/TanV-04/DevOps_Lab_5.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.image('node-jenkins-app').pull()
                }
                sh 'docker build -t node-jenkins-app .'
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                    docker stop node-jenkins-app || true
                    docker rm node-jenkins-app || true
                    docker run -d -p 3000:3000 --name node-jenkins-app node-jenkins-app
                '''
            }
        }
    }
}