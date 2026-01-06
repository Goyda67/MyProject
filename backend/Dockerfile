# --- Этап 1: Сборка ---
FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /app

# Копируем все файлы, чтобы увидеть структуру
COPY . .

# ВАЖНО: Эта команда выведет список файлов в лог Render, 
# если сборка упадет, мы увидим правильные пути.
RUN ls -R

# Копируем фронтенд в папку ресурсов бэкенда. 
# ВНИМАНИЕ: Проверьте название папки (frontend или Frontend или robux-frontend?)
# Здесь я использую путь относительно корня проекта.
RUN mkdir -p backend/src/main/resources/static/ && \
    cp frontend/index.html backend/src/main/resources/static/

# Собираем бэкенд
WORKDIR /app/backend
RUN mvn clean package -DskipTests

# --- Этап 2: Запуск ---
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/backend/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
