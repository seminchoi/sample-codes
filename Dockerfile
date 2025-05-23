# JDK 17 베이스 이미지 사용
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# JAR 파일을 컨테이너로 복사
COPY build/libs/notice-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "-Dspring.active.profile=prod", "app.jar"]