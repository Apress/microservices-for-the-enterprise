## Chapter 4: Developing Services (Sample01/OrderProcessing Microservice)

* To build the project with Maven, use the following command from sample01 directory.

```javascript
:\> mvn clean install
```

* To spin up the microservice, run the following command from sample01 directory.

```javascript
:\> mvn spring-boot:run
```

* To test the microservice with a cURL client, use the following command from a different command console.

```javascript
:\> curl http://localhost:8080/order/11
```

Output:

```javascript
{"customer_id":"101021","order_id":"11","payment_method":{"card_type":"VISA","expiration":"01/22","name":"John Doe","billing_address":"201, 1st Street, San Jose, CA"},"items": [{"code":"101","qty":1},{"code":"103","qty":5}],"shipping_address":"201, 1st Street, San Jose, CA"}
```