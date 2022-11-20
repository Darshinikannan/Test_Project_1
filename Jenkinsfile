node
{
    stages {
        stage('Fetch code from github') {
            
        }
        stage('Run API Tests') {
            steps {
                sh 'mvn clean verify -Dcucumber.filter.tags="@api"'
            }
        }
        stage('Report Generation') {
            steps {
                junit '**/target/surefire-reports/TEST-*.xml'
                archiveArtifacts 'target/*.jar'
                echo 'Report generated Successfully'
            }
        }
        
    }
}
