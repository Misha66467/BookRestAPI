# Simple REST API Project (Spring Boot + Java 25 + Gradle)

Микро-проект: REST API для управления книгами в памяти (без использования базы данных).

Архитектура проекта
* `com.example.demo.controller` — REST-контроллеры (`BookController`)
* `com.example.demo.service` — Бизнес-логика и хранение данных в памяти (`BookService`)
* `com.example.demo.dto` — DTO для валидации входящих данных (`BookRequestDto`)

## Эндпоинты
* `GET /book` — получить список всех книг.
* `POST /book` — создать новую книгу (требует JSON с полями `title` и `author`).

## Как запустить проект
1. Клонируйте репозиторий или откройте проект в IntelliJ IDEA.
2. Запустите главный класс приложения: `src/main/java/com/example/demo/Application.java`.