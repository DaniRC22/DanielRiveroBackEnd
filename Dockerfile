FROM amazoncorretto:11-alpine-jdk
MAINTAINER Esteban Daniel Rivero
COPY target/dni-0.0.1-SNAPSHOT.jar dni-app.jar
ENTRYPOINT ["java","-jar","/dni-app.jar"]
