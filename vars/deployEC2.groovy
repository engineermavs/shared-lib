def call() {
    pipeline {
        agent any
        environment {
            AWS_CRED = 'cloud_user'
            AWS_REGION = 'us-east-1'
            bucketName = 'testbucket-mavs'
        }
        stages {
            stage('Upload Template to S3') {                  
                steps {
                    uploadFiles(s3Bucket: "${bucketName}", path: "*.yml")
                }
            }
//             stage('Upload All Files to S3') {                  
//                 steps {
//                     uploadFiles(s3Bucket: "${bucketName}", path: "**/*")
//                 }
//             }
//             stage('Delete text to S3') {                  
//                 steps {
//                     deleteFile(s3Bucket: "testbucket-mavs", path: "deletesample.txt")
//                 }
//             }
            stage('Deploy EC2') {                  
                steps {
                    cfnDeployEC2(stack: "EC2Jenkins-mavs", url: "https://testbucket-mavs.s3.amazonaws.com/deployEC2.yml")
                }
            }
        }
    }
}
