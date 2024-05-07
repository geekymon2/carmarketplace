# K8S LINUX SETUP
This document details the setup and deployment instructions for running the application in a local kubernetes cluster in a linux environment.

## Setup the application on Kubernetes
### Create Namespace
kubectl create -f ./local/carmarketplace-k8s-namespace-dev.yaml

### Apply Deployments
kubectl apply -f ./local/carmarketplace-k8s-deployment-dev.yaml

### Access Dashboard
* Local Machine: http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/#/workloads?namespace=default