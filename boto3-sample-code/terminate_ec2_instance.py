import boto3

ec2 = boto3.resource('ec2')

ids = tuple(input("Instance ID:"))
ec2.instances.filter(InstanceIds = ids).terminate()