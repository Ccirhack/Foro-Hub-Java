# Foro Hub

Foro Hub es una API REST creada con Spring Boot que incluye operaciones CRUD y utiliza un token para brindar permisos de seguridad a cada request.

## Descripción

El proyecto permite realizar diversas operaciones de un foro, como autenticar usuarios, registrar tópicos, actualizar y eliminar tópicos. La API se asegura utilizando tokens 
generados mediante login y contraseña.

## Menú de Opciones

- **Autenticación**
  - **Endpoint**: `/auth`
  - **Método**: `POST`
  - **Descripción**: Autentica al usuario y genera un token para su uso en solicitudes subsecuentes.
  - **Formato JSON**:
    ```json
    {
      "login": "usuario",
      "clave": "password"
    }
    ```

- **Registrar Tópico**
  - **Endpoint**: `/topicos`
  - **Método**: `POST`
  - **Descripción**: Registra un nuevo tópico.
  - **Formato JSON**:
    ```json
    {
	     "mensaje": "Error al ejecutar una requisición",
	     "nombreCurso": "HTTP en la web",
	     "titulo": "Error validación HTTP"
    }
    ```

- **Actualizar Tópico**
  - **Endpoint**: `/topicos`
  - **Método**: `PUT`
  - **Descripción**: Actualiza los campos de un tópico existente.
  - **Formato JSON**:
    ```json
    {
        "id": "id del tópico almacenado en la base de datos",
        "titulo": "Nuevo título del tópico",
        "mensaje": "Nuevo mensaje del tópico",
    	"nombreCurso": "Nuevo nombre del tópico",
    }
    ```
- **Listar Tópicos**
  - **Endpoint**: `/topicos`
  - **Método**: `GET`
  - **Descripción**: Muestra todos los tópicos registrados en la base de datos.
    
- **Eliminar Tópico**
  - **Endpoint**: `/topicos/{id}`
  - **Método**: `DELETE`
  - **Descripción**: Elimina un tópico por su ID.

## Tecnologías Utilizadas

- Java (versión 17 en adelante)
- Maven
- Spring Boot
- JAR format
- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security

## Instalación

1. Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/Ccirhack/LiterAlura---Challenge-Java.git
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd foro-hub
    ```

3. Configura tu base de datos MySQL y actualiza el archivo `application.properties` con tus credenciales de base de datos.

4. Compila y ejecuta el proyecto:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un issue primero para discutir los cambios que deseas realizar. Si deseas contribuir a este proyecto, por favor envía un pull request con una descripción clara de los cambios propuestos. Sería de gran ayuda saber en qué puedo mejorar y aprender.

## Contacto

Para cualquier pregunta o comentario, por favor contáctame a través de mi perfil de GitHub o por correo electrónico a yuan.retamozo.27@unsch.edu.pe.
