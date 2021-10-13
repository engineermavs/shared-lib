def call() {
    pipeline {
        agent any
        environment {
            AWS_CRED = 'cloud_user'
            AWS_REGION = 'us-east-1'
        }
        stages {
            stage('Upload Files to S3') {                  
                steps {
                    uploadS3(s3Bucket: "testbucket-mrm", path: "*.yml, random.txt")
                }
            }
//             stage('Delete text to S3') {                  
//                 steps {
//                     deletetxt(s3Bucket: "testbucket-geraldine", path: "delete.txt")
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
