FROM alpine:latest
WORKDIR /app
COPY . .
# Эта команда покажет всю структуру файлов в логах
RUN echo "====== СТРУКТУРА ФАЙЛОВ ======" && \
    find . -maxdepth 3 && \
    echo "==============================" && \
    exit 1
