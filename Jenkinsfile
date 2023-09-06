pipeline {
    agent any
    tools {
            maven 'Apache Maven 3.9.4'
            jdk 'jdk-11.0.20'
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