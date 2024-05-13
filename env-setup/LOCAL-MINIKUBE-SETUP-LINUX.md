# Installation Instructions for Kubernetes in Windows Machine

## Install the required k8s tools and dependencies.
### Install kubectl
### Install minikube
### Install Helm
```
curl https://baltocdn.com/helm/signing.asc | gpg --dearmor | sudo tee /usr/share/keyrings/helm.gpg > /dev/null
sudo apt-get install apt-transport-https --yes
echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/helm.gpg] https://baltocdn.com/helm/stable/debian/ all main" | sudo tee /etc/apt/sources.list.d/helm-stable-debian.list
sudo apt-get update
sudo apt-get install helm
```
## Start minikube
```
minikube start --cpus=8 --memory=8192 --static-ip 192.168.200.200
```

## Install minikube dashboard
```
# Add kubernetes-dashboard repository
helm repo add kubernetes-dashboard https://kubernetes.github.io/dashboard/
# Deploy a Helm Release named "kubernetes-dashboard" using the kubernetes-dashboard chart
helm upgrade --install kubernetes-dashboard kubernetes-dashboard/kubernetes-dashboard --create-namespace --namespace kubernetes-dashboard
## Configure to run at startup if required
```

## Enable add-ons
```
minikube addons enable metrics-server
minikube addons enable dashboard
minikube addons enable ingress
minikube addons enable ingress-dns
minikube addons enable logviewer
```
## Start proxy
```
kubectl proxy --address 0.0.0.0 --disable-filter=true
```
## Launch dashboard
```
minikube dashboard --url
```
## Setup auto startup
Minikube has been setup to auto start on boot via the linux systemd service.
### Service names
#### minikube: Starts the minikube service
#### miniportf: Start the port forwarding

Some helpful commands for checking services
* systemctl start minikube
* systemctl status minikube
* systemctl start miniportf
* systemctl status miniportf