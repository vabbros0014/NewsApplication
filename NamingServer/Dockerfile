FROM openjdk:11-jre
WORKDIR usr/src
Add ./target/netflix-naming-server-0.0.1-SNAPSHOT.jar /usr/src/netflix-naming-server-0.0.1-SNAPSHOT.jar
Expose 8761
ENTRYPOINT ["java", "-jar", "/usr/src/netflix-naming-server-0.0.1-SNAPSHOT.jar"]
