def call() {
    pipeline {
        agent any
        environment {
            AWS_CRED = 'cloud_user'
        }
        stages {
            stage('Upload template to S3') {                  
                steps {
                    uploadS3()
                }
            }
            stage('Deploy EC2') {                  
                steps {
                    cfnDeployEC2()
                }
            }
        }
    }
}
