#!/bin/bash
sudo apt update
sudo apt install sshpass
sshpass -p $SSH_PASS ssh -o StrictHostKeyChecking=no ubuntu@15.237.113.118
sudo docker stop dummy-backend || true
sudo docker rm dummy-backend || true
sudo docker pull maroskolarik/circleci-app:${CIRCLE_SHA1}
sudo docker run -d -p 8080:8080 --restart unless-stopped --name dummy-backend maroskolarik/circleci-app:${CIRCLE_SHA1}