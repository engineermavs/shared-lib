def call () {
  echo "Build image with tag: ${env.BUILD_ID}"
  myapp = docker.build("mvllrmnmjc/ledger-service:${env.BUILD_ID}", "--build-arg VERSION=${env.BUILD_ID} .")
}
