FROM openjdk:11
MAINTAINER Willians Lorente
EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY target/*.jar omni-departments-app.jar
ENTRYPOINT ["java", "-jar" , "omni-departments-app.jar"]