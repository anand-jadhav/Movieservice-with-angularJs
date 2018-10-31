FROM openjdk:10
ADD ./target/springconfigserver-0.0.1-SNAPSHOT.jar  /usr/src/springconfigserver-0.0.1-SNAPSHOT.jar
EXPOSE 8888
WORKDIR /usr/src
ENTRYPOINT ["java","-jar", "springconfigserver-0.0.1-SNAPSHOT.jar"]
