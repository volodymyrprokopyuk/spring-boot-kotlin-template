#!/usr/bin/env bash

set -eu

#export DOCKER_HOST=tcp://gamma-dev.dcs.dinersclub.es:2376
#export DOCKER_TLS_VERIFY=1
#export DOCKER_CERT_PATH=/home/vlad/.docker

#gradle build "$@"

mvn clean install "$@"