# Reto Backend: Sistema de Gestión de Personas 👤

## 🎯 Objetivo

Desarrollar una API REST para la gestión de personas, implementando operaciones CRUD, persistencia en MySQL y buenas prácticas de desarrollo backend.


## 🛠️ Tecnologías

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen)
![Java](https://img.shields.io/badge/Java-21-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Maven](https://img.shields.io/badge/Maven-red)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green)


## 📋 Pre-requisitos

1. **Java 21**
2. **MySQL 8**
3. **Maven**
4. **Git**
5. **Postman** (opcional)


## 🚀 Instrucciones de Instalación y Uso



#### 1.1. Clonar el repositorio
```
git clone https://github.com/Emmlg/person-api-credi.git
cd person-api-credi
```
#### 1.2. Abrir el proyecto en tu IDE favorito

> 💡 **NOTA**: Verifica que el proyecto esté configurado **Java 21**.


#### 1.3. Crear la base de datos MOCK con el siguiente script

> [!IMPORTANT]
> Si cambias el nombre o credenciales de la base de datos, actualízalos en application.yaml

####  1.4. Configuración de Variables de entorno
```
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: "${DATASOURCE_URL"
    username: "${DATASOURCE_USERNAME:}"
    password: "${DATASOURCE_PASSWORD:}"
```

## 2. Documentación de la API
Una vez iniciada la aplicación:

- *Swagger UI*

``` http://localhost:8080/api/v1/select/swagger-ui.html ```
- *Base de API*
```http://localhost:8080/api/v1/select/person```



📌 Endpoints principales

[] POST /api/v1/select/person → Crear persona
[] GET /api/v1/select/person → Listar personas
[] GET /api/v1/select/person/{id} → Obtener persona
[] PUT /api/v1/select/person/{id} → Actualizar persona
[] DELETE /api/v1/select/person/{id} → Eliminar persona
[] PUT /api/v1/select/person/disable/{id} → Eliminar persona de forma logica






