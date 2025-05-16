# BankingApp
Aplicación bancaria que utiliza las siguientes tecnologías: Spring Boot 3, Spring Data JPA (Hibernate), MySQL DBMS &amp; RabbitMQ. Este proyecto está desarrollado siguiendo una arquitectura en 4 capas para mantener una separación clara de responsabilidades y facilitar el mantenimiento y escalabilidad. Las capas son:
1) Controller
2) Service
3) Repository
4) Entity/Model 

Además, el proyecto utiliza el patrón DTO (Data Transfer Object) para definir objetos que se utilizan para la transferencia de datos entre las capas, evitando exponer directamente las entidades de la base de datos y facilitando la validación y transformación de datos.

La API que se diseñó cuenta con 6 recursos/endpoints:
1) Crear cuenta bancaria
2) Obtener cuenta a través de su id
3) Depositar dinero en cuenta
4) Retirar dinero de la cuenta
5) Obtener todas las cuentas cargadas
6) Eliminar una cuenta

Asimismo, se incorporó un servicio de cola de mensajería mediante RabbitMQ para "simular" por consola el envío de un correo de bienvenida al usuario cuando crea una cuenta en la aplicación.


