minikube start --cpus=8 --memory=8192 --vm-driver=virtualbox
helm upgrade --install kubernetes-dashboard kubernetes-dashboard/kubernetes-dashboard --create-namespace --namespace kubernetes-dashboard
minikube addons enable metrics-server
minikube addons enable dashboard
minikube addons enable ingress
minikube addons enable ingress-dns
kubectl proxy --address 0.0.0.0 --disable-filter=true &&
minikube dashboard --url