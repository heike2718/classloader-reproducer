# classloader-reproducer

Minimal reproducer for [Quarkus classloader issue](https://github.com/quarkusio/quarkus/issues/5015)

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

## Stack trace

see [here](./stacktrace)


## Remarks

The bug could only be reproduced when hibernate was included, i.e. JPA.

It was not possible to trigger the bug without JPA ang just an mock dao containing a Map.


