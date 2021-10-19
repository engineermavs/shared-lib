def call(Map stageParams = [Region: "us-east-1",  bucketName: "testbucket-mavs", s3Path: ""]) {
    withAWS(region: "${AWS_REGION}", credentials:'cloud_user') {
        awsIdentity()
        s3Upload( 
            workingDir: stageParams.workingDir,
            includePathPattern: stageParams.stackFileName,
            bucket: stageParams.bucketName,
            path: stageParams.s3Path
        )
    }
}
// awsRegion: "us-east-1", bucketName: "testbucket-mavs"
