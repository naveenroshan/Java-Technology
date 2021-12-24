-------------------------------------------kubernetes--------------------------------------------------

- minikube is nothing but local small kubernetes with one master and one worker
- kubernetes is a cluster of node
- node are two type master and worker
- master node contain Api server, Scheduler, ControlManager, etcd
- worker node contin kubelet, proxy, pods

-Kubernetes Object Model:
```
$ pod
$ ReplicaSet
$ Deployment
$ Namespace
$ Service - this give access to our app running in container to external world
```

- kubernetes commands :
```
$ minikube start
$ minikube status
$ minikube stop
$ minikube delete
$ minikube start --vm-driver=hyerkit
$ minikube dashboard
$ minikube services "service name"
$ kubectl run firstpod --image=nginx
$ kubectl version --client
$ kubectl config view
$ kubectl get pods
$ kubectl describe pod firstpod
$ kubectl exec -it firstpod -- /bin/bash
$ kubectl create -f firstpod.yml
$ kubectl describe pods
$ kubectl exec -it firstpod --container db -- /bin/bash
$ kubectl delete -f firstpod.yml
$ kubectl get pods -o yaml
$ kubectl get all --show-labels
$ kubectl get all --selector='app=fp ,team=red'
$ kubectl get ns
$ kubectl get pods --namespace firstns
$ kubectl replace -f webserver.yml
$ kubectl rollout history deployment "deployment name" --revision=1
$ kubectl rollout undo deployment "deployment name" --to-revision=1
$ kubectl scale deployment "deployment name" --replicas=20
```

- Pod Life Cycle :
```
$ Pending
$ Running
$ Succeeded
$ failed
$ Unknown
```
- Lables and Selectors
- Annotations
- NameSpace
- Interact with kuberenetes cluster with web, CLI, Rest APIs
- Service & Type:
```
$ ClusterIP
$ NodePort
$ LoadBalancer
```
- Rolling Updates
```
$ maxUnavailable
$ maxSurge
```
- Rollback

- Volumes
```
$ Mount volume
$ Config volume
$ Secret Volume
$ Persistent volume
```

- JKube Eclipce life cycle
```
$ Use Plugin:

<plugin>
	<groupId>org.eclipse.jkube</groupId>
	<artifactId>kubernetes-maven-plugin</artifactId>
	<version>1.0.0-rc-1</version>
</plugin>


Build Docker images:

mvn k8s:build

docker login

mvn k8s:push



Setup Minikube and Docker:

minikube status

minikube start

kubectl get pods -w

kubectl cluster-info

minikube docker-env

eval $(minikube -p minikube docker-env)


Generate Kubernetes Resource manifests:

mvn k8s:resource


Apply resources to cluster:

mvn k8s:apply


Test:

kubectl get pods -w

kubectl get svc

minikube ssh

curl <ip>:<port>

update properties in pom.xml

<properties>
	<java.version>1.8</java.version>
	<jkube.enricher.jkube-service.type>NodePort</jkube.enricher.jkube-service.type>
</properties>


Change Service type to NodePort:

<jkube.enricher.jkube-service.type>NodePort</jkube.enricher.jkube-service.type>

minikube ip

curl <ip>:<port>


Access Logs:

k8s:logs


Debug:

mvn k8s:debug


Undeploy:

mvn k8s:undeploy
```