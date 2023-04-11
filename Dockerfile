FROM registry.gitlab.com/dcmp-devops/docker/java-base:latest

ENV SERVICE_NAME="claim-service-uat"

COPY target/claim-service-0.0.1-SNAPSHOT.jar app.jar

USER runner

ENTRYPOINT ["./run.sh"]
