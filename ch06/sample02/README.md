

# Service Discovery with Eureka and Spring Boot.  

## Eureka Service Registry

- `` eureka-service-registry-application`` contains the service registry implementation for this use case. 
- This spring boot application leverage Spring Cloud’s  ``@EnableEurekaServer`` annotation. This is a Spring Boot application with one annotation added to enable the service registry.
- You can run this applicaiton with `` mvn spring-boot:run`` inside the application directory. 

## Registering services 

- You can connect to Eureka service registry and register any Spring Boot application with it. 
- `` eureka-service-registration`` application registers with Eureka Service Registry. 
- `` @EnableDiscoveryClient`` annotation that we have at the Spring Boot application makes sure that the appliction is registered with the Eureka Registry. The name of the application is 
picked from `` spring.application.name`` property in `` bootstrap.properties`` file (here we use ``hello-service`` as the name of the service). 
- The details of the Eureka server that you connect with is configured in `` resources/application.yml `` with the following configuration.

    ```
    eureka:
    client:
        serviceUrl:
        defaultZone: http://localhost:8762/eureka/ 

    ```


- You can run this applicaiton with `` mvn spring-boot:run`` inside the application directory. 

## Discovering services 
- You can discover the service information by querying the service registry. `` eureka-service-discovery`` application queries the 
service registry by using the Spring Cloud `` DiscoveryClient `` abstraction to interrogate the registry for service's host and port. 
- You can run this applicaiton with `` mvn spring-boot:run`` inside the application directory. 

## Invoking discover service

- You can invoke the service which can discover service information, by sending a HTTP Get request to `` curl http://localhost:9090/service-instances/hello-service
``
- This service will return the service metadata of the requested service which is retrieved from the Eureka service registry. 
``` 
[{"host":"kasuns-mbp.attlocal.net","port":8080,"metadata":{"management.port":"8080"},"uri":"http://kasuns-mbp.attlocal.net:8080","secure":false,"instanceInfo":{"instanceId":"kasuns-mbp.attlocal.net:hello-service","app":"HELLO-SERVICE","appGroupName":null,"ipAddr":"192.168.1.66","sid":"na","homePageUrl":"http://kasuns-mbp.attlocal.net:8080/","statusPageUrl":"http://kasuns-mbp.attlocal.net:8080/actuator/info","healthCheckUrl":"http://kasuns-mbp.attlocal.net:8080/actuator/health","secureHealthCheckUrl":null,"vipAddress":"hello-service","secureVipAddress":"hello-service","countryId":1,"dataCenterInfo":{"@class":"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo","name":"MyOwn"},"hostName":"kasuns-mbp.attlocal.net","status":"UP","overriddenStatus":"UNKNOWN","leaseInfo":{"renewalIntervalInSecs":30,"durationInSecs":90,"registrationTimestamp":1536765850663,"lastRenewalTimestamp":1536765850663,"evictionTimestamp":0,"serviceUpTimestamp":1536765850039},"isCoordinatingDiscoveryServer":false,"metadata":{"management.port":"8080"},"lastUpdatedTimestamp":1536765850663,"lastDirtyTimestamp":1536765849860,"actionType":"ADDED","asgName":null},"serviceId":"HELLO-SERVICE","scheme":null}][
```

- Now you can try invoking the service endpoint of the service that you retrieved from the discovering service. 

```  curl http://localhost:9090/service-instances/hello-service ```



