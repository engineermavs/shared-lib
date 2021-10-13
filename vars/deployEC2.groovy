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
                    uploadFiles(s3Bucket: "testbucket-mrm", path: "*.yml")
                }
            }
            stage('Upload All Files to S3') {                  
                steps {
                    uploadFiles(s3Bucket: "testbucket-mrm", path: "**/*")
                }
            }
//             stage('Delete text to S3') {                  
//                 steps {
//                     deleteFile(s3Bucket: "testbucket-mrm", path: "deletesample.txt")
//                 }
//             }
            stage('Deploy EC2') {                  
                steps {
                    cfnDeployEC2(stack: "EC2Jenkins-mrm", url: "https://testbucket-mrm.s3.amazonaws.com/deployEC2.yml")
                }
            }
        }
    }
}
