# Hexagonal Architecture Example

## Project Description
The Hexagonal Architecture Example project is a simple demonstration of implementing the hexagonal architecture pattern within a Spring Boot application, utilizing R2DBC for reactive database access and WebFlux for reactive web endpoints.

## Overview
The project serves as a practical illustration of the Hexagonal Architecture pattern, also known as Ports and Adapters architecture, as described in the literature referenced by the project. This architectural style emphasizes the separation of concerns and the independence of the core application logic from external dependencies, such as databases, frameworks, and user interfaces.

## Key Features
- Hexagonal Architecture Implementation: The project showcases the organization of the application into distinct layers, including the domain/core logic, application services, and infrastructure adapters. This separation facilitates modularity and testability.
- Spring Boot Integration: Leveraging the Spring Boot framework, the project demonstrates how to integrate the hexagonal architecture pattern within a modern Java application development context. Spring Boot's auto-configuration and dependency injection capabilities are utilized for rapid development.
- Reactive Database Access with R2DBC: The project utilizes R2DBC, a reactive database connectivity library, to interact with the underlying database in a non-blocking, asynchronous manner. This enables efficient handling of database operations, particularly in high-concurrency scenarios.
- Reactive Web Endpoints with WebFlux: WebFlux, the reactive web framework provided by Spring WebFlux, is employed to expose reactive HTTP endpoints. This allows for handling a large number of concurrent requests with minimal resource consumption.

## Purpose
The primary purpose of the Hexagonal Architecture Example project is to serve as an educational resource for developers interested in understanding and implementing the hexagonal architecture pattern in Spring Boot applications. By following the project's codebase and accompanying documentation, developers can gain insights into how to design modular, maintainable, and testable applications that are resilient to changes in external dependencies.

## Notes
- In order to maintain the simplicity of the example I avoid few important things:
- Each request/response should use an independent Dto, in this case only 1 dto is used 
- Mappers should be used when transforming data between layers
- Validators should be used for each request

## References
The project draws heavily from existing literature and best practices related to hexagonal architecture, Spring Boot development, R2DBC usage, and reactive programming with WebFlux. The following are some of the key references utilized in developing the project:
- [Introducciòn a Arquitectura Hexagonal 1](https://www.youtube.com/watch?v=y3MWfPDmVqo)
- [Introducciòn a Arquitectura Hexagonal 2](https://www.youtube.com/watch?v=eNFAJbWCSww)
- [arquitectura-hexagonal-con-spring-boot-parte-1](https://medium.com/@oliveraluis11/arquitectura-hexagonal-con-spring-boot-parte-1-57b797eca69c)
- [arquitectura-hexagonal-con-spring-boot-parte-2](https://medium.com/@oliveraluis11/arquitectura-hexagonal-con-spring-boot-parte-2-bf5371d80d20)
- [arquitectura-hexagonal-con-spring-boot-parte-3](https://medium.com/@oliveraluis11/arquitectura-hexagonal-con-spring-boot-parte-3-60b4c3f4eaf7)
- [arquitectura-hexagonal-con-spring-boot-parte-4](https://medium.com/@oliveraluis11/arquitectura-hexagonal-con-spring-boot-parte-4-final-6d48876bdce1)
- [Spring Boot Project using Kafka and R2DBC (Part 1)](https://medium.com/javarevisited/spring-boot-project-using-kafka-and-r2bc-part-i-a460627d308c)
- [Spring Boot Project using Kafka and R2DBC (Part 2)](https://gasmartins.medium.com/spring-boot-project-using-kafka-and-r2bc-part-ii-967810ac4fb0)
- [Spring Boot Project using Kafka and R2DBC (Part 3)](https://gasmartins.medium.com/spring-boot-project-using-kafka-and-r2bc-part-iii-in-construction-b3a11422899)
- [Spring Boot Project using Kafka and R2DBC (Part 4)](https://gasmartins.medium.com/spring-boot-project-using-kafka-and-r2bc-part-iii-f19fccb409a8)
- [Spring Boot Project using Kafka and R2DBC (Part 5)](https://gasmartins.medium.com/spring-boot-project-using-kafka-and-r2bc-part-v-3bff5053a7a9)
- [Spring Boot Project using Kafka and R2DBC (Part 6)](https://gasmartins.medium.com/spring-boot-project-using-kafka-and-r2bc-part-vi-426477276072)

## Note
This project is intended for demonstration purposes only and may not encompass all aspects of a production-grade application. Developers are encouraged to adapt and extend the project according to their specific requirements and best practices.