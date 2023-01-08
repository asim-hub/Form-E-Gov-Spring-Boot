FROM maven:3.8.4-openjdk-17
WORKDIR /
EXPOSE 8080
ADD target/form-0.0.1-SNAPSHOT.jar form-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/form-0.0.1-SNAPSHOT.jar"]