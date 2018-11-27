## Chapter 4: Developing Services (Sample03/Reading Configuration)

* Make sure ch04/sample02 is up and running.

* To build the project with Maven, use the following command from sample03 directory.

```javascript
:\> mvn clean install
```

* To spin up the microservice, run the following command from sample03 directory.

```javascript
:\> mvn spring-boot:run
```

* To test the configuration service with a cURL client, use the following command from a different command console. This will print the configuration related to sample01.

```javascript
:\> curl http://localhost:8080/order/11
```