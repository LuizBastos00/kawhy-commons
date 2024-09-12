pipeline {
    agent any

    tools {
        maven 'Maven-3.9.8' // Nome da instalação do Maven configurada no Jenkins
    }

    stages {
        stage('Checkout SCM') {
            steps {
                git branch: 'master', url: 'https://github.com/LuizBastos00/kawhy-commons.git'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') { // Nome da instalação SonarQube configurada no Jenkins
                    sh 'mvn sonar:sonar -Dsonar.projectKey=kawhy-commons -Dsonar.host.url=http://172.23.64.1:9000 -Dsonar.login=${SONAR_AUTH_TOKEN}'
                }
            }
        }
    }
}
