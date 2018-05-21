#!/usr/bin/env bash

set -eo pipefail
modules=( eureka config user shop zuul)

for module in "${modules[@]}"; do
    docker rmi fuhaidev/${module}:1.0-SNAPSHOT
    mvn clean package docker:build  -f ./${module}/pom.xml
done