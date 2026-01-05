# Этап 1: Сборка (используем Amazon Corretto 21)
FROM maven:3.9.6-amazoncorretto-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Этап 2: Запуск (используем легкий образ Alpine с Java 21)
FROM eclipse-temurin:21-jdk-alpine
# Копируем созданный jar-файл
COPY --from=build /target/*.jar app.jar
# Указываем порт 8081
EXPOSE 8081
# Команда запуска
ENTRYPOINT ["java", "-jar", "app.jar"]
