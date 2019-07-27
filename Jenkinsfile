#!groovy

properties([pipelineTriggers([pollSCM('H/1 * * * *')])])

node() {
    stage('Checkout'){
        checkout scm
    }
    stage ('build'){
     dir('project-manager-service') {
       sh 'mvn clean install'
     }
     dir('project-manager-ui') {
        sh 'npm install'
        sh 'npm run build --prod'
     }
    }

    stage ('build & push containers'){
        withDockerRegistry(credentialsId: 'dockerHub', url: 'https://index.docker.io/v1/') {
			sh 'docker-compose up --force-recreate -d'
        }

    }

}