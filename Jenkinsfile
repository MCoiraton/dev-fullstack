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
                    dockerImage = docker.build 'MCoiraton/covidProject'
                }
            }
        }

        stage('push'){
            steps {
                script{
                    docker.withRegistry('','dockerHub') {
                        dockerImage.push('latest')
                    }   
                }
            }
        }

        stage('run'){
            steps {
                sh 'docker run helloworld'
            }
        }
    }
}