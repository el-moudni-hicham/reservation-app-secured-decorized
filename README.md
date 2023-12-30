# Microservices Reservation System

## Table of Contents
1. [Project Overview](#project-overview)
2. [Tasks](#tasks)
   - [1. Technical Architecture](#1-technical-architecture)
   - [2. Maven Project](#2-maven-project)
   - [3. Technical Microservices Development and Testing](#3-technical-microservices-development-and-testing)
   - [4. Resources-Service Development and Testing](#4-resources-service-development-and-testing)
   - [5. Reservation-Service Development and Testing](#5-reservation-service-development-and-testing)
   - [6. Angular Frontend](#6-angular-frontend)
   - [7. Security](#7-security)
   - [8. Deployment with Docker](#8-deployment-with-docker)

## Project Overview

```
This project aims to create a reservation management application based on a microservices architecture. 
The application will handle reservations for resources, with each reservation associated with
a single resource.

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

### 1. Technical Architecture

Technical architecture for the project, including the microservices and their interactions. Identify the technologies and tools used for each component.

![arch (1)](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/f83c29da-97f1-4536-9fd8-f5c9ead81462)


### 2. Maven Project

Create a Maven project that includes the following microservices:

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/09feb266-255a-4a84-ad5c-e3341589bec0)

- `resources-service`
```
C:.
│   .gitignore
│   Dockerfile
│   HELP.md
│   mvnw
│   mvnw.cmd
│   pom.xml
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───dev
│   │   │       └───moudni
│   │   │           └───resourcesservice
│   │   │               │   ResourcesServiceApplication.java
│   │   │               │
│   │   │               ├───dtos
│   │   │               │       ResourceRequestDTO.java
│   │   │               │       ResourceResponseDTO.java
│   │   │               │
│   │   │               ├───entites
│   │   │               │       Resource.java
│   │   │               │
│   │   │               ├───enums
│   │   │               │       ResourceType.java
│   │   │               │
│   │   │               ├───exceptions
│   │   │               │       ResourceNotFoundException.java
│   │   │               │
│   │   │               ├───mappers
│   │   │               │       ResourceMapper.java
│   │   │               │
│   │   │               ├───repository
│   │   │               │       ResourceRepository.java
│   │   │               │
│   │   │               ├───security
│   │   │               │       JwtAuthConverter.java
│   │   │               │       SecurityConfiguration.java
│   │   │               │
│   │   │               ├───service
│   │   │               │       ResourceService.java
│   │   │               │       ResourceServiceImpl.java
│   │   │               │
│   │   │               └───web
│   │   │                       ResourceController.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───static
│   │       └───templates
│
```
- `reservation-service`
```
C:.
│   .gitignore
│   Dockerfile
│   HELP.md
│   mvnw
│   mvnw.cmd
│   pom.xml
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───dev
│   │   │       └───moudni
│   │   │           └───reservationservice
│   │   │               │   ReservationServiceApplication.java
│   │   │               │
│   │   │               ├───entites
│   │   │               │       Person.java
│   │   │               │       Reservation.java
│   │   │               │
│   │   │               ├───enums
│   │   │               │       ResourceType.java
│   │   │               │
│   │   │               ├───feign
│   │   │               │       FeignInterceptor.java
│   │   │               │       ResourceFeign.java
│   │   │               │
│   │   │               ├───model
│   │   │               │       Resource.java
│   │   │               │
│   │   │               ├───repository
│   │   │               │       PersonRepository.java
│   │   │               │       ReservationRepository.java
│   │   │               │
│   │   │               ├───security
│   │   │               │       JwtAuthConverter.java
│   │   │               │       SecurityConfiguration.java
│   │   │               │
│   │   │               └───web
│   │   │                       PersonController.java
│   │   │                       ReservationController.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───static
│   │       └───templates
```
- `gateway-service`
```
C:.
│   .gitignore
│   Dockerfile
│   HELP.md
│   mvnw
│   mvnw.cmd
│   pom.xml
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───dev
│   │   │       └───moudni
│   │   │           └───gatewayservice
│   │   │                   GatewayServiceApplication.java
│   │   │
│   │   └───resources
│   │           application.properties
│   │           application.yml
```
- `discovery-service`
```
C:.
│   .gitignore
│   Dockerfile
│   HELP.md
│   mvnw
│   mvnw.cmd
│   pom.xml
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───dev
│   │   │       └───moudni
│   │   │           └───discoveryservice
│   │   │                   DiscoveryServiceApplication.java
│   │   │
│   │   └───resources
│   │           application.properties
```
- `config-service`
```
C:.
│   .gitignore
│   Dockerfile
│   HELP.md
│   mvnw
│   mvnw.cmd
│   pom.xml
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───dev
│   │   │       └───moudni
│   │   │           └───configurationservice
│   │   │                   ConfigurationServiceApplication.java
│   │   │
│   │   └───resources
│   │           application.properties
```
- `angular-front-app`


### 3. Technical Microservices Development and Testing

Develop and test the following microservices:

- **Discovery Service**:
  
![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/a6b50497-5ebf-4245-93bd-28ae2637ace8)

- **Gateway Service**:

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/c03ab2cb-5e27-4817-8e73-d0dd2c246573)


![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/f4cf026b-087d-40f9-afda-519053b48897)

  
- **Config Service**:

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/7d981824-7bce-423e-a064-63869bb536ce)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/3a7e2631-4a7e-4aec-86e2-6d76a109d4e3)

`config git repository` : [https://github.com/el-moudni-hicham/exam-config-git-repo](https://github.com/el-moudni-hicham/exam-config-git-repo)

### 4. Resources-Service Development and Testing

Develop and test the `resources-service` microservice, including:

```
- Entities
- DAO (Data Access Object)
- Service
- DTO (Data Transfer Object)
- Mapper
- RestController
```

* H2 Database
  
![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/4c910ac0-ba71-4c40-b282-aa6c9a92ed1b)

* Endpoints Tests
  
![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/8934a1f0-6a2b-4dcf-9237-947f04a28bad)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/151e4dae-9238-4e3f-a8b5-3b3b0c394f3e)

* Swagger

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/402fddb5-4532-4801-9d89-a7247285ec78)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/9553569d-0e36-4ec4-83de-b9a3269ca784)


### 5. Reservation-Service Development and Testing

Develop and test the `reservation-service` microservice, including:


```
- Entities
- DAO
- Service
- DTO
- Mapper
- RestController
- Rest client using Open Feign
```

* H2 Database

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/d30e6b84-d4e9-442d-b1ca-cd67d67fdfac)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/43944b0b-21a8-4c37-a7b0-447e859d3c8e)

* Endpoints Tests

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/3b41d891-de2d-46be-9a80-2d7559222af5)

* Resilience4J

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/86b9d95f-dce6-4617-a4c0-63744fb09add)


* Swagger

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/eee421a2-3098-4691-8a5e-1791f85b0ec2)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/d84cc5f4-8bb3-4c50-88cd-8a5a395a4937)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/dbb07c5f-a373-451e-83da-fe13b11c029a)



### 6. Angular Frontend

Develop a simple web frontend for the application using the Angular framework.

* Login Page :

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/5a5ee272-ca00-4984-83b8-ced516f44b9a)

* Dashboard Reservations

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/decc5246-b6fb-4fc8-ace1-1cbd8963e96e)

 - Display Reservator Infos
   
![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/2091a50e-8357-450b-8388-d4e15d45c6d3)

 - Display Resource Infos

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/00acc3b8-60cf-4a50-a48e-287b80c83006)


 - Display Resource Infos in case of fault tolerance

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/b3f2ea18-99d8-472b-9b4a-08bc76cfd984)

* Reservators 

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/59521089-44a5-41a6-b336-763fdb6171df)

* Resources

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/be8f676e-0d54-4900-b8f7-9933e0c4b43e)

  
### 7. Security

Secure the application with Keycloak for authentication.

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/23391730-4219-4923-af68-73bce1d94b8f)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/af41673a-a6ab-4b4b-aa6a-7deff35891ad)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/df1d6ef3-19be-4a4e-85ad-dc7ca7b4c31a)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/77d36793-80eb-46e2-94f7-db368f037588)

### 8. Deployment with Docker

Deploy the application using Docker and Docker Compose.

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/a8e43762-f1cb-4864-afc3-3488c4c77b12)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/46e9affa-9962-4030-8765-7a518a68195c)

![image](https://github.com/el-moudni-hicham/reservation-app-secured-decorized/assets/85403056/8290bd99-22b6-4f3d-8679-300848958fad)



