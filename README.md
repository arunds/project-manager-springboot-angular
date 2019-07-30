# Project Manager Application
Task manager application with springboot and angular UI. It uses MySQL as backend.

# project-manager-springboot-angular
Repository URL
https://github.com/arunds/project-manager-springboot-angular.git

springboot application with docker, mysql and nginx

## Build & Run Angular Application
project-manager-springboot-angular\project-manager-ui> __ng serve__  

## Build and push docker file
project-manager-springboot-angular\project-manager-service> __mvn install dockerfile:build__  
project-manager-springboot-angular\project-manager-service> __mvn dockerfile:push__  

## Build & Run Spring Boot Application
project-manager-springboot-angular\project-manager-service> __mvn spring-boot:run__  


#After dockerizing the application, you can run both service and UI using docker compose from the root directory
project-manager-springboot-angular> __docker-compose up__  

## Run Code Coverage Report
__mvn jacoco:report__
![Code Coverage Report](screenshots/code-coverage-report.PNG?raw=true "Code Coverage Report")

## Run Load Testing
__mvn jmeter:jmeter -P jmeter__  
Below is the report from the Jmeter tool for 100 users
![Load Testing Report](screenshots/load-testing-report.PNG?raw=true "Load Testing Report")


## After the container started we can acccess the angular application in the below URL
IP Adress of the docker VM  
http://192.168.99.100:4200/

## Add User Screen
![Add User](screenshots/user-screen.PNG?raw=true "Add User Screen")

## Add Task Screen
![Add Task](screenshots/add-task-screen.PNG?raw=true "Add Task Screen")

## View Task Screen

![View Task Screen](screenshots/view-task-screen.PNG?raw=true "View Task Screen")

Below is the mysql workbench database schema details

![MySql Workbench DB Schema](screenshots/project-manager-schema.png?raw=true "Database Schema")


