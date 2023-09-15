pipeline {
    agent any
    tools {
            maven 'MAVEN 3.9.4'
            jdk 'JDK 17.0.8.0.7'
        }
    stages {
        stage('Test') {
            steps {
                   sh "mvn clean compile test"
                  }
        }
        stage('Build') {
                        steps {
                                sh "mvn clean verify"
                              }
        }
    }
    post{
                always{
                    publishHTML([allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    includes: '**/*.html,  **/*.css, **/*.log',
                    keepAll: false,
                    reportDir: 'target/site/serenity/',
                    reportFiles: 'index.html',
                    reportName: 'Test Result Report',
                    reportTitles: 'Test Result Report',
                    useWrapperFileDirectly: true])
                }
        }
}