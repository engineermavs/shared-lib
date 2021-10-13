def call(Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            bucket: "${stageParams.s3Bucket}",
            includePathPattern: "${stageParams.uploadAll}"
        )
    }
}
// awsRegion: "us-east-1", s3Bucket: "testbucket-mrm"
