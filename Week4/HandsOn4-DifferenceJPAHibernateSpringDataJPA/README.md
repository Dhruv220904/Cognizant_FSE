# Hands On 4 - Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)
- JSR 338 specification for persisting, reading, and managing data from Java objects.
- Does not contain a concrete implementation of the specification - it's a set of interfaces/annotations only.
- Hibernate is one of several implementations of JPA.

## Hibernate
- An ORM (Object-Relational Mapping) tool that implements the JPA specification.
- Provides its own `Session`, `SessionFactory`, and `Transaction` API in addition to the standard JPA API.

## Spring Data JPA
- Does not provide its own JPA implementation - it sits on top of a JPA provider (typically Hibernate).
- Removes boilerplate DAO code by generating repository implementations at runtime from interfaces
  such as `JpaRepository`.
- Manages transactions declaratively via `@Transactional`.

## Code comparison

**Hibernate (manual session/transaction handling):**
```java
public Integer addEmployee(Employee employee) {
    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;
    try {
        tx = session.beginTransaction();
        employeeID = (Integer) session.save(employee);
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }
    return employeeID;
}
```

**Spring Data JPA (repository + service, no manual session handling):**
```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```
```java
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```

## Summary

| | JPA | Hibernate | Spring Data JPA |
|---|---|---|---|
| What it is | Specification (interfaces/annotations) | ORM tool, a JPA implementation | Abstraction layer over a JPA provider |
| Provides implementation? | No | Yes | No (delegates to Hibernate/other provider) |
| Boilerplate | N/A | Session/Transaction management required | Eliminated via repository interfaces |
| Transaction management | Manual (`begin`/`commit`/`rollback`) | Manual (`begin`/`commit`/`rollback`) | Declarative (`@Transactional`) |

## References
- https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1
- https://www.javaworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
