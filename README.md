# Arquitectura Hexagonal "Microservicio de Gestión de Pedidos (Order Engine)"

Este proyecto no se trata solo de implementar capas, sino de demostrar el desacoplamiento absoluto del dominio de la lógica de negocio de los frameworks e infraestructuras externas. El concepto de Inditex va más allá de tener @Entity en el dominio; se centra en la mantenibilidad a largo plazo y la capacidad de cambiar tecnologías con impacto mínimo.

* __Título del Proyecto:__ Order Engine - A Hexagonal Architecture Implementation.

* __Objetivo Principal:__ Implementar el núcleo de un sistema de procesamiento de pedidos de un e-commerce, donde el dominio (Order, OrderLine, etc.) sea completamente agnóstico a cómo se persiste o se expone.

* __Características Clave:__

    1. __Núcleo de Dominio Puro (domain):__

        * Entidades de dominio (Order, OrderLine, CustomerId, ProductId) que son simples POJOs. Sin anotaciones de JPA (@Entity, @Id).

        * Interfaces de repositorio en el mismo paquete de dominio (OrderRepository, OrderFinder). Estos puertos definen qué se necesita, no cómo.

        * Servicios de dominio que contienen la lógica de negocio (validar stock, calcular totales, cambiar estados del pedido: CREATED, PAID, SHIPPED).

    1. __Puertos de Aplicación (application):__

        * Servicios de aplicación (Casos de Uso) que orquestan el flujo: CreateOrderUseCase, PayOrderUseCase. Serán los que inyecten los puertos (interfaces).

    1. __Adaptadores de Infraestructura (infrastructure):__

        * Adaptador de Persistencia JPA: Clases OrderEntity (con anotaciones JPA) y un JpaOrderRepositoryAdapter que implementa la interfaz OrderRepository del dominio. Aquí se traduce la entidad de dominio a entidad JPA y viceversa. Demuestras el uso de Spring Data JPA, pero totalmente aislado.

        * Adaptador de Persistencia en Memoria (para tests): Un InMemoryOrderRepositoryAdapter que implementa la misma interfaz. Esto muestra la potencia de la arquitectura para testing.

        * Adaptador Web (Controlador REST): Un OrderRestController que es un simple adaptador que recibe DTOs, los mapea a comandos del caso de uso, y devuelve DTOs de respuesta. Sin lógica de negocio aquí.

    1. __Configuración:__ Uso de @Configuration para inyectar el adaptador correcto (JPA o In-Memory) en la interfaz del dominio.

* __Tecnologías a Demostrar:__ Spring Boot, Java 21+, JUnit 5 (tests de unidad puros en el dominio y tests de integración para los adaptadores), Mockito.

* __Diferencial:__ El valor no está en la funcionalidad, sino en la estructura del código. Un Order del dominio no sabe nada de bases de datos. Puedes cambiar de H2 a PostgreSQL, o incluso a una base de datos NoSQL, modificando solo el adaptador de infraestructura, sin tocar el núcleo de la aplicación.

