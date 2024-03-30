pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat "mvn clean"
            }
        }
        stage('Test') {
            steps {
                bat "docker build -t my_image ."
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
