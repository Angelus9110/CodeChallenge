FROM openjdk:12
VOLUME /tmp
ADD ./target/basketservce-0.0.1-SNAPSHOT.jar basket-service.jar
ENTRYPOINT ["java", "-jar", "/basket-service.jar"]