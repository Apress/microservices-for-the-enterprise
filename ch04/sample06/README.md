## Chapter 4: Developing Services (Sample06/gRPC Client)

* Make sure the sample05 (gRPC service) is up and running.

* To build the project with Maven, use the following command from sample06 directory.

```javascript
:\> mvn package
```

* To spin up the microservice, run the following command from sample06 directory.

```javascript
:\> mvn spring-boot:run
```

* To test the end to end sample, use the following cURL command.

```javascript
:\> curl -v -H "Content-Type: application/json" -d '{"customer_id":"101021", "payment_method":{"card_type":"VISA","expiration":"01/22","name":"John Doe","billing_address":"201, 1st Street, San Jose, CA"},"items":[{"code":" 101","qty":1},{"code":"103","qty":5}],"shipping_address":"201, 1st Street, San Jose, CA"}' http://localhost:8080/order
```

