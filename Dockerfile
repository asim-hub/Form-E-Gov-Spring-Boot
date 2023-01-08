FROM maven:3.8.4-openjdk-17
WORKDIR /
EXPOSE 8080
#COPY . .
#RUN mvn clean install -Dmaven.test.skip=true
#CMD mvn spring-boot:run
ADD target/form-0.0.1-SNAPSHOT.jar form-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/form-0.0.1-SNAPSHOT.jar"]