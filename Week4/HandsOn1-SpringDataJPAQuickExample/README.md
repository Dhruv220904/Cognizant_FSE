# Hands On 1 - Spring Data JPA Quick Example

## Steps
1. Create MySQL schema `ormlearn` and run `db/schema.sql` then `db/data.sql`.
2. Build the project:
   mvn clean package
3. Run `OrmLearnApplication` - it prints the list of countries retrieved via Spring Data JPA.

## What this demonstrates
- `Country` - `@Entity` mapped to the `country` table
- `CountryRepository` - `JpaRepository<Country, String>`, no boilerplate DAO code needed
- `CountryService` - `@Transactional` service calling `countryRepository.findAll()`
- `OrmLearnApplication` - loads the Spring context, fetches `CountryService` bean, and logs all countries
