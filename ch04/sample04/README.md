## Chapter 4: Developing Services (Sample04/Inter-service Communication)

* Make sure ch04/sample01 is up and running.

* To build the project with Maven, use the following command from sample04 directory.

```javascript
:\> mvn clean install
```

* To spin up the microservice, run the following command from sample04 directory.

```javascript
:\> mvn spring-boot:run
```

* To test the configuration service with a cURL client, use the following command from a different command console. This will print the configuration related to sample04.

```javascript
:\> curl -v -H "Content-Type: application/json" -d '{"customer_id":"101021","payment_method":{"card_type":"VISA","expiration": "01/22","name":"John Doe","billing_address":"201, 1st Street, San Jose, CA"}, "items":[{"code":"101","qty":1},{"code":"103","qty":5}],"shipping_address": "201, 1st Street, San Jose, CA"}' http://localhost:8080/order
```