FROM gradle:4.10.2-jdk8-alpine

RUN     mkdir           app
COPY    src             app
COPY    build.gradle    app
COPY    settings.gradle app

WORKDIR app

RUN gradle clean assemble

ARG task

ENTRYPOINT gradle $task