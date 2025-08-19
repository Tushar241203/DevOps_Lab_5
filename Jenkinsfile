pipeline {
    agent any

    tools {
        nodejs "NodeJS_24"
    }

    stages {
        stage('Install Dependencies') {
            steps {
                dir('Practical 1') {   // Change to your project directory
                    sh 'npm install'
                }
            }
        }

        stage('Run Tests') {
            steps {
                dir('Practical 1') {
                    sh 'npm test'
                }
            }
        }

        stage('Build') {
            steps {
                dir('Practical 1') {
                    sh 'npm run build'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying app (dummy step)...'
            }
        }
    }
}
