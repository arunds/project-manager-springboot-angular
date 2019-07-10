FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/project-manager-service-0.0.1-SNAPSHOT.jar project-manager-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","project-manager-service.jar"]