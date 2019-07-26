#!/bin/sh
mvn clean package && docker build -t pl.fis.artur.kasza/jaxrs .
docker rm -f jaxrs || true && docker run -d -p 8080:8080 -p 4848:4848 --name jaxrs pl.fis.artur.kasza/jaxrs 
