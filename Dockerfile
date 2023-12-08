FROM maven:3.8.3-amazoncorretto-17

WORKDIR /src/main/java/com/example/dummyproject
COPY . .
RUN mvn clean install
EXPOSE 8081

CMD mvn spring-boot:run
