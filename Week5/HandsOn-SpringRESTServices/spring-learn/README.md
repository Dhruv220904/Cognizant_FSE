📘 README.md — Spring REST using Spring Boot 3: Mandatory Hands-On

# Spring REST - Mandatory Hands-On (spring-learn)

## 🎯 Objective
Create a Spring Boot web project and demonstrate:
1. Loading a bean (`Country`) from a Spring XML configuration file
2. A Hello World RESTful web service
3. A REST service returning a single country's details
4. A REST service returning a country looked up by its (case-insensitive) code

This single project covers **all 5 mandatory items** for the "Spring REST using Spring Boot 3" skill.

---

## 🛠️ Tools & Technologies
- Java 17
- Spring Boot 3.2.5 (Spring Web, DevTools)
- Maven 3.6+
- Eclipse IDE / IntelliJ / VS Code
- Postman / curl (for testing)

---

## 📁 Project Setup
1. Go to [https://start.spring.io](https://start.spring.io) (or use the `pom.xml` already provided here).
2. Settings used:
   - **Group**: `com.cognizant`
   - **Artifact**: `spring-learn`
   - **Java**: 17
   - **Dependencies**: Spring Boot DevTools, Spring Web
3. Import into your IDE as a Maven project.
4. Build: `mvn clean package`
5. Run: `mvn spring-boot:run` (or run `SpringLearnApplication` directly)

---

## ✅ Mandatory Hands-On 1: Create a Spring Web Project using Maven
- `SpringLearnApplication.java` — the `@SpringBootApplication` entry point.
- `pom.xml` — Spring Boot parent, Spring Web + DevTools dependencies.
- Standard Maven layout: `src/main/java`, `src/main/resources`, `src/test/java`.

---

## ✅ Mandatory Hands-On 2: Spring Core – Load Country from Spring Configuration XML
- `Country.java` — plain bean with `code`/`name`, debug-logged constructor/getters/setters.
- `country.xml` — defines the `country` bean (India) and a `countryList` bean (India, US, Japan, Germany).
- `SpringLearnApplication.displayCountry()` loads `country.xml` via `ClassPathXmlApplicationContext`,
  fetches the `country` bean, and logs it — invoked from `main()`.

```java
ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
Country country = context.getBean("country", Country.class);
LOGGER.debug("Country : {}", country.toString());
```

---

## ✅ Mandatory Hands-On 3: Hello World RESTful Web Service
`HelloController.sayHello()`

```
GET http://localhost:8083/hello
→ Hello World!!
```

---

## ✅ Mandatory Hands-On 4: REST - Country Web Service
`CountryController.getCountryIndia()`

```
GET http://localhost:8083/country
→ {"code":"IN","name":"India"}
```

---

## ✅ Mandatory Hands-On 5: REST - Get country based on country code
`CountryController.getCountry(code)` → delegates to `CountryService.getCountry(code)`,
which does a case-insensitive lookup over the `countryList` bean using a lambda/stream.

```
GET http://localhost:8083/countries/in
GET http://localhost:8083/countries/IN
GET http://localhost:8083/countries/us
→ {"code":"IN","name":"India"}   /   {"code":"US","name":"United States"}
```

---

## 📂 Folder Structure
```
spring-learn/
├── pom.xml
├── README.md
└── src/main/
    ├── java/com/cognizant/springlearn/
    │   ├── SpringLearnApplication.java
    │   ├── model/Country.java
    │   ├── controller/HelloController.java
    │   ├── controller/CountryController.java
    │   └── service/CountryService.java
    └── resources/
        ├── application.properties
        └── country.xml
```

---

## 💡 Notes
- Everything uses `@RestController` so Spring auto-serializes the returned `Country` object to JSON — no manual conversion needed.
- Logging follows the hands-on spec: `info` for start/end of methods, `debug` for data values, never `System.out.println()`.
- The **additional** (non-mandatory) items for this skill — "REST - Get all countries", the exception-handling scenario, and the MockMVC test cases — are intentionally not included here, per the mandatory-only scope.

## 📌 Conclusion
This project demonstrates the full request path Spring Boot provides out of the box: loading configuration from XML, exposing it through simple `@RestController` endpoints, and returning JSON automatically — with no manual servlets, DAOs, or serialization code required.
