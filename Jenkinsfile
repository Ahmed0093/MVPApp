pipeline {
agent {
  	label 'android'
  }
   stages {
      stage('Hello') {
         steps {
            echo 'Hello World'
         }
      }
       stage("Checkout"){
          checkout scm
        }

        stage ("Prepare"){
          sh 'chmod +x ./gradlew'
        }
   }
}