FROM java:8-jre
MAINTAINER Golubnichenko Yuriy <>

ADD ./target/config-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-server.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:9099/actuator/health || exit 1

EXPOSE 9099