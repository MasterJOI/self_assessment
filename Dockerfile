# Використовуємо образ з встановленою JDK та Gradle
FROM gradle:8.4.0-jdk17 AS build

# Працюємо у робочій директорії /workspace/app
WORKDIR /workspace/app

# Копіюємо файли gradle та кешуємо залежності
COPY build.gradle .
COPY settings.gradle .
RUN gradle --no-daemon dependencies

# Копіюємо решту коду та виконуємо збірку
COPY src src
RUN gradle --no-daemon bootJar

# Використовуємо образ з встановленою JRE
FROM eclipse-temurin:17-jre-alpine

# Копіюємо JAR файл з попереднього етапу збірки
COPY --from=build /workspace/app/build/libs/*.jar /tmp/app.jar

# Вказуємо порт, який буде відкритий в контейнері
EXPOSE 8080

# Вказуємо команду для запуску додатку та мігруємо базу даних
ENTRYPOINT ["sh", "-c", "java -jar /tmp/app.jar && sleep 10 && java -jar /tmp/app.jar flyway:migrate"]


