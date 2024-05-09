#!bin/bash
# This script enables ssh tunnel between workstation and k8s server
# IF K8S is setup to run on another server
# Allows access to minikube dashboard on the workstation to manage the cluster
# on the k8s server minikube is running and using proxy with port 8001
# on the local workstation port is 8181
# Access to dashboard locally via the url below.
####: http://localhost:8181/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/

ssh -L 8181:localhost:8001 mon2@geekymon2-desktop