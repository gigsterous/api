## Synopsis

This repository contains the REST API for the Gigsterous project.

[![Build Status](https://travis-ci.org/gigsterous/api.svg)](https://travis-ci.org/gigsterous/api)
[![codecov](https://codecov.io/gh/gigsterous/api/branch/master/graph/badge.svg)](https://codecov.io/gh/gigsterous/api)

## Installation

This project uses project lombok. In order to use this project inside some IDE, you need to install lombok in your IDE. Follow the instructions in the project page: https://projectlombok.org/

The API is a Spring boot application.

There are several profiles in the application which can be switched using SPRING_PROFILES_ACTIVE environmental variable.

* main - live environment, database connection needs to be specified
* development - contains development data in an in-memory database

## Security
The whole application is secured with OAuth2. Authorization server needs to be running and contacted for the access token:

```
curl -X POST --user 'gigsterous:secret' -d 'grant_type=password&username=peter@hotmail.com&password=password' http://localhost:9000/gigsterous-auth/oauth/token
```

Each request to the API must contain the following header:

```
Authorization: Bearer $TOKEN$
```

You can also login into the authorization server using a custom login page and specify the redirection url. It is possible to obtain a bearer token that way:

```
http://localhost:9000/gigsterous-auth/oauth/authorize?response_type=token&client_id=gigsterous&redirect_uri=http://localhost:9000/gigsterous-auth/user
```

## Deployment via Docker

Both servers have Dockerfiles and are ready to be deployed as Docker images. The build process is embedded in Maven and can be manually triggered like this:

```
mvn package docker:build
```

After building both projects, two images are created:
* gigsterous/gigsterous-auth
* gigsterous/gigsterous-api

These two images are ready to be deployed anywhere with Docker installed.

### Docker Compose

There is a configuration file for Docker Compose in the root folder, which deals with linking between the servers and injecting environment variables. Currently the configuration file is set to development mode.

### Shell Script

Last but not least - there is a run.sh script, which takes care of the whole workflow:

1. Builds gigsterous-auth image
2. Builds gigsterous-api image
3. Runs Docker Compose and deploys both images
