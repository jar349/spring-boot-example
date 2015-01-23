#!/bin/bash
start-stop-daemon --start --quiet --make-pidfile --pidfile /var/run/$NAME.pid \
    --background \
    --exec /usr/bin/java -- -jar /usr/lib/spring-boot-example/spring-boot-example-service-1.0.0-SNAPSHOT.jar