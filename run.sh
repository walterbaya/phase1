#!/bin/bash


sudo mysql -e "DROP DATABASE IF EXISTS todo /*\!40100 DEFAULT CHARACTER SET utf8 */;"
sudo mysql -e "CREATE DATABASE todo /*\!40100 DEFAULT CHARACTER SET utf8 */;"
sudo mysql -e "USE todo; CREATE USER IF NOT EXISTS 'creator'@'localhost' IDENTIFIED BY 'alfa1234';"
sudo mysql -e "USE todo; GRANT ALL PRIVILEGES ON todo.* TO 'creator'@'localhost';"

cd frontend

sudo apt install nodejs
sudo npm install 
sudo npm run build


cd ../backend


mvn clean -f pom.xml
mvn package -f pom.xml
java -jar target/todoApp.war


trap 'sudo pkill -9 -f tomcat;'  SIGINT
