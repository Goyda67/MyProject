# Этап 1: Сборка
FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /app
# Копируем сначала только pom.xml для кэширования зависимостей
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходный код и собираем
COPY src ./src
RUN mvn clean package -DskipTests

# Этап 2: Запуск
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Важно: указываем точный путь из этапа сборки
COPY --from=build /app/target/*.jar app.jar

# На Render порт динамический, но Spring должен слушать 8081, если вы так настроили
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
