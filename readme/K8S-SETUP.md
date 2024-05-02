# K8S LINUX SETUP
This document details the setup and deployment instructions for running the application in a local kubernetes cluster in a linux environment.

## Install the required k8s tools and dependencies.
* install kubectl
* install minikube
* TODO: there are a number of setup steps to get minikube working. We can add detailed instructions here.

## Setup the application on Kubernetes
### Create Namespace
kubectl create -f ./local/carmarketplace-k8s-namespace-dev.yaml

### Apply Deployments
kubectl apply -f ./local/carmarketplace-k8s-deployment-dev.yaml
