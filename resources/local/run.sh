#!/bin/sh

clear 

java -Dlogging.config=./logback-spring.xml -Dcatalog.file=./catalog.xml -jar ktool-deploy-sql.jar