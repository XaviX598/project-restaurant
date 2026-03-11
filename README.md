# Trattoria Roma - Landing Page Restaurante Italiano

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green)
![React](https://img.shields.io/badge/React-18.2.0-blue)
![Vite](https://img.shields.io/badge/Vite-5.0.8-yellow)
![Docker](https://img.shields.io/badge/Docker-Ready-blue)

Proyecto de landing page para el restaurante **Trattoria Roma**, un restaurante de comida italiana ubicado en Quito, Ecuador. El proyecto incluye un backend desarrollado en Spring Boot y un frontend en React con diseño minimalista y transiciones suaves al hacer scroll.

## Tecnologías Usadas

### Backend
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Lombok**

### Frontend
- **React 18.2.0**
- **Vite 5.0.8**
- **React Router DOM**
- **Axios**
- **CSS3 con variables personalizadas**

### Infraestructura
- **Docker**
- **Docker Compose**
- **Nginx** (para producción del frontend)

## Estructura del Proyecto

```
proyecto/
├── api/                          # Backend Spring Boot
│   ├── src/main/java/com/app/api
│   │   ├── config/              # Configuraciones
│   │   ├── controller/          # Controladores REST
│   │   ├── service/             # Lógica de negocio
│   │   ├── repository/          # Repositorios JPA
│   │   ├── entity/              # Entidades
│   │   ├── dto/                 # Objetos de transferencia
│   │   ├── mapper/              # Mappers Entity-DTO
│   │   ├── exception/          # Manejo de excepciones
│   │   └── util/               # Utilidades
│   ├── src/main/resources/
│   │   └── application.yml     # Configuración
│   ├── src/test/java/          # Pruebas
│   ├── pom.xml
│   └── Dockerfile
│
├── front/                        # Frontend React
│   ├── src/
│   │   ├── api/                # Configuración Axios
│   │   ├── components/         # Componentes reutilizables
│   │   ├── pages/              # Páginas
│   │   ├── services/           # Servicios API
│   │   ├── hooks/              # Custom Hooks
│   │   ├── styles/             # Estilos globales
│   │   ├── App.jsx
│   │   └── main.jsx
│   ├── package.json
│   ├── vite.config.js
│   └── Dockerfile
│
├── docker-compose.yml           # Orquestación de contenedores
├── postman/                      # Colección Postman
│   └── Trattoria_Roma_API.postman_collection.json
└── README.md
```

## Características

- **Diseño minimalista** con tipografía elegante
- **Transiciones suaves** al hacer scroll (Intersection Observer)
- **Menú dinámico** con 12 platos italianos auténticos
- **Botón flotante de WhatsApp** para reservas
- **Mapa interactivo** con ubicación en Quito
- **Arquitectura REST** completa
- **Pruebas unitarias** y de controlador
- **Totalmente dockerizado**

## Ejecución Local

### Prerrequisitos
- Java 17+
- Node.js 18+
- Maven 3.8+
- Docker y Docker Compose (opcional)

### Ejecutar Backend (Local)

```bash
cd api
mvn clean install
mvn spring-boot:run
```

El backend estará disponible en: `http://localhost:8080`

### Ejecutar Frontend (Local)

```bash
cd front
npm install
npm run dev
```

El frontend estará disponible en: `http://localhost:5173`

### Ejecutar con Docker Compose

```bash
# Desde la raíz del proyecto
docker-compose up --build

# O en segundo plano
docker-compose up -d --build
```

Servicios disponibles:
- **Frontend**: http://localhost:80
- **Backend**: http://localhost:8080
- **PostgreSQL**: localhost:5432

## Endpoints API

### Menú

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/menu` | Obtiene todos los platos |
| GET | `/api/menu/disponibles` | Obtiene platos disponibles |
| GET | `/api/menu/{id}` | Obtiene un plato por ID |
| GET | `/api/menu/categoria/{categoria}` | Filtra por categoría |
| GET | `/api/menu/categorias` | Lista todas las categorías |

### Información del Restaurante

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/restaurant` | Obtiene información del restaurante |

## Colección Postman

La colección de Postman se encuentra en: `postman/Trattoria_Roma_API.postman_collection.json`

### Importar colección:

1. Abre Postman
2. Click en "Import"
3. Selecciona el archivo JSON
4. La colección se importará automáticamente

## Datos de Ejemplo

El proyecto incluye datos iniciales pre-cargados:

### Platos del Menú (12 items)
- **Pastas**: Spaghetti Carbonara, Lasagna Tradicional, Fettuccine Alfredo, Gnocchi al Pesto
- **Pizzas**: Pizza Margherita, Pizza Quattro Formaggi
- **Carnes**: Osso Buco alla Milanese, Saltimbocca alla Romana
- **Pescados**: Branzino al Forno
- **Arroces**: Risotto ai Funghi
- **Postres**: Tiramisú, Panna Cotta

### Información del Restaurante
- **Nombre**: Trattoria Roma
- **Dirección**: Av. González Suárez N27-187, La Floresta, Quito
- **Teléfono**: +593 2 123 4567
- **Email**: reservas@trattoriaroma.ec
- **Horario**: Lunes a Domingo 12:00 - 22:00

## Configuración de Base de Datos

```yaml
# PostgreSQL
Host: localhost
Puerto: 5432
Base de datos: appdb
Usuario: postgres
Contraseña: postgres
```

## Variables de Entorno (Docker)

```yaml
# Backend
SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/appdb
SPRING_DATASOURCE_USERNAME: postgres
SPRING_DATASOURCE_PASSWORD: postgres
SPRING_JPA_HIBERNATE_DDL_AUTO: update
```

## Pruebas

El proyecto incluye pruebas unitarias y de controlador:

```bash
# Ejecutar pruebas del backend
cd api
mvn test
```

### Cobertura de Pruebas
- **Service Layer**: Pruebas de lógica de negocio
- **Controller Layer**: Pruebas de endpoints REST
- **Casos de éxito y error**

## Estilo de Código

El proyecto sigue las mejores prácticas de desarrollo:

- Arquitectura en capas (Controller → Service → Repository)
- Uso de DTOs de datos
- para transferencia Manejo centralizado de excepciones
- Código limpio y mantenible
- Nombres descriptivos y consistentes
- Validaciones apropiadas

## Licencia

Este proyecto es solo para fines educativos y de demostración.
