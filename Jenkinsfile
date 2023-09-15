pipeline {
    agent any
    tools {
            maven 'MAVEN 3.9.4'
            jdk 'JDK 17.0.8.0.7'
        }
        stages {
            stage('Test') {
                steps {
                    sh "mvn -D clean verify -Ddriver=firefox"
                }
        	post{
                    always{
                        publishHTML([allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/site/serenity/',
                        reportFiles: 'index.html',
                        reportName: 'Serenity Test Result Report',
                        reportTitles: 'Test Result Report',
                        useWrapperFileDirectly: true])
                    }
            }
            }
        }
}