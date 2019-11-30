#!/bin/bash
mvn clean install
docker build -t kideo/assessment-backend:latest .
docker run -p 127.0.0.1:8080:8080 kideo/assessment-backend
