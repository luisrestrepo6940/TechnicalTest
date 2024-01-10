pipeline {
    agent any
    tools {
            maven 'MAVEN 3.9.6'
            jdk 'JDK 17.0.9'
        }
        stages {
            stage('Test') {
                steps {
                    sh "mvn clean verify"
                }
        	post{
                    always{
                        publishHTML([allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName: 'Test Result Report',
                        useWrapperFileDirectly: true])
                    }
            }
            }
        }
}