def call(Map stageParams = []) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Delete( 
            includePathPattern: "*.txt",
            bucket: stageParams.s3Bucket
        )
    }
}
// awsRegion: "us-east-1", s3Bucket: "testbucket-mrm"
