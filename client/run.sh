#bin/bash
docker build -t kideo/assessment-frontend:latest .
docker run -p 127.0.0.1:3000:80 kideo/assessment-frontend:latest
