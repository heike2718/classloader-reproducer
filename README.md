# classloader-reproducer

Reproducer for [Quarkus classloader issue](https://github.com/quarkusio/quarkus/issues/5015)

## Description

The project consists of 2 artifacts:

* classloader-dependency is an external maven dependency

* classloader-quarkus is the one that offers a REST-API with two urls

	localhost:8080/quarkus/hello

This one makes use of an injected bean IOwnService that is localized in the same artifact as the REST endpoint.

	localhost:8080/quarkus/users

This one uses an injected bean IUserDao from the external dependency


## Building an running

The project needs JDK-11.

First install the dependend artifact: Inside classloader-dependency run

	mvn clean install

Second start the quarkus artifact as usually:

	mvn clean compile quarkus:dev

## Issue

When calling

	localhost:8080/quarkus/users

the service anwers with "Could not find MessageBodyWriter for response object of type: java.util.ArrayList of media type: application/json"

and on the console you have a StackTrace:

	2020-01-11 07:49:01,624 ERROR [org.jbo.res.res.i18n] (executor-thread-1) RESTEASY002005: Failed executing GET /quarkus/users: org.jboss.resteasy.core.NoMessageBodyWriterFoundFailure: Could not find MessageBodyWriter for response object of type: java.util.ArrayList of media type: application/json
	at org.jboss.resteasy.core.ServerResponseWriter.lambda$writeNomapResponse$2(ServerResponseWriter.java:119)
	at org.jboss.resteasy.core.interception.jaxrs.ContainerResponseContextImpl.filter(ContainerResponseContextImpl.java:404)
	at org.jboss.resteasy.core.ServerResponseWriter.executeFilters(ServerResponseWriter.java:232)
	at org.jboss.resteasy.core.ServerResponseWriter.writeNomapResponse(ServerResponseWriter.java:97)
	at org.jboss.resteasy.core.ServerResponseWriter.writeNomapResponse(ServerResponseWriter.java:70)
	at org.jboss.resteasy.core.SynchronousDispatcher.writeResponse(SynchronousDispatcher.java:578)
	at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:508)
	at org.jboss.resteasy.core.SynchronousDispatcher.lambda$invoke$4(SynchronousDispatcher.java:252)
	at org.jboss.resteasy.core.SynchronousDispatcher.lambda$preprocess$0(SynchronousDispatcher.java:153)
	at org.jboss.resteasy.core.interception.jaxrs.PreMatchContainerRequestContext.filter(PreMatchContainerRequestContext.java:363)
	at org.jboss.resteasy.core.SynchronousDispatcher.preprocess(SynchronousDispatcher.java:156)
	at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:238)
	at io.quarkus.resteasy.runtime.standalone.RequestDispatcher.service(RequestDispatcher.java:73)
	at io.quarkus.resteasy.runtime.standalone.VertxRequestHandler.dispatch(VertxRequestHandler.java:120)
	at io.quarkus.resteasy.runtime.standalone.VertxRequestHandler.access$000(VertxRequestHandler.java:36)
	at io.quarkus.resteasy.runtime.standalone.VertxRequestHandler$1.run(VertxRequestHandler.java:85)
	at io.quarkus.runtime.CleanableExecutor$CleaningRunnable.run(CleanableExecutor.java:224)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
	at org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:2011)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1535)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1426)
	at org.jboss.threads.DelegatingRunnable.run(DelegatingRunnable.java:29)
	at org.jboss.threads.ThreadLocalResettingRunnable.run(ThreadLocalResettingRunnable.java:29)
	at java.base/java.lang.Thread.run(Thread.java:834)
	at org.jboss.threads.JBossThread.run(JBossThread.java:479)






