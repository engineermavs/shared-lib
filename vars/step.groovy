def buildNum () {
  echo "Build image with tag: ${env.BUILD_ID}"
}

def buildDocker () {
  myapp = docker.build("mvllrmnmjc/ledger-service:${env.BUILD_ID}", "--build-arg VERSION=${env.BUILD_ID} .")
}

def npmBuild () {
  myapp = docker.build("mvllrmnmjc/nodejs-test:${env.BUILD_ID}")
}

def pushDocker () {
  docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
    myapp.push("latest")
    myapp.push("${env.BUILD_ID}")
  }
}
