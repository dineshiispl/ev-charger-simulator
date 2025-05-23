
FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/ev-charger-simulator-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
