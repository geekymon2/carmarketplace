# Installation Instructions for Kubernetes in Windows Machine

## Install the required k8s tools and dependencies.
### Install kubectl
```
winget install -e --id Kubernetes.kubectl
```
### Install minikube
```
refer to installation guide at: https://minikube.sigs.k8s.io/docs/start/
```
### Install Helm
```
winget install Helm.Helm
```


## Start minikube
```
minikube start --no-vtx-check --cpus=6 --memory=4096
```

## Install minikube dashboard
```
# Add kubernetes-dashboard repository
helm repo add kubernetes-dashboard https://kubernetes.github.io/dashboard/
# Deploy a Helm Release named "kubernetes-dashboard" using the kubernetes-dashboard chart
helm upgrade --install kubernetes-dashboard kubernetes-dashboard/kubernetes-dashboard --create-namespace --namespace kubernetes-dashboard
## Configure to run at startup if required
```

## Enable metric-server add-on
```
minikube addons enable metrics-server
```

## Launch dashboard
```
minikube dashboard
```