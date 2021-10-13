def call(Map stageParams = [:]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            includePathPattern: "*.yml, .txt",
            bucket: stageParams.s3Bucket
        )
    }
}
