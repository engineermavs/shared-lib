def build () {
  myapp = docker.build("mvllrmnmjc/nodejs-test:${env.BUILD_ID}")
}

def push () {
  docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
    myapp.push("latest")
    myapp.push("${env.BUILD_ID}")
  }
}
