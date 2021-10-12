def call() {
    pipeline {
        agent any
        environment {
            AWS_CRED = 'cloud_user'
        }
        stages {
            stage('Upload Template to S3') {                  
                steps {
                    uploadS3()
                }
            }
            stage('Upload Files to S3') {
                steps {
                    uploadFilesS3()
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
