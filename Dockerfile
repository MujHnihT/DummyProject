FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} dummyproject-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/dummyproject-0.0.1-SNAPSHOT.jar"]