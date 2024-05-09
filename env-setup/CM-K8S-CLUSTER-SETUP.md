# K8S LINUX SETUP
This document details the setup and deployment instructions for running the application in a local kubernetes cluster in a linux environment.
You can run these commands as is from the current folder where this readme doc is stored.

## Setup the application on Kubernetes
### First Create Namespace
kubectl create -f ./k8s-deployment/carmarketplace-k8s-namespace-dev.yaml

### Create secrets (Ensure you replace the <value> with the actual secret)
kubectl create secret generic encryptkeysecret --namespace carmarketplace-dev --from-literal encryptkeysecret=<value>
kubectl create secret generic carinfodbpassword --namespace carmarketplace-dev --from-literal carinfodbpassword=<value>
kubectl create secret generic carlistingdbpassword --namespace carmarketplace-dev --from-literal carlistingdbpassword=<value>

### Create all other resources
kubectl apply -f ./k8s-deployment --recursive

### Access Dashboard
* Local Machine: http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/#/workloads?namespace=default