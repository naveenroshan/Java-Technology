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