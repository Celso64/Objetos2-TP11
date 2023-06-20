# Objetos2-TP11
## Tema: Frameworks

## Como usar mi framework

Implementar la interfaz Accion por cada accion deseada, con un constructor vacio.

Poner la ruta de las clases que implementan Accion en un archivo de configuracion .properties o .json

Intanciar la clase Menu, inyectandole la ruta del archivo de configuracion por constructor.

## Ejemplos de archivo de Configuracion

### .properties

acciones: com.ar.accion1; com.ar.accion2

### .json

{

"acciones": ["com.ar.accion1", "com.ar.accion1"],

"max_threads: 1

}

## Sobre este Repo

### archivosJar

Contiene todas las versiones de mi framework

### Ejercicio 1 - Framework Codigo
Este proyecto contiene el codigo de la ultima version de mi framework.

### Ejercicio 2
Este proyecto contiene y usa el .jar de la version 1.0 de mi framework. La cual provee:
- Entrada y salida por terminal
- Soporta una sola accion a la vez
- Soporte de archivo de configuracion .properties

### Ejercicio 3
Este proyecto contiene y usa el .jar de la version 1.1 de mi framework. La cual trae los siguientes cambios:
- Se cambio la entrada y salida por terminal, por Lanterna.

### Ejercicio 4
Este proyecto contiene y usa el .jar de la version 1.2 de mi framework. La cual trae los siguientes cambios:
- Soporte de archivo de configuracion .json

### Ejercicio 5
Este proyecto contiene y usa el .jar de la version 1.3 de mi framework. La cual trae los siguientes cambios:
- Soporte para ejecucion concurrente de acciones (solo para archivos de configuracion .json)
- Correccion de Error: Antes habia que importar manualmente las dependencias de mi framework; ahora el pom.xml viene incluido.
