
## Spring Boot - Messaging with JMS

This sample demonstrate JMS message consuming and producing capabilities of Spring Boot. 


- The JMS producer and consumer uses Active MQ as the message broker. 
- You can download and start ActiveMQ with the default configuration. 
- Then run the sample with ```$ mvn spring-boot:run ```
- You should see the message getting published to the specified queue and then JMS consuer receives the same message. 
- You can also check the Active MQ admin console to check the queue and message status. 