FROM openjdk:11-jre
WORKDIR usr/src
Add ./target/spring-cloud.config.server-0.0.1-SNAPSHOT.jar /usr/src/spring-cloud.config.server-0.0.1-SNAPSHOT.jar
Expose 8888
ENTRYPOINT ["java", "-jar", "/usr/src/spring-cloud.config.server-0.0.1-SNAPSHOT.jar"]
