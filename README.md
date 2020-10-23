# tbk-prueba
Ejemplo de servicio restfull para tbk
Base de Datos MYSQL 

POST
http://localhost:81/api/personAdd

Body
{
    "nombre" : "Isabel",
    "apellido" : "Flores",
    "email" : "iflores@gmail.com"
}

GET
http://localhost:81/api/personGet/1

PUT
http://localhost:81/api/personUpdate/1

Body
{
    "nombre" : "Isabella",
    "apellido" : "Flores",
    "email" : "iflores@gmail.com"
}

GET
http://localhost:81/api/personGetAll

DELETE
http://localhost:81/api/personDelete/1
