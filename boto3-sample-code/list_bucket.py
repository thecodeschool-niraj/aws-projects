import boto3

s3 = boto3.resource('s3')
s3client = boto3.client('s3')

response = s3client.list_buckets()
for bucket in response["Buckets"]:
    print(bucket['Name'])