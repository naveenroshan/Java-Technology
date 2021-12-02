# Java Microservice App with AWS and Devops Tools

- Introduction
- Spring Boot simple microservice app creation
- AWS Environment(Elastic BeanStalk) :
- Load Balanceing
- Autoscaling
- RDS
- S3
- SNS
- Security - IAM / Security Groups
- Health Check/ Monitoring - Cloud Watch
- EC2
- Jenkins
- Maven  
- Git
- Docker
- Kubernetes
- SSH (secure shell) connection used to connect with Mobaxterm client for AWS server
- Linux directories and files command 
- Linux yum command to install packages

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

- Auto Scaling the EC2 instance with the load balancing

- Simple Notification Service with Cloud watch 

- RDS for creating Mysql database (pwd: Rooster2193)

- Iam service (Url - https://447446374989.signin.aws.amazon.com/console, pwd: Test@123):
- user creation , policy assing for servers, role

