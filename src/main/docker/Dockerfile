FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD spring-docker.jar app.jar
ENV TZ Asia/Shanghai
EXPOSE 8089
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]