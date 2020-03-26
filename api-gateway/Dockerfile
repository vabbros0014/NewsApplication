FROM openjdk:11-jre
WORKDIR usr/src
Add ./target/api-gateway-0.0.1-SNAPSHOT.jar /usr/src/api-gateway-0.0.1-SNAPSHOT.jar
Expose 8765
ENTRYPOINT ["java", "-jar", "/usr/src/api-gateway-0.0.1-SNAPSHOT.jar"]
