🔐 README.md — Create authentication service that returns JWT

# Spring REST - Mandatory Hands-On: JWT Authentication Service

## 🎯 Objective
Build an authentication endpoint that accepts HTTP Basic credentials and responds with a
generated **JWT (JSON Web Token)** — the first step of the JWT process flow described in the
hands-on doc:
1. Client sends username and password to server
2. Server validates credentials, creates a token (JWT) and responds with it
3. *(Client attaches the token to subsequent requests — covered by a later, non-mandatory hands-on)*
4. *(Server validates the token on each request — covered by a later, non-mandatory hands-on)*

Only step 1–2 (**"Create authentication service that returns JWT"**) is mandatory for this skill.

---

## 🧰 Technologies Used
- Java 17
- Spring Boot 3.2.5
- Spring Web
- Spring Security 6
- JWT (`io.jsonwebtoken` — JJWT 0.11.5)
- Maven

---

## 🎯 Endpoint

### `GET /authenticate`
Credentials are passed via HTTP Basic Auth (the `-u` option in curl), **not** as a request body.

**Request:**
```bash
curl -s -u user:pwd http://localhost:8090/authenticate
```

**Response:**
```json
{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNTcwMzc5NDc0LCJleHAiOjE1NzAzODA2NzR9.t3LRvlCV-hwKfoqZYlaVQqEUiBloWcWn0ft3tgv0dL0"}
```

In-memory users available: `user` / `pwd` (role `USER`), `admin` / `pwd` (role `ADMIN`) — both roles
are allowed to call `/authenticate`.

---

## 🔐 How It Works
1. `SecurityConfig` sets up two in-memory users and requires HTTP Basic auth on all requests.
2. Client calls `GET /authenticate` with `Authorization: Basic <base64(user:pwd)>`.
3. `AuthenticationController.authenticate()`:
   - Reads the `Authorization` header (Spring injects it via `@RequestHeader`).
   - `getUser()` strips the `"Basic "` prefix, Base64-decodes it, and extracts the username
     (the part before the `:`).
   - `generateJwt()` builds a signed JWT (`HS256`) with the username as subject, an issued-at
     timestamp, and a 20-minute expiry.
4. Returns `{"token": "<jwt>"}` as JSON.

---

## 📄 Key Code

**AuthenticationController.java**
```java
@GetMapping("/authenticate")
public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
    String user = getUser(authHeader);
    String token = generateJwt(user);
    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    return response;
}

private String getUser(String authHeader) {
    String encoded = authHeader.substring("Basic ".length());
    byte[] decoded = Base64.getDecoder().decode(encoded);
    return new String(decoded, StandardCharsets.UTF_8).split(":")[0];
}

private String generateJwt(String user) {
    return Jwts.builder()
        .setSubject(user)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
        .signWith(SIGNING_KEY, SignatureAlgorithm.HS256)
        .compact();
}
```

**SecurityConfig.java**
```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .httpBasic(withDefaults())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
        );
    return http.build();
}
```

> **Note on modernization:** the original hands-on doc uses `WebSecurityConfigurerAdapter` and
> `Jwts.builder().signWith(SignatureAlgorithm, "secretkey")` (raw string key) — both are from
> Spring Security 5 / JJWT 0.9.x and don't exist in Spring Boot 3. This version uses the
> Spring Security 6 `SecurityFilterChain` bean style and JJWT 0.11.5's `Keys.hmacShaKeyFor(...)`,
> which is the correct modern equivalent of the same mandatory requirement.

---

## 🛠️ How to Run
```bash
mvn clean package
mvn spring-boot:run
```
Test:
```bash
curl -s -u user:pwd http://localhost:8090/authenticate
curl -s -u admin:pwd http://localhost:8090/authenticate
```

---

## 📂 Folder Structure
```
jwt-auth/
├── pom.xml
├── README.md
└── src/main/
    ├── java/com/cognizant/jwtauth/
    │   ├── JwtAuthApplication.java
    │   ├── config/SecurityConfig.java
    │   └── controller/AuthenticationController.java
    └── resources/application.properties
```

## 📌 Conclusion
This is the "issue the token" half of JWT auth — the server validates Basic credentials once and
hands back a signed, time-limited JWT the client can use going forward. Validating that JWT on
subsequent requests (a `JwtAuthorizationFilter`) is a later, **non-mandatory** hands-on and is not
included here.
