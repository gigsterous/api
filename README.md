## Synopsis

This repository contains the REST API for the Gigsterous project.

## Installation

This project uses project lombok. In order to use this project inside some IDE, you need to install lombok in your IDE. Follow the instructions in the project page: https://projectlombok.org/

The API is a Spring boot application. 

There are several profiles in the application which can be switched using SPRING_PROFILES_ACTIVE environmental variable.

* main - live environment, database connection needs to be specified
* development - contains development data in an in-memory database

## Security
The whole application is secured with OAuth2. Authorization server needs to be running and contacted for the access token:

```
curl -X POST --user 'gigsterous:secret' -d 'grant_type=password&username=peter&password=password' http://localhost:9000/gigsterous-auth/oauth/token
```

Each request to the API must contain the following header:

```
Authorization: Bearer $TOKEN$
```
