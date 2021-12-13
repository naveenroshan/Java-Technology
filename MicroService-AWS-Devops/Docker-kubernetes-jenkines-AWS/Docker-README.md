-------------------------------------------Docker--------------------------------------------------

Docker commands :
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
Docker MySQL :
```
$ docker run -dit -p 6666:3306 --name=naveen --env="MYSQL_ROOT_PASSWORD=Root@123" --env="MYSQL_DATABASE=emp" mysql
$ docker exec -it "container name" bash
```
Docker volumes & Bind Mounts :
```
$ docker volume ls
$ docker volume create "volume name"
$ docker run -dit --mount source=myVol,destination=/tmp nginx
```
Docker nerwork :
```
$ docker network ls
$ docker network connect "newworkname" "servername"
$ docker run --name "servername" --net "networkname" --ip 172.19.0.2 -h web.naveen.com -p 82:80 -ti ubuntu /bin/bash
$ docker attach "servername"
$ docker network disconnect "networkname" "servername"
```
