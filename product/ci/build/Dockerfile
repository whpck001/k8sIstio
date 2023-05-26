FROM openjdk:11-jdk-buster

ADD sources.list /etc/apt/sources.list

ADD *.jar /app/app.jar

WORKDIR /app

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

CMD bash -c "java -Duser.timezone=GMT+08 -jar app.jar --server.port=8080"
