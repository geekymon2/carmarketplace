# Kubectl Cheatsheet

## Generic Info and Version
- kubectl cluster-info: Get Cluster Info
- kubectl version: Get Version

## Create, Apply and Delete Resources
- kubectl create -f FILENAME: Create a resource from a file
- kubectl apply -f FILENAME: Apply a modified resource from a file
- kubectl delete pods <podname>
- kubectl delete deployment <deployment_name> -n <namespace> 

## Get Status
- kubectl get pods

## Get Logs
- kubectl logs <podname>

## Create Secrets
- kubectl create secret generic <secretname> --namespace <namespace> --from-literal <key>=<value>

## Restart Deployments
- kubectl rollout restart deployment <deployment_name> -n <namespace>
