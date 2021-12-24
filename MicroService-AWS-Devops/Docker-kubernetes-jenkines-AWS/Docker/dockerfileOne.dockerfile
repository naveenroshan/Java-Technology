FROM centos
RUN yum install -y httpd
ADD index.html /var/www/html
CMD apachectl -D FOREGROUD
EXPOSE 80
MAINTAINER NAVEEN
ENV myenv myval
