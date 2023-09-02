pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "java --version"
                withMaven {
                          sh "mvn clean verify"
                        }
                // sh "mvn -D clean verify"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site/serenity/', reportFiles: 'index.html', reportName: 'Serenity Report', reportTitles: '', useWrapperFileDirectly: true])
                }
            }
        }
    }
}