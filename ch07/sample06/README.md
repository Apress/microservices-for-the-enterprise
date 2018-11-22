
# Spring Boot - Circuit Breaker 

This example demonstrate the usage of Circuit Breaker pattern with Spring Boot and Hystrix. 

- Here we have two services, product-info and customer-api. The customer-api service calls 
product-info service using Spring-Boot REST Template. It also uses the circuit breaker as part of the invocation. 

- Run ```/product-info$ mvn spring-boot:run```
- Run ```/customer-api$ mvn spring-boot:run```
- Invoke customer API via ``` curl http://localhost:8080/customer/catalog```. 
- You can shutdown the product-info service and try the circuit breaker behavior. 


