#!/usr/bin/env bash

set -eu

#gradle build "$@"

mvn clean install "$@"