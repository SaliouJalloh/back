FROM eclipse-temurin:21.0.1_12-jdk-alpine
WORKDIR /app

ARG JAR_FILE=target/*.jar

#MAJ alpine
RUN apk -U upgrade
COPY ${JAR_FILE} EcommerceApplication.jar
EXPOSE 8085
ENTRYPOINT [ "java", "-jar", "EcommerceApplication.jar" ]