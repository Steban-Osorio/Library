# library

[![gradle](https://img.shields.io/badge/gradle-v6.7-yellow.svg)](https://gradle.org/install/)
[![maven](https://img.shields.io/badge/maven-v3.6.X-red.svg)](https://maven.apache.org/)

## Prerequisites

You will need the following things properly installed on your computer.

* [Git](http://git-scm.com/)
* [intellij idea ](https://www.jetbrains.com/es-es/idea/)
* [mariadb](https://mariadb.org/)

## Installation

usaremos [intellij idea ]  para el desarrollo del programa,[mariadb] para complementar la base de datos 

* `git clone https://github.com/Steban-Osorio/Library.git` this repository
* change into the new directory `cd Library`

## Menu
tienda de alquiler de libros.
en donde se maneja las siguientes caracteristicas 
* Registro de clientes
* Autenticación de clientes (Login)
* Permitir que una vez el cliente ingrese pueda reservar un libro.
* Permitir que un administrador pueda agregar inventario a los libros 
* Permitir configurar las tarifas de alquiler (las tarifas de alquiler depende del libro)
* Permitir listar los libros, debe visualizarse nombre del libro, autor, categoría, cantidad
disponible, cantidad reservada.

## Aspectos funcionales.
* Cuando el cliente quiera realizar la reserva de un libro la aplicación debe solicitarle los
siguientes datos:
* Fecha de devolución
* Cantidad de libros (debe validar que la cantidad no supere la cantidad
disponible)
* Se debe mostrar la tarifa a pagar según los datos ingresados por el cliente.

* Debe existir una vista donde se desplieguen los libros disponibles para el cliente.
Desde esta lista el cliente eligiendo el libro puede ir a la pantalla de reserva.
* Debe existir una vista administrar que permita modificar el inventario de los libros.
* Debe existir una vista que permita agregar nuevos libros.
* Debe existir una vista que permita eliminar libros
* Debe existir una vista para administrar las tarifas.

Características de los usuarios:
## Administrador:
* Tendrá permisos de gestionar libros (crear, eliminar, modificar).
* Tendrá permisos de modificar y crear tarifas de alquiler.
* El administrador no se registra dentro de la aplicación
* Puede hacer login dentro de la aplicación.
## Cliente
* Tendrá permisos de ver los libros disponibles para alquiler.
* Tendrá permisos para reservar (alquilar) libros.

* uede hacer registro y login dentro de la aplicación.




