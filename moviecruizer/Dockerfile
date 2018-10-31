FROM openjdk:10-jre

ADD ./target/moviecruizer-0.0.1-SNAPSHOT.jar /usr/app/moviecruizer-0.0.1-SNAPSHOT.jar

WORKDIR usr/app

ENTRYPOINT ["java","-jar", "moviecruizer-0.0.1-SNAPSHOT.jar"]
