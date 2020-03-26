FROM openjdk:11-jre
WORKDIR usr/src
ENV MYSQL_DATABSE=NewsDB
ENV MYSQL_USER=newuser
ENV MYSQL_PASSWORD=Password
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/newsArticlesdb
Add ./target/profile-0.0.1-SNAPSHOT.jar /usr/src/profile-0.0.1-SNAPSHOT.jar
Expose 8100
ENTRYPOINT ["java", "-jar", "/usr/src/profile-0.0.1-SNAPSHOT.jar"]
