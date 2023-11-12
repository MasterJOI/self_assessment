# контейнер із Gradle для збірки проекту
FROM gradle:7.2-amazoncorretto-17 AS build
WORKDIR /workspace/app
COPY build.gradle settings.gradle gradle.properties /workspace/app/
COPY gradle /workspace/app/gradle
COPY src /workspace/app/src
RUN gradle build --no-daemon

# копіювання зібраного додатку в контейнер із OpenJDK
FROM openjdk:17
COPY --from=build /workspace/app/build/libs/app.jar /tmp/app.jar
COPY ./known_hosts /root/.ssh/known_hosts
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /tmp/app.jar"]

