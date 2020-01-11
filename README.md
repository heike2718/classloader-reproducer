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

### Building and running

The project needs JDK-1.8.

First install the dependend artifact: Inside classloader-dependency run

	mvn clean install

Second start the quarkus artifact as usually:

	mvn clean compile quarkus:dev

## Stack trace

see [here](./stacktrace)


## Remarks

The bug could only be reproduced when hibernate was included, i.e. JPA.

It was not possible to trigger the bug without JPA i.e. using a mock dao containing a Map.

Since the EntityManager now is contained in classloader-dependency it is not possible to inject it with @Inject as proposed by the Quarkus JPA example any more. Instead it must be annotated with @PersistenceContext.

Doing this, in order to avoid a NullPointerException, it is necessary to add a persistence.xml.


## Proof of fix with new class loading mechanism:

[https://github.com/stuartwdouglas/quarkus](https://github.com/stuartwdouglas/quarkus)

The class loader issue is fixed when switching to Stuarts 999-SNAPSHOT branch, so everything is fine.

