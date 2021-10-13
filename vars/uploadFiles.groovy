def call(Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            includePathPattern: "${stageParams.path}",
            bucket: "${stageParams.s3Bucket}"
        )
    }
}
// awsRegion: "us-east-1", s3Bucket: "testbucket-mrm"
