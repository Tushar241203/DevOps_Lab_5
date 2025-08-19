pipeline {
    agent any

    tools {
        nodejs "NodeJS_24"   // use the name you configured
    }

    stages {
        stage('Install Dependencies') {
            steps {
                sh 'npm install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'npm test'
            }
        }

        stage('Build') {
            steps {
                sh 'npm run build'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying app (dummy step)...'
            }
        }
    }
}
