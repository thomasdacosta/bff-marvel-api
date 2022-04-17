#!/bin/bash
nohup /usr/bin/java -jar -Dspring.profiles.active=production /home/ec2-user/bff-marvel-api/bff-marvel-api.jar &
