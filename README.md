# READ ME

## 1. Ejecutar el programa y Tests Unitarios
### 1.1. Compilar y ejecutar tests unitarios
Abrir una terminal en la misma ruta que este fichero, y ejecutar el comando
`mvn clean install`. El proyecto contiene 76 tests unitarios, que se ejecutarán también como resultado del comando anterior.

NOTA: Puede consultar el coverage de los test accediendo al fichero /Coverage/index.html

### 1.2. Ejecutar el programa
A continuación, vamos a levantar el servidor en el puerto 8080 mediante el siguiente comando:
`mvn spring-boot:run`.

### 1.3. Acceder a la base de datos H2
El servidor usa una base H2, la cual es accesible desde la ruta `localhost:8080/h2-console`. 
Para llevar a cabo la conexión, deben de estar presentes estos parámetros:
  - JDBC URL --> jdbc:h2:mem:testdb
  - User name --> sa
  - Password --> (se debe dejar en blanco, no hay contraseña)

Una vez conectados, podemos hacer queries para comprobar el estado de las tablas en cualquier momento.


### 1.4. Test E2E con Colección de Postman
Se ha creado una colección de Postman (se puede encontrar en este mismo directorio, en [INDITEX.postman_collection.json](INDITEX.postman_collection.json)). Esta colección debe importarse en Postman, y contiene 7 casuísticas:

- Las 5 casuísticas pedidas en el enunciado
- Un bad case de NOT FOUND  donde no se encuentra ninguna entrada de base de datos con esos datos de entrada
- Un bad case de BAD REQUEST donde la fecha no cumple con el formato esperado. Por favor, siéntase libre de experimentar con los formatos de los 3 datos de entrada para ver como se comporta el servidor delante de dichos formatos.

### 1.5. SwaggerUI
El proyecto ha sido configurado para usar SwaggerUI, siendo accesible en `http://localhost:8080/swagger-ui/index.html`. También siéntase libre de usar esta UI para experimentar con diferentes requests y ver el comportamiento del servidor.

### 1.6. Docker
También se ha creado un Dockerfile (vea [Dockerfile](Dockerfile)), para que el usuario pueda ejecutar la aplicación como un serivicio contenedorizado. 

Situése en este mismo directorio y ejecute `docker build -t inditex:v1 .` para crear la imagen de Docker. Para crear un contenedor donde se ejecutará esta imagen, usar el siguiente comando `docker run -p 8080:8080 inditex:v1`

# 2. Especificaciones de Arquitectura
- La aplicación ha sido desarrollada con Arquitectura Hexagonal y DDD, procurando seguir las mejores prácticas de clean code y SOLID.
- La estructura de ficheros marca claramente la separación entre las capas de Infraestructura, Aplicación y Dominio. La capa de infraestructura contiene el Controller (junto con su Advice), el repositorio de JPA y la configuración de SwaggerUI. La capa de aplicación contiene, entre otras cosas, un solo caso de uso que orquesta a servicios de dominio (en este caso solo 1) y los modelos de datos que entran y salen de Infraestructura, de tal manera que no están vinculados a Dominio. Finalmente, la capa de Dominio contiene servicios de dominio, junto a Entidades y ValueObjects. Estos últimos contienen una serie de validaciones a corde con la lógica de dominio, y suponen la capa de protección para que no entren datos indeseables a la capa más interna de la aplicación.
- Se ha delegado al máximo la responsabilidad sobre la query de búsqueda de base de datos a la capa de infraestructura y, por lo tanto, a la query SQL del repositorio de JPA. De esta manera aumentamos el rendimiento y velocidad.


# INDITEX Product Pricing API Documentation

Esta API permite obtener el precio aplicable de un producto en un momento dado, basado en su identificador, la marca, y la fecha solicitada.

---

## Endpoint

### `POST /inditex/products/price`

**Descripción**: Calcula el precio aplicable para un producto en función de la fecha, el identificador del producto y la marca.

#### Request Body
El cuerpo de la solicitud debe incluir los siguientes datos en formato JSON:

| Campo        | Tipo   | Descripción                                 | Ejemplo                 |
|--------------|--------|---------------------------------------------|-------------------------|
| `date`       | string | Fecha para la que se solicita el precio | `2020-06-14T16:00:00`|
| `productId`  | int    | Identificador único del producto.           | `35455`                 |
| `brandId`    | int    | Identificador único de la marca.            | `1`                     |

#### Ejemplo de Solicitud
```json
{
  "date": "2020-06-14T16:00:00",
  "productId": 35455,
  "brandId": 1
}

```
#### Response Body

El cuerpo de la respuesta del servidor incluye estos campos:

| Campo         | Tipo    | Descripción                                     | Ejemplo                 |
|---------------|---------|-------------------------------------------------|-------------------------|
| `productId`   | int     | Identificador único del producto.               | `35455`                 |
| `brandId`     | int     | Identificador único de la marca.                | `1`                     |
| `rateId`      | int     | Identificador de la tarifa aplicable.           | `1`                     |
| `startDate`   | string  | Fecha de inicio de validez de la tarifa.         | `2023-12-01T00:00:00`   |
| `endDate`     | string  | Fecha de fin de validez de la tarifa.            | `2023-12-31T23:59:59`   |
| `price`       | number  | Precio calculado del producto.                  | `35.50`                 |

#### Mapeo de Excepciones
La API contempla las siguientes excepciones

| Código HTTP | Mensaje            | Mensaje detallado                                                                                                                                                  | Descripción                                                                                                             |
|-------------|--------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| `404`       | Not found          | `{"statusCode": "404", "message": "Not found", "detailedMessage": "No price was found for product with ID: 35456 for brand with ID: 1 on date: 2020-06-14T10:00"}` | No se encontró un precio en la base de datos para los parámetros proporcionados.                                        |
| `400`       | Invalid parameter  | `{"statusCode": "400", "message": "Invalid parameter", "detailedMessage": "RequestedDate format is invalid. 30220-06-14 10:005:00 does not comply with  regex."}`  | El formato de la fecha proporcionada es inválido.                                                                       |
| `400`       | Invalid parameter  | `{"statusCode": "400", "message": "Invalid parameter", "detailedMessage": "ProductId must not be a negative value"}`                                               | El ID del producto debe ser un valor positivo.                                                                          |
| `400`       | Invalid parameter  | `{"statusCode": "400", "message": "Invalid parameter", "detailedMessage": "BrandId must not be a negative value"}`                                                 | El ID de la marca debe ser un valor positivo.                                                                           |
