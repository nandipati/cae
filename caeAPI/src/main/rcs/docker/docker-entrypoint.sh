#!/usr/bin/env sh

export JAVA_HOME=/usr/lib/jvm/java-8-oracle &&
                         java -Xmx@java.xmx.mb@m -Xms@java.xms.mb@m -jar /app.@project.packaging@ --server.port=80  --management.port=81