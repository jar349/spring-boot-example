Spring Boot Example
==================
This is an example project that uses Spring Boot 1.2.1 to create a RESTful service (using Spring HATEOAS) that is secured (using Spring Security).

- It uses its own parent pom, and has more than one module
- It uses logback for logging.
- It uses maven for dependency management and packaging.

Assuming that you have [maven installed](http://maven.apache.org/download.cgi#Installation), you can package the application from the root of the project:

		mvn package

And then you can start the service by executing the jar like any plain-old java application:

		java -jar example-service/target/spring-boot-example-service-1.0.0-SNAPSHOT.jar

Once it starts, it's listening on port 8080.  You can hit the restful endpoint by using curl:

		curl -X GET --user john:password localhost:8080/friends; echo

And you should see the output:

		[{"friendId":"123","firstName":"Richard","lastName":"Clayton","_links":{"self":{"href":"http://localhost:8080/friends/123"}}}]


