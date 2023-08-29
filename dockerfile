FROM openjdk:11
MAINTAINER pallavi
COPY file1 /temp
RUN apt-get update
RUN apt-get install apache2 -y
RUN apt-get install apache2-utils -y
EXPOSE 80
CMD ["apache2ctl", "-D", "FOREGROUND"]
