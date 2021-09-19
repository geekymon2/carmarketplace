#! /bin/bash

echo "Running environment cleanup for root images on $HOSTNAME"
# Stop and remove all root containers
docker-compose -f -s rm