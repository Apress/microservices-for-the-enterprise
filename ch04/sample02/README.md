## Chapter 4: Developing Services (Sample02/ConfigServer)

* To build the project with Maven, use the following command from sample02 directory.

```javascript
:\> mvn clean install
```

* To spin up the microservice, run the following command from sample02 directory.

```javascript
:\> mvn spring-boot:run
```

* To test the configuration service with a cURL client, use the following command from a different command console. This will print the configuration related to sample01.

```javascript
:\> curl http://localhost:9000/sample01/default
```

* Look for ch04/sample03 to see how we can consume configuration published by the configuration service from a microservice.
