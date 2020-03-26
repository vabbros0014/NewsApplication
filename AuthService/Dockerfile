FROM openjdk:11-jre
WORKDIR usr/src
ENV MongoDB=NewsDB
ENV port=27017
Add ./target/auth-0.0.1-SNAPSHOT.jar /usr/src/auth-0.0.1-SNAPSHOT.jar
Expose 8000
ENTRYPOINT ["java", "-jar", "/usr/src/auth-0.0.1-SNAPSHOT.jar"]
