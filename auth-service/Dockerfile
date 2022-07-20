FROM java:8-jre
MAINTAINER Iurii Golubnichenko <ghostrider.gu@gmail.com>

ARG JAR_FILE
COPY ${JAR_FILE} auth-service.jar
CMD ["java", "-jar", "/auth-service.jar"]

EXPOSE 9099