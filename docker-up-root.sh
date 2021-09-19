#! /bin/bash

echo "Running environment startup for base images on $HOSTNAME"
# Start all base containers
docker-compose up -d