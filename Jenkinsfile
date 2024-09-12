pipeline {
    agent any

    tools {
        maven 'Maven-3.9.8' // Nome da instalação do Maven configurada no Jenkins
    }

    environment {
        DB_URL = 'jdbc:oracle:thin:@//172.23.64.1:1521/XEPDB1'
        DB_USER = 'GRA_USER'
        DB_PASSWORD = 'password'
    }

    stages {
        stage('Checkout SCM') {
            steps {
                git branch: 'master', url: 'https://github.com/LuizBastos00/kawhy-commons.git'
            }
        }
        stage('Build') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'oracle-db-credentials', usernameVariable: 'DB_USER', passwordVariable: 'DB_PASSWORD')]) {
                    sh 'mvn clean package -Ddb.url=${DB_URL} -Ddb.user=${DB_USER} -Dspring.datasource.password=${DB_PASSWORD}'
                }
            }
        }
        stage('Test') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'oracle-db-credentials', usernameVariable: 'DB_USER', passwordVariable: 'DB_PASSWORD')]) {
                    sh 'mvn test -Ddb.url=${DB_URL} -Ddb.user=${DB_USER} -Dspring.datasource.password=${DB_PASSWORD}'
                }
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
