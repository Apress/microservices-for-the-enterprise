
# Spring Boot - RESTful Service 

This sample from the [book](https://www.apress.com/us/book/9781484238578) demonstrates how you can build RESTful services with Spring Boot. 

## Run 
You can run the sample by executing `` mvn spring-boot:run`` command in your terminal.  


## Test 
You can test the RESTful service with the following HTTP requests. 

### Retrieve Order : HTTP GET

- Obtain the response in JSON format:   
``
curl -H "Accept:application/json" http://localhost:8080/order/100
``

- Obtain the response in XML format: 
``
curl -H "Accept:application/xml" http://localhost:8080/order/100
``


### Add Order : HTTP POST 

- Send JSON payload and obtain response in JSON format. 

``` 
curl -v -X POST -d \
'{ "id": "100500", "name": "XYZ", "description": "Sample order."}' \
"http://localhost:8080/order" -H "Content-Type:application/json" -H "Accept:application/json" 
```
- Send XML payload and obtain response in XML format. 

``` 
curl -v -X POST -d \
'<Order><id>101</id><name>iPhone10</name><description>iPhone10 from Apple.</description><amount>0.0</amount><customerInfo><customerId>1234</customerId><firstName>John</firstName><lastName>Doe</lastName><address>52, River Oaks, San Jose, CA 95133</address></customerInfo></Order>' \
"http://localhost:8080/order" -H "Content-Type:application/xml" -H "Accept:application/xml" 

```

