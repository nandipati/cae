#!/usr/bin/env sh

export JAVA_HOME=/usr/lib/jvm/java-8-oracle &&
                         java -jar /app.jar --server.port=80  --management.port=81