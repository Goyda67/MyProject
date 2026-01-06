# --- Этап 1: Сборка Бэкенда (Maven) ---
FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /app

# 1. Копируем файлы бэкенда (находясь в корне репозитория)
COPY backend/pom.xml ./backend/
COPY backend/src ./backend/src

# 2. Копируем НОВЫЙ фронтенд из соседней папки во внутренние ресурсы бэкенда
# Это гарантирует, что Spring Boot упакует свежий index.html в JAR
COPY frontend/index.html ./backend/src/main/resources/static/index.html

# 3. Переходим в папку бэкенда и собираем проект
WORKDIR /app/backend
RUN mvn clean package -DskipTests

# --- Этап 2: Запуск приложения ---
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Копируем созданный JAR файл из этапа сборки
COPY --from=build /app/backend/target/*.jar app.jar

# Render обычно использует порт 10000 или тот, что в настройках, 
# но мы укажем стандартный для Spring
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
