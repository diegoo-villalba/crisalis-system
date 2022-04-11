<h1>Crisalis System - Proyecto Bootcamp Finnegans</h1>


Esta aplicación web tiene como objetivo demostrar el uso de las herramientas vistas a lo largo del bootcamp, coordinadas e interactuando para brindar parte de la funcionalidad solicitada.

<h2>¿Cómo hacerlo funcionar?</h2>
<h5>Nota: La realización de este proyecto se realizó en el sistema operativo Windows 11 utilizando IDE Eclipse.</h5>

1. Descomprimir el proyecto en el workspace del IDE Eclipse.
2. Importar el archivo .sql de nombre "Tablas_SQL_Server" en SQL Server Management.
3. Abrir Eclipse y una vez dentro importar el proyecto al workspace.
4. Abrir el archivo "application.properties" e insertar el usuario y contraseña respectivo de su SQL Server Management
5. Luego, con la extension del IDE "Spring Tools 4" instalada, seleccionamos en la barra de herramientas superior el botón
"Boot dashboard", se nos abrirá una pestaña del dashboard con la direccion "local" donde debe de aparecer el proyecto
"crisalis-system". Seleccionamos "Start" y ya correrá el proyecto. 
6. Por defecto, el proyecto se levanta en el puerto 8080 por lo que si no se abre de forma automatica, debe de dirigirse a su navegador de preferencia y tipear lo siguiente en la barra de navegacion: "localhost:8080/home" (sin las comillas)


<h3>¿De que se trata?</h3>

1. La aplicacion es un sistema de gestión de pedidos que permite, valga la redundancia, gestionar pedidos de productos, servicios, items de venta en general asignando cada uno a un cliente en particular que debemos especificar y generando luego un detalle del pedido con los items seleccionados, precio, fecha, etc.-

<h3>¿Como hacerlo funcionar?</h3>
1. Ejecutar la class "CrisalisSystemApplication" ubicada en el paquete "com.sistema.crisalis"

2. Abrir el navegador de preferencia y copiar la siguiente direccion en la barra: "http://localhost:8080/home"

3. Una vez en el inicio de la página, puede navegar por las diferentes secciones: Servicios, Clientes, Productos y realizar el CRUD de los registros en c/u de ellas

4.Si desea gestionar un pedido para un cliente ya existente, se dirige a "Home" y allí al botón "Añadir Cliente" donde será redireccionado a una página para ingresar el ID del cliente por el cual va a gestionar el pedido.

5. Una vez ingresado el cliente, como se comentó previamente, puede ir agregando items al pedido del cliente navegando entre las secciones de Servicios y Productos.

6. Una vez finalizado el pedido, se dirige a la sección "Ver Pedido Actual" y seleccion el botón "Ver Orden" donde se lo redireccionará a una página con el detalle de su pedido.

7. Por último, selecciona el botón "Generar" y el pedido se habrá concretado, redireccionado a la página para ver el detalle del mismo si lo desea.

<h5 class="text-uppercase font-weight-bold">Autor</h5>
<ul>
	<li>Diego A. Villalba</li>
</ul>
