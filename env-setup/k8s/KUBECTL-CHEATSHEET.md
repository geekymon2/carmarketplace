# Kubectl Cheatsheet

## Generic Info and Version
- kubectl cluster-info: Get Cluster Info
- kubectl version: Get Version

## Create, Apply and Delete Resources
- kubectl create -f FILENAME: Create a resource from a file
- kubectl apply -f FILENAME: Apply a modified resource from a file
- kubectl delete pods <podname>
- kubectl delete deployment <deployment_name> -n <namespace> 
- kubectl apply -f <folder> --recursive: Apply multiple files recursively

## Get Status
- kubectl get pods

## Get Logs
- kubectl logs <podname>

## Create Secrets
- kubectl create secret generic <secretname> --namespace <namespace> --from-literal <key>=<value>

## Restart Deployments
- kubectl rollout restart deployment <deployment_name> -n <namespace>

## Tools to Install in Pods for Troubleshooting
- apt update && apt install -y net-tools && apt install -y curl && apt install -y dnsutils && apt install -y iputils-ping && apt install -y telnet