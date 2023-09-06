pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                   echo "java --version"
                   dir("TechnicalTest"){
                   sh 'mvn clean compile test'
                   }
                  }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site/serenity/', reportFiles: 'index.html', reportName: 'Serenity Report', reportTitles: '', useWrapperFileDirectly: true])
                }
            }
        }
        stage('Build') {
                        steps {
                                dir("/var/lib/jenkins/workspace/TestingPipeline") {
                                sh 'mvn -B -DskipTests clean package'
                                // sh "mvn -D clean verify"
                                }
                        }
        }
    }
}