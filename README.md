# READ ME

## 1. Ejecutar el programa y Tests Unitarios
### 1.1. Compilar y ejecutar tests unitarios
Abrir una terminal en la misma ruta que este fichero, y ejecutar el comando
`mvn clean install`. El proyecto contiene 76 tests unitarios, que se ejecutarán también como resultado del comando anterior.

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
