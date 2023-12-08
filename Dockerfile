FROM maven:3.8.3-amazoncorretto-17

WORKDIR /src/main/java/com/example/dummyproject
COPY . .
RUN mvn clean install
RUN curl -fsSLO https://get.docker.com/builds/Linux/x86_64/docker-17.04.0-ce.tgz \
  && tar xzvf docker-17.04.0-ce.tgz \
  && mv docker/docker /usr/local/bin \
  && rm -r docker docker-17.04.0-ce.tgz
EXPOSE 8081

CMD mvn spring-boot:run
