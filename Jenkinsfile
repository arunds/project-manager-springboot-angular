#!groovy

properties([pipelineTriggers([pollSCM('H/1 * * * *')])])

node() {
    stage('Checkout'){
        checkout scm
    }
	
	stage ('Build-Service'){
     dir('project-manager-service') {
       sh 'mvn clean install -Dmaven.test.skip=true'
     }
    }
	
    stage ('Build-UI'){
     dir('project-manager-ui') {
        sh 'npm install'
        sh 'npm run build --prod'
     }
    }

    stage ('build & push containers'){
        withDockerRegistry(credentialsId: 'dockerHub', url: 'https://index.docker.io/v1/') {
			sh 'mvn -f project-manager-service/pom.xml dockerfile:build'
			sh 'mvn -f project-manager-service/pom.xml dockerfile:push'			
		    sh 'docker tag arunds/project-manager-service:0.0.1-SNAPSHOT  arunds/project-manager-service'
            sh 'docker push arunds/project-manager-service'	
			sh 'docker-compose up --force-recreate -d'
        }

    }

}