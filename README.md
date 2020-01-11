# classloader-reproducer

Tried to write a minimal reproducer for [Quarkus classloader issue](https://github.com/quarkusio/quarkus/issues/5015)

__but this was ot successfull__ In this simple settings the runtime ClassCastException could not be reproduced even with "very old" Quarkus-Versions i.e.

### Description

The project consists of 2 artifacts:

* classloader-dependency is an external maven dependency

* classloader-quarkus is the one that offers a REST-API with two urls

	localhost:8080/quarkus/hello

This one makes use of an injected bean IOwnService that is localized in the same artifact as the REST endpoint.

	localhost:8080/quarkus/users

This one uses an injected bean IUserDao from the external dependency

### Quarkus version

This project uses quarkus-1.1.1-Final.

### Building an running

The project needs JDK-11.

First install the dependend artifact: Inside classloader-dependency run

	mvn clean install

Second start the quarkus artifact as usually:

	mvn clean compile quarkus:dev

