import boto3

ec2 = boto3.resource('ec2')

for i in ec2.instances.all():
    if i.state['Name'] == 'stopped':
        i.start()




