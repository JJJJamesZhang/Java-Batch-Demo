FROM openjdk:15-slim-buster
# VOLUME /tmp
#ADD docker-spring-boot-1.0.0.jar app.jar
ADD ./target/demo-java-batch-0.0.1-SNAPSHOT.jar app.jar
ADD ./jmx_prometheus_javaagent-0.12.0.jar ajent.jar
ADD ./config.yaml config.yaml
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
CMD java -javaagent:ajent.jar=8083:config.yaml -jar app.jar