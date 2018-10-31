
# Spring Boot - RESTful Service 

This sample from the [book](https://www.apress.com/us/book/9781484238578) demonstrates how you can build RESTful services with Spring Boot. 

## Run 
You can run the sample by executing `` mvn spring-boot:run`` command in your terminal.  


## Test 
You can test the RESTful service with the following HTTP requests. 

### Retrieve Order : HTTP GET  
``
curl http://localhost:8080/order/100
``


### Add Order : HTTP POST 

``` 
curl -v -X POST -d \
'{ "id": "100500", "name": "XYZ", "description": "Sample order."}' \
"http://localhost:8080/order" -H "Content-Type:application/json"
```

