FROM eclipse-temurin:19-jdk-alpine
##EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ./target/user_management-springboot-webservice-0.0.1-SNAPSHOT.jar app.jar
#ADD ./target/user_management-springboot-webservice-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
