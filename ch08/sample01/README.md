## Chapter 8: Deploying and Running Microservices (Sample01/Order Processing Microservice)

* Make sure Docker is up and running in your local machine.

* To build the Order Processing microservice, run the following Maven command from sample1 directory.

```javascript
:\> mvn clean install
```

* Run the following command from sample01 directory to build a Docker image from sample01 directory.

```javascript
:\> docker build -t sample01 .
```

* To spin up the microservice with the Docker container, run the following command from sample01 directory.

```javascript
:\> docker run -p 9000:9000 sample01
```

* To test the microservice with a cURL client, use the following command from a different command console.

```javascript
:\> curl http://localhost:9000/order/11
```

