def call() {
    pipeline {
        agent any
        environment {
            AWS_CRED = 'cloud_user'
            AWS_REGION = 'us-east-1'
        }
        stages {
            stage('Upload Template to S3') {                  
                steps {
                    uploadFiles(s3Bucket: "testbucket-mavs", path: "*.yml")
                }
            }
            stage('Upload All Files to S3') {                  
                steps {
                    uploadFiles(s3Bucket: "testbucket-mavs", path: "**/*")
                }
            }
            stage('Delete text to S3') {                  
                steps {
                    deleteFile(s3Bucket: "testbucket-mavs", path: "deletesample.txt")
                }
            }
            stage('Deploy EC2') {                  
                steps {
                    cfnDeployEC2(stack: "EC2Jenkins-mavs", url: "https://testbucket-mavs.s3.amazonaws.com/deployEC2.yml")
                }
            }
        }
    }
}
