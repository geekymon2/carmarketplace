# K8S LINUX SETUP
This document details the setup and deployment instructions for running the application in a local kubernetes cluster in a linux environment.
You can run these commands as is from the current folder where this readme doc is stored.

## Setup the application on Kubernetes
### First Create Namespace
kubectl create -f ./k8s-deployment/carmarketplace-k8s-namespace-dev.yaml

### Create secrets (Ensure your secrets are exposed as environment variables)
./k8s-deployment/create-secrets.sh

### Create all other resources
kubectl apply -f ./k8s-deployment --recursive

### Ensure your minikube and dashboard are running.
Refer to setup instructions within LOCAL-MINIKUBE-SETUP guides.

### Access Dashboard
* Local Machine: http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/#/workloads?namespace=default

### Access Logs
* http://minikube:32000/?namespace=carmarketplace-dev

### Check NGINX configuration
kubectl exec ingress-nginx-controller-xxxxxxxxxxx -n ingress-nginx -- cat /etc/nginx/nginx.conf