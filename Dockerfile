FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
COPY target/backend-challenge-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]