## How to install

- Add `-s ./settings.xml` to the end of all Maven command to run/build/deploy.
  e.g. `mvn clean install -DskipTests -U -s ./settings.xml`

## How to run
```
mvn spring-boot:run
```
## Dependency check
```
mvn clean verify -DskipTests -U -s ./settings.xml
```