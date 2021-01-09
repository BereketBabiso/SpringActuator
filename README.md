# SpringBootActuator
How to User Spring Boot Actuator in APIs.

Spring actuator provides production ready endpoints for monitoring applications. 

It provides simple monitoring capability like the health of the API or info about the API. 
It can also provide sensitive information about the application, like the resource usage, enviroment
variables etc.

Spring boot actuator dependency has to be included in the  application dependency in order to use the actuator
functionalities out of the box. One thing to keep in mind here is that for springboot application that are based on
2.x.x, the actuator exposes the health and info endpoints by defualt beanth the base path /actuator. In order to make of 
the other endpoints, we need to explicitly configure what we need in our application configuration. One way to do it is to 
list all the endpoints we want to expose in application.properties(yml) with the key management.endpoints.web.exposure.include=....

However, you need to be very careful while changing the default configurations of the actuator. The endpoints that are not exposed by default
are considered to expose sensetive information about your application and the environment where your application is running on. Hence, it is
wise to override the default configuration based on your requirement only after the security definition/configuration of your API is completed. 

This example demo address the issue of exposing sensetive data to unintended users by limiting access to the actuator endpoints to only authenticated/authorized users.
This can be seen in the config package where the spring security configration is done. Spring boot security starter dependency is added in order to secure the sensetive actuatir endpoints. 
