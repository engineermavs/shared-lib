def buildDocker () {
  myapp = docker.build("mvllrmnmjc/ledger-service:${env.BUILD_ID}", "--build-arg VERSION=${env.BUILD_ID} .")
}

def pushDocker () {
  docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
    myapp.push("latest")
    myapp.push("${env.BUILD_ID}")
  }
}
