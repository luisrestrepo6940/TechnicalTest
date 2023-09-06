pipeline {
    agent any
    tools {
            maven 'Apache Maven 3.9.4'
            jdk 'Java 11.0.20'
        }
    stages {
        stage('Test') {
            steps {
                   sh "java --version"
                   sh "mvn clean compile test"
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
                                sh "mvn clean install -Dmaven.test.skip=true"
                              }

        }
    }
}