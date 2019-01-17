FROM alpine:3.7

RUN apk update
RUN apk fetch openjdk8
RUN apk add openjdk8

VOLUME /tmp
ADD ./caeAPI-0.1-SNAPSHOT.jar app.jar
ADD ./docker-entrypoint.sh /usr/src/app/

RUN chmod +x /usr/src/app/docker-entrypoint.sh

ENTRYPOINT /usr/src/app/docker-entrypoint.sh


#ADD @project.build.finalName@.@project.packaging@ app.@project.packaging@