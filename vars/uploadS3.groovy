def call(Map stageParams = [awsRegion: "us-east-1", s3Bucket: "testbucket-mrm"]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            includePathPattern: "*.yml, .txt",
            bucket: stageParams.s3Bucket
        )
    }
}
