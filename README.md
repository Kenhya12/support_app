
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