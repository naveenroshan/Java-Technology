# Java Microservice App with AWS and Devops Tools

- Introduction
- Spring Boot simple microservice app creation
- AWS Environment(Elastic BeanStalk) :
```
  - > Load Balanceing
  - > Autoscaling
  - > RDS
  - > S3
  - > SNS
  - > Security - IAM / Security Groups
  - > Health Check/ Monitoring - Cloud Watch
  - > EC2
```
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
- Create a AMI in the Image

- Created the classic load balancer in AWS with existing EC2 instances

- Auto Scaling the EC2 instance with the load balancing

- Simple Notification Service with Cloud watch 

- RDS for creating Mysql database (pwd: Rooster2193)

- Iam service:
```
$ user creation (Url - https://447446374989.signin.aws.amazon.com/console, pwd: Test@123)
$ policy assing for role
$ interacting with AWS CLI user.
$ created user - iamcliuser (id- AKIAWQLPB3JG33BHX5W7, key - wYzyubgmd8EshoiVpq01z604pktbWHGwoVRY23Er)
```
- lamda service overview.

-------------------------------------------Docker--------------------------------------------------
- Docker commands :
```
$ yum install docker
$ docker --version
$ docker info
$ service docker start
$ docker images
$ docker pull "docker image name":"version of the image"
$ docker run "docker image name"
$ docker run --help
$ docker run -i -d -t -p "host mechine port":"docker contianer port" ngnix
$ docker ps
$ docker stop "container id"
$ docker rm "container id"
$ docker start "container id"
$ docker restart "container id"
$ docker paused "container id"
$ docker unpaused "container id"
$ docker commit "container id" image
$ docker exec -it "container id" bash
```

