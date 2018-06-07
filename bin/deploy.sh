#!/usr/bin/env bash

set -eu

TARGET=build/libs
#TARGET=target

cp -r config "${TARGET}"

java -jar "${TARGET}/spring-boot-kotlin-template-0.1.0.jar" "$@"
