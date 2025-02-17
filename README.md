# User Role Management System

## Описание проекта

Проект представляет собой систему управления пользователями и ролями, реализованную в микросервисной архитектуре. Каждый микросервис предоставляет REST API для выполнения CRUD операций над пользователями, ролями, а также для управления связью между ними.

### Основные технологии:
- **Java**
- **Spring Boot**
- **Gradle**
- **PostgreSQL**
- **JUnit 5**
- **Spring Security** (для базовой аутентификации)
- **SLF4J** (для логирования)

## Микросервисы

### 1. Микросервис "Пользователи"
Предоставляет CRUD операции для управления пользователями:
- **GET /api/users** — получение списка всех пользователей
- **GET /api/users/{id}** — получение пользователя по ID
- **POST /api/users** — создание нового пользователя
- **PUT /api/users/{id}** — обновление пользователя по ID
- **DELETE /api/users/{id}** — удаление пользователя по ID

#### Модель данных:
- **User**:
    - `id` (Long) — уникальный идентификатор пользователя
    - `username` (String) — имя пользователя (уникальное)
    - `email` (String) — email пользователя (уникальный)
    - `password` (String) — пароль пользователя (хранится в зашифрованном виде)
    - `createdAt` (LocalDateTime) — дата и время создания пользователя
    - `updatedAt` (LocalDateTime) — дата и время последнего обновления пользователя

### 2. Микросервис "Роли"
Предоставляет CRUD операции для управления ролями:
- **GET /api/roles** — получение списка всех ролей
- **GET /api/roles/{id}** — получение роли по ID
- **POST /api/roles** — создание новой роли
- **PUT /api/roles/{id}** — обновление роли по ID
- **DELETE /api/roles/{id}** — удаление роли по ID

#### Модель данных:
- **Role**:
    - `id` (Long) — уникальный идентификатор роли
    - `name` (String) — название роли (уникальное)
    - `description` (String) — описание роли

### 3. Микросервис "Связь пользователей и ролей" (User-Role Linking)
Этот микросервис реализует связь "многие ко многим" между пользователями и ролями. Поддерживаются следующие операции:
- **GET /api/users/{userId}/roles** — получение списка ролей пользователя
- **POST /api/users/{userId}/roles/{roleId}** — назначение роли пользователю
- **DELETE /api/users/{userId}/roles/{roleId}** — удаление роли у пользователя

#### Модель данных:
- **UserRole**:
    - `userId` (Long) — идентификатор пользователя
    - `roleId` (Long) — идентификатор роли

## Архитектура

Проект разделён на три микросервиса:
1. **User Service** — микросервис для управления пользователями.
2. **Role Service** — микросервис для управления ролями.
3. **User-Role Linking Service** — микросервис для управления связью между пользователями и ролями.

### Взаимодействие между микросервисами

Каждый микросервис имеет свою отдельную базу данных. Взаимодействие между микросервисами осуществляется через REST API. Микросервисная архитектура позволяет легко масштабировать отдельные сервисы и управлять их автономным развертыванием.

### Слои приложения
- **Контроллеры (Controllers)** — обрабатывают HTTP-запросы.
- **Сервисы (Services)** — содержат бизнес-логику приложения.
- **Репозитории (Repositories)** — отвечают за взаимодействие с базой данных.

## Тестирование

В проекте реализованы:
- **Unit-тесты** для сервисного слоя.
- **Интеграционные тесты** для REST API.

Тестирование выполнено с использованием JUnit 5 и MockMVC.

## Логирование

Логирование запросов и ответов REST API реализовано с помощью SLF4J. Это позволяет отслеживать операции в системе для упрощения мониторинга и отладки.

## Безопасность

Для защиты API используется базовая аутентификация, реализованная с использованием Spring Security. Все запросы к API требуют авторизации.

## Документация
Для удобства работы с API добавлена документация с использованием Swagger. После запуска каждого микросервиса, документация доступна на его порту, указанном в настройках проекта.

- **Микросервис "Пользователи"** - документация доступна по адресу: `http://localhost:<порт-пользователей>/swagger-ui.html`
- **Микросервис "Роли"** - документация доступна по адресу: `http://localhost:<порт-ролей>/swagger-ui.html`
- **Микросервис "Связи пользователей и ролей"** - документация доступна по адресу: `http://localhost:<порт-связи>/swagger-ui.html`


## Как запустить проект

### Предварительные требования:
- Установленный **Java 17** или выше
- Установленный **PostgreSQL**
- Установленный **Gradle 8.5**

### Запуск локально:
1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/PetukhovDN/user-role-linking.git
2. Перейдите в директорию проекта:
   ```bash
   cd user-role-management

3. Настройте базу данных PostgreSQL для каждого микросервиса, добавив параметры подключения в файлы application.settings.
4. Выполните команду для сборки и запуска всех микросервисов:
   ```bash
    ./gradlew bootRun
5. Откройте Swagger-документацию для тестирования API:
   ```bash
    http://localhost:8080/swagger-ui.html

## Информация для разработчиков

- **Система сборки:** Gradle
- **Тестирование:** JUnit 5
- **База данных:** PostgreSQL
- **Фреймворк:** Spring Boot
- **Логирование:** SLF4J
- **Безопасность:** Spring Security

## Контакты
Для вопросов или предложений свяжитесь с [petuhovdn77112@gmail.com](mailto:petuhovdn77112@gmail.com).
