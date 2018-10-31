
## Apache Camel and Spring Boot


- Run service 
``` mvn spring-boot:run```

- Invoke service 

```curl -X POST -d '{"id": 1,"name": "World"}' -H "Content-Type: application/json" http://localhost:8080/camel/api/bean ```