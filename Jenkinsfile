pipeline {
    agent any
    tools {
            maven 'MAVEN 3.9.4'
            jdk 'JDK 17.0.8.0.7'
        }
    stages {
        stage('Test') {
            steps {
                   sh "java --version"
                   sh "mvn clean compile test"
                  }
        }
        stage('Build') {
                        steps {
                                sh "mvn clean install -Dmaven.test.skip=true"
                              }

        }
    }
}