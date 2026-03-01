# App SpeedFast con Base de Datos - ES3 DOO II

## Autor del Proyecto
- **Nombre:** Javier Flores Soriano
- **Sección:** 003A
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## Descripción del Proyecto
Aplicación Java orientada a objetos que simula la creación de distintos tipos de Pedidos (Comida, Encomienda y Express), Clientes y Entregas.

El Proyecto fue desarrollado aplicando principios de POO, Interfaces, Swing y conexión a Base de Datos.

## Funcionalidades Principales
- Creación de pedidos (Comida, Encomienda y Express).
- Creación de clientes.
- Asignación de repartidor.
- Iniciación y finalización de entregas.

🛠️ Tecnologías utilizadas

- Java Maven.
- POO.
- Colecciones.
- Interfaces.
- Swing.
- Conexión a BD mySQL.


## 📂 Estructura del proyecto

```plaintext
java.duoc
    ├── conexion
    │     └── ConexionBD.java
    ├── controlador
    │     ├── ControladorCliente.java
    │     ├── ControladorEntrega.java
    │     └── ControladorPedido.java     
    ├── dao
    │    ├── ClienteDAO.java
    │    ├── EntregaDAO.java
    │    └── PedidoDAO.java
    ├── modelo
    │    ├── Cliente.java
    │    ├── Entrega.java
    │    ├── Pedido.java
    │    └── Repartidor.java
    ├── util
    │    ├── EstadoPedido.java
    │    ├── InterfazActualizar.java
    │    ├── InterfazCRUD.java
    │    └── TipoPedido.java
    ├── vista 
    │    ├── VistaEntrega.java
    │    ├── VistaListaClientes.java 
    │    ├── VistaListaPedidos.java 
    │    ├── VistaLogin.java
    │    ├── VistaMainMenu.java
    │    └── VistaRegistro.java
    └── Main.java

````
### **Conexion**

Contiene el método para conectar a la base de datos de mySQL.

### **Controlador**

Clases que se encargan de ser intermediarios entre las clases DAO y la vista.

### **DAO**

Clases que contiene los métodos para realizar el CRUD en la base de datos.

### **Modelo**

Clases bases para crear/cargas objetos de la base de datos.

### **Util**

Contiene ENUM para crear objetos e interfaces para aplicar CRUD.

### **Vista**

Clases con Java Swing para el GUI entre aplicación y base de datos.

### **Main**

Clase ejecutable para correr programa.

## Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:
   
```bash
git clone https://github.com/FloresEng/SpeedFast_DB.git
```
2. Abre el proyecto en IntelliJ IDEA.

3. Verifica que los archivos `.txt` estén correctamente ubicados.

4. Ejecuta el archivo `Main.java` desde el paquete `app`.

5. Sigue las instrucciones en consola.


---

**Repositorio GitHub:** \[ https://github.com/FloresEng/SpeedFast_DB.git ]
**Fecha de entrega:** \[28/02/2026]
