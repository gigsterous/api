#!/bin/bash
# This script makes deployment of both API and Auth server easy
# Builds both images and then runs them via Docker Compose

cd ./gigsterous-auth;
mvn clean package docker:build;
cd ..;
cd ./gigsterous-api;
mvn clean package docker:build;
cd ..
docker-compose up;