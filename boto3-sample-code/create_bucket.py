import boto3

s3 = boto3.resource('s3')
s3.create_bucket(Bucket='bucket-070102019',
                          CreateBucketConfiguration={
                              'LocationConstraint': 'eu-west-1'})