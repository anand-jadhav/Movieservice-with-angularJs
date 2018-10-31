FROM openjdk:10
ADD ./target/springzullgatewayproxy-0.0.1-SNAPSHOT.jar  /usr/src/springzullgatewayproxy-0.0.1-SNAPSHOT.jar
EXPOSE 8081
WORKDIR /usr/src
ENTRYPOINT ["java","-jar", "springzullgatewayproxy-0.0.1-SNAPSHOT.jar"]
