pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'Mahesh_Kharote_517', url: 'https://github.com/TanV-04/DevOps_Lab_5.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                dir('Practical_1') {
                    sh 'npm install'
                }
            }
        }

        stage('Run Tests') {
            steps {
                dir('Practical_1') {
                    sh 'npm test'
                }
            }
        }

        stage('Build') {
            steps {
                dir('Practical_1') {
                    echo 'Building the Node.js app...'
                }
            }
        }

        stage('Deploy') {
            steps {
                dir('Practical_1') {
                    echo 'Deploying the app (dummy step)...'
                }
            }
        }
    }
}
