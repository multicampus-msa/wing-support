node {
     stage('Clone repository') {
         checkout scm
     }
     stage('chmod') {
         sh 'chmod +x gradlew'
     }
     stage('Gradle Build') {
         sh './gradlew bootjar'
         sh 'cp /var/lib/jenkins/workspace/wing-support/build/libs/*.jar ./'
     }
     stage('Build & Push image') {
          docker.withRegistry('https://registry.hub.docker.com', 'profornnan-docker') {
             def image = docker.build("profornnan/wing-support:latest")
             image.push()
             sh 'sudo docker service update --image profornnan/wing-support wing-support'
         }
     }
 }