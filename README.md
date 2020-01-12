# classloader-reproducer

Minimal reproducer for [Quarkus classloader issue](https://github.com/quarkusio/quarkus/issues/5015)

### Description

The project consists of 2 artifacts:

* classloader-dependency is an external maven dependency  __that uses JPA and thus an entity manager__

* classloader-quarkus is the one that offers a REST-API with two urls

	localhost:8080/quarkus/hello

This one makes use of an injected bean IOwnService that is localized in the same artifact as the REST endpoint.

	localhost:8080/quarkus/users

This one uses an injected bean IUserDao from the external dependency with JPA database access.

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

It was not possible to trigger the bug without JPA i.e. using a mock dao containing a Map.

## Possible Bug with JPA in an external dependency

The EntityManager is injected in a CDI bean inside the external dependency.

If we inject the EntityManager with @Inject as suggested by the Quarkus JPA exampe, the quarkus application dies milliseconds after start without any error message.

If we inject the EntityManager with @PersistenceContext, the quarkus application keeps running, but the entity manager remains null, i.e. does not get injected. This is independent of the existence of a persistence.xml.


## Proof of fix with new class loading mechanism:

[https://github.com/stuartwdouglas/quarkus](https://github.com/stuartwdouglas/quarkus)

__The class loader issue is fixed for "simple" beans without JPA when switching to Stuarts 999-SNAPSHOT branch__.

