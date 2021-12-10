----------------------------------------AWS----------------------------------------------------
- MYSQL installation in EC2:

```
$ yum install -y mariadb-server
$ systemctl enable mariadb (automatic start the db service when the EC2 instance starts)
$ systemctl start mariadb (automatic start the db service when the EC2 instance starts)
$ mysql_secure_installation
$ mysql -uroot -p
```

- JAVA Installation in EC2:
        
```
$ yum install java-1.8.0-openjdk
$ alternatives --config java 
```

- Getting microserver app from S3 and run it:
        
```
$ wget https://firsts3bucketone.s3.us-east-2.amazonaws.com/couponservice-0.0.1-SNAPSHOT.jar
$ java -jar "microserver name"
```

- Uploading the jar to S3:

```
$ Coupon App S3 URL - https://firsts3bucketone.s3.us-east-2.amazonaws.com/couponservice-0.0.1-SNAPSHOT.jar`
```
- create a AMI in the Image 
- ELB: Created the classic load balancer in AWS with existing EC2 instances
