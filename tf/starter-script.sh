#!/bin/bash
#allow using password to ssh
echo -e "password\npassword" | passwd ubuntu
sed -i "/^[^#]*PasswordAuthentication[[:space:]]no/c\PasswordAuthentication yes" /etc/ssh/sshd_config
service ssh restart
#install docker
apt update -y
apt install -y apt-transport-https ca-certificates curl software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add -
add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu  $(lsb_release -cs)  stable"
apt update -y
apt install -y docker-ce
systemctl start docker
systemctl enable docker
#run docker container
docker run -d -p 8080:8080 --restart unless-stopped --name dummy-backend maroskolarik/circleci-app