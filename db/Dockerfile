FROM mysql:5.7.25

MAINTAINER Inori

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./Api.sql /docker-entrypoint-initdb.d