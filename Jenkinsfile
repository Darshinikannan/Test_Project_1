pipeline {
    agent any
    
    tools {
        maven "Default"
    }

    stages {
        stage('Pre-Build') {
            steps {
                echo 'Pre Build'
            }
        }
        stage('Build') {
            steps {
                echo 'Starting to Build'
            }
        }
        stage('API_Tests') {
            steps {
                sh 'mvn clean verify -Dcucumber.filter.tags="@api"'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deployed Successfully'
            }
        }
        
    }
}
