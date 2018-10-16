FROM openjdk:8u171-jdk-alpine3.8

RUN mkdir app
COPY . app

WORKDIR app

RUN ls app

RUN ./gradlew clean assemble

ENTRYPOINT ./gradlew check