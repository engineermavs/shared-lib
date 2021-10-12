def call(Map stageParams = [awsRegion: "us-east-1", s3Bucket: "testbucket-mavs"]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Delete( 
            includePathPattern: "*.txt",
            bucket: stageParams.s3Bucket
        )
    }
}
