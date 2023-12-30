# README for Microservices Reservation System

## Project Overview

```
This project aims to create a reservation management application based on a microservices architecture. 
The application will handle reservations for resources, with each reservation associated with a single resource.

A resource is defined by its ID, name, and type (MATERIEL_INFO, MATERIEL_AUDIO_VISUEL). 
A reservation is defined by its ID, name, context, date, and duration, and is made by a person. 
A person is defined by their ID, name, email, and function.
```

The application consists of two functional microservices:

- **Resources-Service**: Manages resources.
- **Reservation-Service**: Manages reservations made by people.

The technical microservices to be implemented are:

- **Service Gateway**: Based on Spring Cloud Gateway.
- **Service Discovery**: Based on Eureka Server.
- **Service Configuration**: Based on Spring Cloud Config.

For the application,

- A web frontend will be developed using the `Angular framework`. 
- Security will be based on OAuth2 and OIDC with `Keycloak` as the identity provider. 
- Microservices will generate RESTful web service documentation using the OpenAPI Specification `Swagger`. 
- Circuit breakers based on `Resilience4J` will be used for fault tolerance.


## Tasks

### 1. Architecture

Establish a technical architecture for the project, including the microservices and their interactions. Identify the technologies and tools used for each component.

### 2. Maven Project

Create a Maven project that includes the following microservices:

- `resources-service`
- `reservation-service`
- `gateway-service`
- `discovery-service`
- `config-service`
- `angular-front-app`

### 3. Technical Microservices Development and Testing

Develop and test the following microservices:

- **Discovery Service**: Service discovery using Eureka Server or Consul Discovery.
- **Gateway Service**: API gateway using Spring Cloud Gateway.
- **Config Service**: Configuration service using Spring Cloud Config or Consul Config.

### 4. Resources-Service Development and Testing

Develop and test the `resources-service` microservice, including:

- Entities
- DAO (Data Access Object)
- Service
- DTO (Data Transfer Object)
- Mapper
- RestController

### 5. Reservation-Service Development and Testing

Develop and test the `reservation-service` microservice, including:

- Entities
- DAO
- Service
- DTO
- Mapper
- RestController
- Rest client using Open Feign

### 6. Angular Frontend

Develop a simple web frontend for the application using the Angular framework.

### 7. Security

Secure the application with Keycloak for authentication.

### 8. Deployment with Docker

Deploy the application using Docker and Docker Compose.

## Submission

Submit a PDF report and the source code of the projects in a zip format, addressing the following questions:

1. Detailed technical architecture of the project.
2. Maven project structure.
3. Development and testing of discovery-service, gateway-service, and config-service.
4. Development and testing of resources-service.
5. Development and testing of reservation-service.
6. Implementation of the Angular frontend.
7. Security implementation with Keycloak.
8. Deployment using Docker and Docker Compose.
