FROM java

MAINTAINER Inori

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /inori-blog

WORKDIR /inori-blog

EXPOSE 12008

ADD ./target/inori.jar /inori-blog

CMD sleep 10;java -jar -Xms128M -Xmx128M -server inori.jar