📄 Descripción - Enunciado del ejercicio Este repositorio contiene los 3 niveles de la Tasca S1.03. Collections.

El ejercicio trata sobre Collections, sus estructuras de datos y sus clases, aplicados a una utilidad simulada en cada ejercicio.

## Enunciado:

### Nivel 1
- Ejercicio 1
Crea una clase llamada Month con un atributo "name" (que almacenará el nombre del mes del año). Añade 11 objetos Month (cada uno con su atributo diferente) en un ArrayList, a excepción del objeto con atributo "Agost". Después, efectúa la inserción en el sitio que corresponde a este mes y demuestra que ArrayList mantiene el orden correcto.

Convierte ArrayList del ejercicio anterior en un HashSet y asegúrate de que no permite duplicados.

Recorre la lista con un for y con un iterador.

- Ejercicio 2
Crea y rellena un List<Integer>.

Crea un segundo List<Integer> e inserta en la segunda lista los elementos de la primera en orden inverso.

Emplea los objetos ListIterator para leer los elementos de la primera lista e insertarlos en la segunda.

- Ejercicio 3
Dado el archivo countrties.txt (revisa el apartado recursos) que contiene países y capitales. El programa debe leer el archivo y guardar los datos en un HashMap<String, String>. El programa pide el nombre del usuario/a, y después debe mostrar un país de forma aleatoria, guardado en HashMap. Se trata de que el usuario debe escribir el nombre de la capital del país en cuestión. Si acierta se le suma un punto. Esta acción se repite 10 veces. Una vez solicitadas las capitales de 10 países de forma aleatoria, entonces debe guardarse en un fichero llamado classificacio.txt, el nombre del usuario y su puntuación.

### Nivel 2
- Ejercicio 1
Crea una clase llamada Restaurante con dos atributos: nombre(String) y puntuación(int). Implementa los métodos necesarios para que no se puedan introducir objetos Restaurante con el mismo nombre y puntuación en un HashSet creado en el main() de la aplicación.

 Importante

Puede haber restaurantes con el mismo nombre con distinta puntuación, pero no puede haber restaurantes con el mismo nombre y igual puntuación.

- Ejercicio 2
Utilizando la clase del programa anterior, crea la implementación necesaria para que los objetos de la clase Restaurante estén ordenados por nombre y por puntuación en orden descendente.

Ejemplo:

nombre: restaurant1, puntuación: 8

nombre: restaurant1, puntuación: 7

### Nivel 3
- Ejercicio 1
Crea una aplicación capaz de leer un archivo CSV. Este archivo tiene 3 campos: nombre, apellido y DNI, por cada registro. Se trata de ordenar a las personas leídas del fichero, mediante su nombre, apellido o DNI. Puedes utilizar la lista que creas más adecuada.

La clase Persona tiene 3 atributos:

nombre

apellido

DNI



La clase principal tiene el siguiente menú:

1.- Introducir persona.

2.- Mostrar a las personas ordenadas por nombre (A-Z).

3.- Mostrar a las personas ordenadas por nombre (Z-A).

4.- Mostrar a las personas ordenadas por apellidos (A-Z).

5.- Mostrar a las personas ordenadas por apellidos (Z-A).

6.- Mostrar a las personas ordenadas por DNI (1-9).

7.- Mostrar a las personas ordenadas por DNI (9-1).

0.- Salir.



El programa deberá listar a las personas como el siguiente ejemplo:

___Nombre___ ____ Apellidos___ __NIF__

Andreu Ballestero Llenas 34835767J

Miquel Bayona Font 48743957B

Guillem Capdevila Río 33957834J

Albert Carbonell Ferrer 77364986R

Ferran Casas Coderch 23047848P

Maria Casellas Fuste 47102244S

Genios Ciudad Vendrell 39718459N

💻 Tecnologías Utilizadas El proyecto ha sido desarrollado utilizando: Java 21 IntelliJ IDEA como entorno de desarrollo Git y GitHub para control de versiones.

📋 Requisitos Para ejecutar el proyecto es necesario contar con: JDK 21 instalado en el sistema Git instalado y configurado IntelliJ IDEA Conexión a internet para clonar el repositorio.

🛠️ Instalación 🔽 Clonar y abrir en IntelliJ IDEA Abrir IntelliJ IDEA. En la pantalla de inicio, seleccionar "Get from VCS" (Obtener desde el control de versiones). En la pestaña "Version Control", seleccionar Git. En el campo "URL", pegar el enlace del repositorio:

https://github.com/Jusep1983/S103_Java_Collections.git
Elegir la carpeta donde se guardará el proyecto y hacer clic en "Clone". Una vez clonado, IntelliJ IDEA detectará el proyecto y te pedirá que lo importes como un proyecto de Java. Configurar el JDK (si es necesario): Ir a File → Project Structure → Project y asegurarte de que está seleccionado JDK 21.

▶️ Ejecución Abrir la clase que contiene el método main(). Hacer clic en el botón Run o presionar Shift + F10. Si es necesario, IntelliJ IDEA pedirá sincronizar dependencias, acepta la opción.

🌐 Despliegue El proyecto está diseñado para ejecutarse en un entorno local, por lo que no se ha definido un proceso de despliegue en producción.

🤝 Contribuciones Si deseas contribuir al proyecto, puedes: Hacer un fork del repositorio. Crear una nueva rama para tus cambios. Enviar un pull request con una descripción detallada de tus modificaciones.

¡Gracias por tu interés en este proyecto! 🚀
