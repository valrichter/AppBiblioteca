# BibliotecAPP en Java - Richter Valentin

-- CREACIÓN DE UNA APLICACIÓN DE BIBLIOTECA --

Descripción de la actividad  
Los estudiantes deben crear una aplicación de biblioteca en Java que cumpla con los siguientes requisitos:

Requisitos Funcionales:
1. Gestión de Libros:
    - Los usuarios pueden agregar nuevos libros a la biblioteca.
    - Los usuarios pueden eliminar libros de la biblioteca.
2. Gestión de Usuarios:
    - Los usuarios pueden registrarse en el sistema.
    - Los usuarios pueden alquilar libros.
    - Los usuarios deben devolver los libros
4. Consultas y Búsquedas:
    - Los usuarios pueden buscar libros en la biblioteca por título, autor o género.
5. Informes y Estadísticas:
    - Los usuarios pueden generar informes o estadísticas sobre el uso de la biblioteca.

Requisitos Técnicos:
- Utilizar programación orientada a objetos para diseñar las clases y objetos necesarios.
- Implementar manejo de excepciones para situaciones como devoluciones fuera de plazo o búsqueda de libros inexistentes.
- Utilizar interfaces y clases abstractas para definir un sistema de notificación a los usuarios.
- Aplicar programación funcional y Streams para consultas y generación de informes o estadísticas simples.

Entregables  
Los estudiantes deben entregar los siguientes elementos:

- El código fuente de la aplicación Java.
- Un documento de texto, o Read.me, explicando la lógica utilizada para validar los datos y cómo se implementan las diferentes funcionalidades.
- Un informe detallado de cualquier problema que hayan enfrentado durante el desarrollo de la aplicación y cómo los resolvieron.

Criterios de evaluación  
Los proyectos de los estudiantes serán evaluados de acuerdo a los siguientes criterios:

- Funcionalidad: ¿La aplicación cumple con todos los requisitos funcionales especificados?
- Validación de Datos: ¿La aplicación valida correctamente los datos ingresados por el usuario?
- Estructura del Código: ¿El código está organizado de manera clara y utiliza las estructuras de control adecuadas?
- Documentación: ¿Los estudiantes proporcionan documentación clara sobre su código y cualquier problema resuelto?
- Creatividad: ¿Los estudiantes implementan funcionalidades adicionales o mejoras en la aplicación más allá de los requisitos mínimos?

***
## Diagrama basico de la relacion entre clases
![Biblioteca drawio(1)](https://github.com/valrichter/BibliotecAPP/assets/67121197/5a25e85f-f589-4a5c-a2df-6864ad1a2dca)



### Como correr el programa:
1. Descargar el repositorio
2. Abrir la carpeta del proyecto con el IDE de preferencia
3. Las CLI interactivas estan separadas por paquete y cada una cumple una funcion
    pedida por el trabajo: ```Model.ConsultasYBusquedas```, ```Model.GestionLibro```, ```Model.GestionUsuarios```, ```Model.InformesYEstadisticas```
4. Ejecutar cada archivo Main por separado para probar las distintas funcionalidades 
5. Si no anda aplicar la opcion de SDK que proporciona el IDE
6. Trabajo echo con Java 17

### 1. Gestión de Libros:
- Los usuarios pueden agregar nuevos libros a la biblioteca  
Cada usuario una vez registrado en la biblioteca puede acceder a agregar el
libro que desea mediaante su funcion ```agregarLibro()```

- Los usuarios pueden eliminar libros de la biblioteca:  
  Cada usuario una vez registrado en la biblioteca puede acceder a agregar el
  libro que desea mediaante su funcion ```eliminarLibro()```

Estas dos funciones si bien pertencen al usuario en ultima instacia terminan ejecutando
funciones pertenecientes a la biblioteca

### 2. Gestión de Usuarios:
- Los usuarios pueden registrarse en el sistema  
Como no habia definiciones claras el registro de usuario se hace de la
siguiente manera:
  1. El usuario se registra mediante la CLI interactiva
  2. El sistema crea un nuevo usuario
  3. El sistema llama a la funcion ```biblioteca.resgistrarUsuario()``` y
  registra al usuario  
    
  Si bien el usuario mismo no se registra el sistema lo hace automaticamente

- Los usuarios pueden alquilar libros  
El usuario alquila los libros mediante su funcion ```usuario.alquilarLibro()```
  
- Los usuarios deben devolver los libros  
  El usuario devuelve los libros mediante su funcion ```usuario.devolverLibro()```

### 3. Consultas y Búsquedas:
- Los usuarios pueden buscar libros en la biblioteca por título, autor o género  
  1. El usuario puede buscar los libro por un titulo mediante la funcion ```usuario.buscarPorTitulo()```
  2. El usuario puede buscar los libro por un autor mediante la funcion ```usuario.buscarPorAutor()```
  3. El usuario puede buscar los libro por un genero mediante la funcion ```usuario.buscarPorGenero()```

### 4. Informes y Estadísticas:
- Los usuarios pueden generar informes o estadísticas sobre el uso de la biblioteca  
  El usuario puede generar un informe mediante la funcion ```usuario.generarInformeDeBiblioteca()```

### Requisitos Técnicos:
- Utilizar programación orientada a objetos para diseñar las clases y objetos necesarios.
- Implementar manejo de excepciones para situaciones como devoluciones fuera de plazo o búsqueda de libros inexistentes.  
Implementadas en las funciones de ```usuario.buscarPorTitulo()```, ```usuario.buscarPorAutor()```, ```usuario.buscarPorGenero()```
- Utilizar interfaces y clases abstractas para definir un sistema de notificación a los usuarios.
Se aplico en uso de la nterfaz Notficable eb la clase Usuario, para que se le notifique cada vez que alquila un libro
- Aplicar programación funcional y Streams para consultas y generación de informes o estadísticas simples.  
Aplicado en todas las funciones que utiliza la funcion ```usuario.generarInformeDeBiblioteca()```

### Problema a destacar:
El problema mas dificil fue hacer el disenio y la relacion entre clases de
la aplicacion, ya que segun criterios agregaba o descartaba se modificaba
basante la arquitectura.  
Por ej: decidi usar un Set de Libros ya que asumi que los libros en esta
biblioteca eran todos unicos y no habia copias. Esto me permitio relacionar
el estado de 'alquiler' del libro con la misma clase Libro.  
En cambio si se definia que la biblioteca podria poseer copias de un libro
el atributo de 'alquiler' puesto en la clase Libro no tendria mucho sentido.

### EXTRAS:
- Se intento usar streams en todo momento exeptuando algunas operaciones
complejas como en la funcion ```autorMasAlquilado()```
- El Main.java fuera del paquete model ejecuta todas la funcionalidades
de manera secuencial pero no posee CLI interactiva
