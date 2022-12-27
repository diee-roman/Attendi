FROM maven:3.8.3-openjdk-17
RUN mvn -v

# image layer
WORKDIR /app
ADD pom.xml /app
RUN mvn verify clean --fail-never

# Image layer: with the application
COPY . /app
RUN mvn clean install -DskipTests
EXPOSE 8080
RUN mkdir /developments
RUN mv /app/target/Attendi-0.0.1-SNAPSHOT.jar /developments/
ENTRYPOINT ["java","-jar","/developments/Attendi-0.0.1-SNAPSHOT.jar"]