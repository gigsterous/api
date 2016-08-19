FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD gigsterous-auth-0.0.1-SNAPSHOT.jar auth_app.jar
RUN sh -c 'touch /auth_app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/auth_app.jar"]