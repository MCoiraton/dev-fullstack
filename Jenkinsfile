pipeline {
  agent any
  stages {
    stage('pull') {
      steps {
        git(url: 'https://github.com/MCoiraton/dev-fullstack', branch: 'master')
      }
    }
    stage('build'){
            steps {
                script {
                    dockerImage = docker.build 'mcoiraton/devfullstack'
                }
            }
        }

        stage('push'){
            steps {
                script{
                    docker.withRegistry('','dockerhub') {
                        dockerImage.push('latest')
                    }   
                }
            }
        }
    }
}