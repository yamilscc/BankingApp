# 🏦BankingApp - Proyecto de Portafolio
Esta es una **aplicación backend bancaria** desarrollada como proyecto de portafolio, utilizando las siguientes tecnologías:
- Spring Boot 3
- Spring Data JPA (Hibernate)
- MySQL DBMS
- RabbitMQ
- API RESTful

## 🧱 Arquitectura del proyecto
El proyecto está desarrollado siguiendo una **arquitectura de 4 capas**, lo que permite una clara separación de responsabilidades, mejor mantenimiento y escalabilidad. Las capas implementadas son:
1) Controller: maneja las solicitudes HTTP y delega la lógica.
2) Service: contiene la lógica de negocio.
3) Repository: gestiona el acceso a la base de datos utilizando Spring Data JPA.
4) Entity/Model: representa las entidades persistentes.

Además, se implementa el **patrón DTO (Data Transfer Object)** para transferir datos entre capas sin exponer directamente las entidades de la base de datos, mejorando la validación y transformación de datos.

## 🔗 Endpoints disponibles
La API RESTful cuenta con los siguientes 6 recursos/endpoints:
1) Crear cuenta bancaria
2) Obtener cuenta a través de su id
3) Depositar dinero en cuenta
4) Retirar dinero de la cuenta
5) Obtener todas las cuentas cargadas
6) Eliminar una cuenta

## 📬 Integración con RabbitMQ
Se incorporó un servicio de cola de mensajería mediante RabbitMQ para "simular" por consola el envío de un correo de bienvenida al usuario cuando crea una cuenta en la aplicación.


