# spring-microservices
Hands On for Spring Microservices.

#### How to run the project

1. Download  and run `zipkin-server-exec.jar` from [link](https://zipkin.io/pages/quickstart).
2. Start Service Registry, Cloud Config Server, Cloud Gateway, hystrix Dashboard, Department Service, User Service in given order.

#### Endpoints - 
1. Service Registry (Eureka Server) : `http://localhost:8761/eureka`
2. Config Server available on port `9296`
3. API Gateway (Cloud Gateway) : `http://localhost:8080`
4. Hystrix Dashboard : `htp://localhost:9295/hystrix`
5. Standalone Department Service available at `http://localhost:9001/departments` and `/departments` via API Gateway. 
5. Standalone User Service available at `http://localhost:9002/users` and `/users` via API Gateway. 

