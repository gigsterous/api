## Synopsis

This repository contains the REST API for the Gigsterous project.

## Installation

The API is a Spring boot application packaged as WAR. It needs to be deployed to an existing Tomcat (or other servlet container).
There are several profiles in the application which can be switched using SPRING_PROFILES_ACTIVE environmental variable.

main - live environment, database connection needs to be specified
development - contains development data in an in-memory database
