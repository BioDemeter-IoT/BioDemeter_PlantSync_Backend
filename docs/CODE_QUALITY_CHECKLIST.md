# Code Quality Checklist - PlantSync

This document serves as the quality checklist for the PlantSync Backend project. It includes automated and manual checks to ensure high standards in the codebase.

## 1. Automated Checks (Tools)

| Check | Tool | Command | Requirement |
| :--- | :--- | :--- | :--- |
| **Code Style** | Checkstyle | `mvn checkstyle:check` | 0 errors |
| **Test Coverage** | JaCoCo | `mvn test` | > 80% coverage |
| **Static Analysis** | SonarLint / PMD | IDE Plugin | 0 high-priority issues |

## 2. Structural Checklist (DDD & Architecture)

- [ ] **Bounded Contexts**: Ensure all code is within a specific bounded context (iam, profiles, tasks, etc.).
- [ ] **Layer Separation**:
    - `application`: Command/Query services, internal services.
    - `domain`: Aggregates, Entities, Value Objects, Services, Exceptions.
    - `infrastructure`: Persistence (JPA), External API clients.
    - `interfaces`: REST Controllers, Resources, Assemblers, Transformers.
- [ ] **Value Objects**: Use Value Objects for complex data types (e.g., `PersonName`, `PlantId`).
- [ ] **Aggregates**: Ensure clear Aggregate Roots and proper use of repositories.

## 3. Implementation Checklist

- [ ] **Naming**: Follow camelCase for methods/variables and PascalCase for classes.
- [ ] **Validation**: Use `@Valid` and Jakarta Validation constraints in Resources.
- [ ] **Exception Handling**: Use Global Exception Handler for consistent API responses.
- [ ] **OpenAPI**: Ensure all endpoints are documented with Swagger/OpenAPI annotations.

## 4. Testing Checklist

- [ ] **Unit Tests**: Coverage for domain logic and services.
- [ ] **Integration Tests**: Verify database interactions and API endpoints (MockMvc).
- [ ] **Performance**: Verify response times for critical endpoints.
