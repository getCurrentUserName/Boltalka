FROM debian:jessie

RUN echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main\r\ndeb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main\r\n" > /etc/apt/sources.list.d/java-8-debian.list
RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys EEA14886
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections
RUN apt-get update && apt-get install -y git postgresql maven sudo oracle-java8-installer

RUN adduser cabox --system && mkdir /home/cabox/images && adduser app --system

RUN echo "CREATE DATABASE boltalka;\r\nALTER USER "postgres" WITH PASSWORD 'root';\r\n" > /tmp/batch.sql
RUN cd /home/app &&  git clone https://github.com/getCurrentUserName/Boltalka/ && cd Bol* && mvn clean && mvn install
RUN ln -s /usr/lib/jvm/java-8-oracle /usr/lib/jvm/default-java

RUN apt-get install -y tomcat7
RUN cp /home/app/Boltalka/target/Boltalka-1.0-beta.war /var/lib/tomcat7/webapps/Boltalka-1.0-beta.war

RUN echo "#!/bin/sh\n\nset -e\nservice postgresql start\nsudo -u postgres psql -f /tmp/batch.sql\nservice tomcat7 start\n\nwhile true; do sleep 60; done\n" > ~/start.sh

#CMD /bin/sh ~/start.sh



#By Питер Винтер =)