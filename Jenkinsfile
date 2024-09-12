node("master") {
    stage('SCM') {

        git branch: 'master', 
        credentialsId: 'LB', 
        url: 'https://github.com/LuizBastos00/kawhy-commons.git'
    }

    stage('Mvn Package'){

        sh 'mvn clean package'
    }

    stage('SonarQube analysis') {

        withSonarQubeEnv('sonarqube') {

            sh 'mvn sonar:sonar -Dsonar.projectKey=test-jenkins -Dsonar.host.url=http://loclahost:9000 -Dsonar.login=sqp_009f61a1e2d89c46f7e23ee66e2fdb6e693048de'

        }

    }
	
}
