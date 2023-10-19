FROM openjdk:17
COPY build/libs/project-feature-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]