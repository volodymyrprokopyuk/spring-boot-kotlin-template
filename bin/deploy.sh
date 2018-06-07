#!/usr/bin/env bash

set -eu

cp -r config build/libs

java -jar build/libs/spring-boot-kotlin-template-0.1.0.jar "$@"
