# webflux-db-migration

- [reference](https://www.baeldung.com/liquibase-refactor-schema-of-java-app)

### rollback
```shell
mvn liquibase:rollback -Dliquibase.rollbackCount=1
liquibase rollback-count --count=1 --changelog-file=changelog.xml --url=jdbc:postgresql://localhost:5432/postgres --username=postgres --password=postgres
```