pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build Demo Application by Santiago Gòmez'
        sh 'sh ./run_build_script.sh'
      }
    }

    stage('Linux Tests') {
      parallel {
        stage('Linux Tests') {
          steps {

            sh 'sh ./run_linux_tests.sh'
          }
        }

        stage('Windows Tests') {
          steps {
            echo 'Run Windows Tests'
          }
        }

      }
    }

    stage('Deploy staging') {
      steps {
        echo 'Deploy to staging environment'
        input 'Ok to deploy to production?'
      }
    }

    stage('Deploy Production') {
      steps {
        echo 'Deploy to Production'
      }
    }

  }
  post {
    always {
      archiveArtifacts(artifacts: 'target/swordphishjenkins_beginners.jar', fingerprint: true)
    }

    failure {
      mail(to: 'santiagogb0795@gmail.com', subject: "Failed Pipeline ${currentBuild.fullDisplayName}", body: " For details about the failure, see ${env.BUILD_URL}")
    }

  }
}
