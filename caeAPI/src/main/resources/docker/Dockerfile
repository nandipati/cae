FROM alpine:3.7

RUN apk update
RUN apk fetch openjdk8
RUN apk add openjdk8

VOLUME /tmp

ADD @project.build.finalName@.@project.packaging@ app.@project.packaging@