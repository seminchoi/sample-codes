# ARM 지원 슬림 JDK 17 이미지 사용
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/reg-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
