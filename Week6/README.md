# Week 6 — Microservices with Spring Boot 3 and Spring Cloud (Mandatory Hands-On)

## 🎯 Objective
Create Microservices for **Account** and **Loan**, register them with a **Eureka Discovery
Server**, and route requests to both through a single **API Gateway**.

This covers the mandatory item: *"Creating Microservices for account and loan"* (with the
additional item *"Create Eureka Discovery Server and register microservices"* also included).

## 🧩 Modules
```
Week6-Microservices/
├── eureka-server/     -> Service Registry (Spring Cloud Netflix Eureka), port 8761
├── account-service/    -> REST microservice for account details, port 8081
├── loan-service/       -> REST microservice for loan details, port 8082
└── api-gateway/        -> Spring Cloud Gateway routing to both services, port 8080
```

## 🛠️ Tools & Versions
- Java 17
- Spring Boot 3.2.x
- Spring Cloud 2023.0.x (Eureka Client/Server, Gateway)
- Maven 3.6+

## ▶️ How to run (in order)
```bash
cd eureka-server   && mvn spring-boot:run   # starts registry on 8761
cd account-service && mvn spring-boot:run   # registers as ACCOUNT-SERVICE
cd loan-service    && mvn spring-boot:run   # registers as LOAN-SERVICE
cd api-gateway     && mvn spring-boot:run   # gateway on 8080
```

Eureka dashboard: http://localhost:8761

## 🔗 Test the flow
```
GET http://localhost:8081/accounts/1          (direct to account-service)
GET http://localhost:8082/loans/1             (direct to loan-service)

GET http://localhost:8080/account/accounts/1  (via API Gateway -> account-service)
GET http://localhost:8080/loan/loans/1        (via API Gateway -> loan-service)
```

## 📌 What each piece demonstrates
- **Service Registry & Discovery**: `account-service` and `loan-service` auto-register
  themselves with Eureka using `@EnableDiscoveryClient` + `eureka.client.service-url`.
- **API Gateway routing**: `api-gateway`'s `application.yml` defines routes that use Eureka's
  `lb://` (load-balanced) URIs, so the gateway discovers instances dynamically instead of
  hardcoding host:port.
- **Independent deployability**: each service has its own `pom.xml`, own port, own data — the
  core "database per service" principle from the module.
