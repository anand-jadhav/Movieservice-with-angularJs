FROM openjdk:10
ADD ./target/spring-eureka-server-0.0.1-SNAPSHOT.jar  /usr/src/spring-eureka-server-0.0.1-SNAPSHOT.jar
EXPOSE 9090
WORKDIR /usr/src
ENTRYPOINT ["java","-jar", "spring-eureka-server-0.0.1-SNAPSHOT.jar"]
