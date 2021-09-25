#! /bin/bash

echo "Running environment cleanup for base images on $HOSTNAME"
# Stop and remove all base containers
docker-compose rm -f -s