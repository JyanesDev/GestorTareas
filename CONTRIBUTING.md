# Convenciones del proyecto GestorTareas

## Naming

### Java
- Clases: `PascalCase` → `Tarea`, `Controladora`, `TareaJpaController`
- Métodos y variables: `camelCase` → `crearTarea()`, `fechaCreacion`
- Constantes: `UPPER_SNAKE_CASE` → `MAX_INTENTOS`, `LOG`
- Paquetes: minúsculas → `logica`, `persistencia`, `logica.excepciones`

### Base de datos (PostgreSQL)
- Tablas: `snake_case` singular → `tarea`, `proyecto`
- Columnas: `snake_case` → `fecha_creacion`, `id_proyecto`
- Clave primaria: siempre `id`
- Clave foránea: `id_` + tabla referenciada → `id_proyecto`

### Git
- Ramas: `feature/fase-X-nombre`, `fix/descripcion`
- Commits: Conventional Commits → `tipo: descripción en imperativo`
- Tipos: `feat`, `test`, `fix`, `refactor`, `docs`, `chore`, `style`

## Arquitectura
- Dominio primero, persistencia después, web al final.
- Cada clase tiene una sola responsabilidad.
- Cada capa solo conoce la inmediatamente inferior.

## Testing
- Tests junto al código, no después.
- Convención: `NombreClaseTest.java` en `src/test/java/`.
- `mvn test` debe pasar antes de cada commit.