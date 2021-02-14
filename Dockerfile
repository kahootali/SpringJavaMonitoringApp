FROM maven:3.6.3-openjdk-11-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM registry.access.redhat.com/ubi8/openjdk-11

# Set working directory
ENV HOME=/opt/app
WORKDIR $HOME

# Expose the port on which your service will run
EXPOSE 8443

# NOTE we assume there's only 1 jar in the target dir
COPY --from=build /usr/src/app/target/*.jar $HOME/artifacts/app.jar
USER root

# USER 1001
# Set Entrypoint
ENTRYPOINT exec java $JAVA_OPTS -jar artifacts/app.jar
