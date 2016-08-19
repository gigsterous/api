FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD gigsterous-api-0.0.1-SNAPSHOT.jar api_app.jar
RUN sh -c 'touch /api_app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api_app.jar"]