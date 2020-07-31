FROM tomcat:9.0.22
LABEL maintainer="willore@gmail.com"
ADD target/omni-departments-app.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]