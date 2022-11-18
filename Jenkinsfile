pipeline {
    agent any
    
    tools {
        maven "Default"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'Git-Darshini', url: 'https://github.com/Darshinikannan/Test_Project_1.git']]])
            }
        }
        stage('Pre-Build') {
            steps {
                echo 'Pre Build'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true clean package'
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
