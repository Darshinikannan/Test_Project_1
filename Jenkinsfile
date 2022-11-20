node {
    def Default
        stage('Fetch code from github') {
            checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'Git-Darshini', url: 'https://github.com/Darshinikannan/Test_Project_1.git']]])   
        }
        stage('Execute API Tests') {
                sh 'mvn clean verify -Dcucumber.filter.tags="@api"'
        }
        stage('Build jar file') {
                junit '**/target/surefire-reports/TEST-*.xml'
                archiveArtifacts 'target/*.jar'
                echo 'Report generated Successfully'
        }
}
