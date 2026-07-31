# Cognizant_FSE — Digital Nurture 5.0 Deep Skilling (Java FSE Angular)

Solutions for the Cognizant DN 5.0 Java Full Stack Engineer Deep Skilling program, organized
week-by-week to match the program handbook. This README maps every **mandatory hands-on**
exercise (per `DN - Java FSE Mandatory hands-on detail.xlsx`) to where it lives in this repo.

## 📂 Repo structure
```
Cognizant_FSE/
├── Week1/   Design Patterns & Principles · Data Structures and Algorithms
├── Week2/   PL/SQL · JUnit · Mockito · SLF4J Logging
├── Week3/   Spring Core and Maven
├── Week4/   Spring Data JPA with Spring Boot, Hibernate
├── Week5/   Spring REST using Spring Boot 3 · JWT Authentication
├── Week6/   Microservices with Spring Boot 3 and Spring Cloud
├── Week7/   Angular (v20)
└── Week8/   Version Control - GIT
```

## ✅ Mandatory hands-on mapping

| Skill | Mandatory hands-on | Location in this repo |
|---|---|---|
| Design Patterns and Principles | Exercise 1: Singleton Pattern | `Week1/Design Principles/Singleton` |
| Design Patterns and Principles | Exercise 2: Factory Method Pattern | `Week1/Design Principles/FactoryMethodPattern` |
| Data Structures and Algorithms | Exercise 2: E-commerce Platform Search Function | `Week1/Data Structure and Algo/ProductExam` |
| Data Structures and Algorithms | Exercise 7: Financial Forecasting | `Week1/Data Structure and Algo/Financial` |
| PL/SQL Programming | Exercise 1: Control Structures | `Week2/01-PLSQL/Exercise1` |
| PL/SQL Programming | Exercise 3: Stored Procedures | `Week2/01-PLSQL/Exercise3` |
| TDD (JUnit5) | Exercise 1: Setting Up JUnit | `Week2/02-JUnit/Exercise1` |
| TDD (JUnit5) | Exercise 3: Assertions in JUnit | `Week2/02-JUnit/Exercise3` |
| TDD (JUnit5) | Exercise 4: AAA Pattern, Test Fixtures, Setup/Teardown | `Week2/02-JUnit/Exercise4` |
| TDD (Mockito) | Exercise 1: Mocking and Stubbing | `Week2/03-Mockito/Exercise1` |
| TDD (Mockito) | Exercise 2: Verifying Interactions | `Week2/03-Mockito/Exercise2` |
| SLF4J Logging Framework | Exercise 1: Logging Error Messages and Warning Levels | `Week2/04-Logging/Exercise1` |
| Spring Core and Maven | Exercise 1: Configuring a Basic Spring Application | `Week3/Exercise1-BasicSpringApplication` |
| Spring Core and Maven | Exercise 2: Implementing Dependency Injection | `Week3/Exercise2-DependencyInjection` |
| Spring Core and Maven | Exercise 4: Creating and Configuring a Maven Project | `Week3/Exercise4-MavenProject` |
| Spring Data JPA with Spring Boot, Hibernate | Spring Data JPA - Quick Example | `Week4/HandsOn1-SpringDataJPAQuickExample` |
| Spring Data JPA with Spring Boot, Hibernate | Difference between JPA, Hibernate and Spring Data JPA | `Week4/HandsOn4-DifferenceJPAHibernateSpringDataJPA` |
| Spring REST using Spring Boot 3 | Create a Spring Web Project using Maven | `Week5/HandsOn-SpringRESTServices/spring-learn` |
| Spring REST using Spring Boot 3 | Spring Core – Load Country from Spring Configuration XML | `Week5/HandsOn-SpringRESTServices/spring-learn` |
| Spring REST using Spring Boot 3 | Hello World RESTful Web Service | `Week5/HandsOn-SpringRESTServices/spring-learn` |
| Spring REST using Spring Boot 3 | REST - Country Web Service | `Week5/HandsOn-SpringRESTServices/spring-learn` |
| Spring REST using Spring Boot 3 | REST - Get country based on country code | `Week5/HandsOn-SpringRESTServices/spring-learn` |
| Spring REST using Spring Boot 3 | JWT Authentication Service | `Week5/HandsOn-JWTAuthenticationService/jwt-auth` |
| Microservices with Spring Boot 3 and Spring Cloud | Creating Microservices for account and loan (+ API Gateway, Eureka) | `Week6/eureka-server`, `Week6/account-service`, `Week6/loan-service`, `Week6/api-gateway` |
| Angular | Angular Hands-On | `Week7/angular-handson` |
| GIT | Exercises 1–5: Version control basics, branching/merging, remotes, forking/PRs, workflows | `Week8/Exercise1-VersionControlBasics.md` … `Exercise5-GitWorkflows.md` |

> **Note:** the mandatory sheet also lists a "React" block. This program's handbook uses
> **Angular v20**, not React, so those items are intentionally not covered here.

## 🛠️ Tech stack
Java 17 · Spring Boot 3 · Spring Cloud · Hibernate / Spring Data JPA · JUnit 5 · Mockito ·
SLF4J · Maven · Angular v20 · PL/SQL · GIT

## ▶️ Running things
Each week/exercise folder has its own README with setup and run instructions
(`mvn spring-boot:run` for Spring Boot modules, `npm install && ng serve` for the Angular
module). See the individual folder for specifics.
