# Task Manager API

Basic Spring Boot task manager API with CRUD endpoints, H2 storage, Lombok DTOs, and a MapStruct mapper.

## Run

```bash
mvn spring-boot:run
```

The API starts on `http://localhost:8080`.

## Endpoints

- `GET /api/tasks` - list tasks
- `GET /api/tasks/{id}` - get one task
- `POST /api/tasks` - create a task
- `PUT /api/tasks/{id}` - update a task
- `DELETE /api/tasks/{id}` - delete a task

## Sample payload

```json
{
  "title": "Buy groceries",
  "description": "Milk, eggs, and bread",
  "completed": false
}
```
