FROM openjdk:11-jre
WORKDIR usr/src
ENV MongoDB=NewsDB
ENV port=27017
Add ./target/NewsCrud-0.0.1-SNAPSHOT.jar /usr/src/NewsCrud-0.0.1-SNAPSHOT.jar
Expose 8900
ENTRYPOINT ["java", "-jar", "/usr/src/NewsCrud-0.0.1-SNAPSHOT.jar"]
