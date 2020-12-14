FROM openjdk:14
ADD target/docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 2019
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]