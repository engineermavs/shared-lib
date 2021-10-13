def call(Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            includePathPattern: "${stageParams.path}",
            bucket: "${bucketName}"
        )
    }
}
// awsRegion: "us-east-1", bucketName: "testbucket-mavs"
