
Apertura: lunes, 25 de agosto de 2025, 08:30
Cierre: viernes, 5 de septiembre de 2025, 15:30
Situación:
Una startup nos ha solicitado la construcción de una API para que sea consumida por su aplicación web así como su app mobil. La API deberá ser capaz de registrar las solicitudes de los empleados para que puedan solicitar un soporte técnico a su departamento informático en caso de necesidad. No será necesario identificar mediante un módulo de seguridad a los usuarios.

Requisitos:

    La solicitud contendrá los siguientes datos: nombre del solicitante, fecha de la solicitud, tema de la consulta, descripción
    El Frontend necesitará solicitar la lista de los temas de consulta seleccionable (lista preestablecida en base de datos)
    El departamento técnico debe poder solicitar todas la solicitudes en orden de creación (ASC)
    El departamento técnico debe saber si una solicitud está pendiente de asistencia
    El departamento técnico debe poder marcar una solicitud como atendida y quién la atendió (Con el nombre es suficiente) 
    El departamento técnico debe poder saber cuando se efectuó la asistencia
    El departamento técnico debe poder editar una solicitud ya registrada
    Si una solicitud es editada se deberá saber la fecha y la hora de la edición
    El departamento técnico debe poder eliminar una solicitud, siempre y cuando esta haya sido marcada previamente como atendida
    Cobertura de tests unitarios del 70%

    Tecnologías a utilizar:

    Java 21 SE
    Spring & Spring Boot
    Spring Data JPA
    Base de datos: MySQL o H2

Entregables:

    Repositorio de GitHub
    Enlace pública a la presentación realizada
    Captura de pantalla del diagrama UML o enlace pública del archivo de diagrams.net
    Captura de pantalla de la sección "Testing" de visual studio code donde se aprecia el coverage de los test

Criterios de Evaluación:

    Gestión del proyecto (JIRA) (20p)
    Aplicación documentada con Postman, Swagger y sus diagramas (Diagrama de base de datos, Diagramas de clases) (20p)
    La API deberá cumplir con los requisitos (30p)
    Modelos, Servicios y Controladores testeados (30p)

Enlaces de interés:

    Diagrama de clases
    Diagramas de bases de datos (ER de Chen y de patas de gallo - ver video)
    Test a Spring Boot REST Controller
    Spring Boot 3 with JUnit 5