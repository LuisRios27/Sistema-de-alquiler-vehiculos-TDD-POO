# Agencia

**Mensaje (Constructor):** Agencia()
*Pre:*
- ...
*Post:*
- precio total es 0.

**Mensaje:** registrarVehiculo(Vehiculo vehiculo)
*Pre:*
- vehiculo no debe estar registrado anteriormente (VehiculoYaRegistradoAnteriormenteException)
*Post:*
- el vehiculo queda disponible para alquilar, no retorna nada.

**Mensaje:** agregarCliente()
*Pre:*
- ...
*Post:*
- Devuelve el numero de cliente agregado, agrega 1, luego 2, luego 3 ...

**Mensaje:** alquilar(int numeroCliente, Vehiculo vehiculo, int dias)
*Pre:*
- numero de cliente debe estar registrado (ClienteNoRegistradoException)
*Post:*
- El cliente tiene un alquiler más.

**Mensaje:** precioTotal()
*Pre:*
- ...
*Post:*
- Devuelve la suma de todos los alquileres de todos los clientes.

**Mensaje:** estaRegistrado(Vehiculo vehiculo)
*Pre:*
- ...
*Post:*
- devuelve `true` si ya existe, o `false` en caso contrario.

----------------------------------------------------------------
# Cliente

**Mensaje (Constructor):** Cliente(int numero)
*Pre:*
- numero > 0 (NumeroDeClienteInvalidoException)
*Post:*
- El cliente se crea con su numero de cliente ingresado por parametro.

**Mensaje:** alquila(Vehiculo unVehiculo, int dias)
*Pre:*
- ...
*Post:*
- agrega un alquiler al cliente

**Mensaje:** precioTotalAlquileres() 
*Pre:*
- ...
*Post:*
- Devuelve la suma de todos los precios de los alquileres de ese cliente.

**Mensaje:** tieneNumero(int numeroAComparar)
*Pre:*
- ...
*Post:*
- Devuelve `true` si el numero recibido es igual al numero de cliente con el que fue creado, caso contrario `false`.

----------------------------------------------------------------
# Alquiler

**Mensaje (Constructor):** Alquiler(Vehiculo vehiculo, int dias)
*Pre:*
- dias > 0 (CantidadDiasInvalidaException)
*Post:*
- Crea un nuevo alquiler con un vehículo y el alquiler de los dias asignados 

**Mensaje:** precio() 
*Pre:*
- ...
*Post:*
- Devuelve el valor del alquiler del vehiculo correspondiente

----------------------------------------------------------------
# Vehiculo (Abstract)

**Mensaje (Constructor):** Vehiculo(String patente) 
*Pre:*
- ...
*Post:*
- crea un vehiculo con su patente asignada.

**Mensaje (Abstract):** precio(int dias)
*Pre:*
- ...
*Post:*
- devuelve el precio correspodiente

**Mensaje:** tieneMismaPatente(Vehiculo vehiculoAComparar)
*Pre:*
- ...
*Post:*
- devuelve `true` si la patente del vehiculo recibido es igual a la propia, caso contrario es `false`.

----------------------------------------------------------------
## Coche (Hereda de Vehiculo)

**Mensaje (Constructor):** Coche(String patente, int plazas, Categoria categoria, boolean estaBlindado)
*Pre:*
- plazas > 0 (CantidadPlazasInvalidaException)
*Post:*
- Crea un coche con todos sus atributos

**Mensaje:** precio(int dias) 
*Pre:*
- ...
*Post:*
- devuelve el precio correspodiente segun la cantidad de dias y categoria, retorna el valor en decimal. si está blindado, el total es 1,15 veces el subtotal. la fórmula: `(500 + precioPlazas(plazas)) * dias`, y luego el `blindaje`.

----------------------------------------------------------------
## Microbus (Hereda de Vehiculo)

**Mensaje:** Microbus(String patente)
*Pre:*
- ...
*Post:*
- Crea un microbus

**Mensaje:** precio(int dias)
*Pre:*
- ...
*Post:*
- devuelve el precio correspodiente segun la cantidad de dias.

----------------------------------------------------------------
## Furgoneta (Hereda de Vehiculo)

**Mensaje:** Furgoneta(String patente, int pma) 
*Pre:*
- pma > 0 (PMAInvalidoException)
*Post:*
- crea una Furgoneta con PMA valido.

**Mensaje:** precio(int dias)
*Pre:*
- ...
*Post:*
- devuelve el precio correspodiente segun la cantidad de dias y su PMA de carga.

----------------------------------------------------------------
## Camion (Hereda de Vehiculo)

**Mensaje:** Camion(String patente) 
*Pre:*
- ...
*Post:*
- crea un Camion

**Mensaje:** precio(int dias)
*Pre:*
- ...
*Post:*
- devuelve el precio fijo sin importar los dias

----------------------------------------------------------------
# Categoria (Interface)
**Mensaje (Abstract):** precioPlazas(int plazas) 
*Pre:*
- ...
*Post:*
- devuelve el precio por día de las plazas

----------------------------------------------------------------
## Clasico (Implementa Categoria)

**Mensaje:** precioPlazas(int plazas)
*Pre:*
- ...
*Post:*
- devuelve el valor de las plazas por dia de coche Clasico

----------------------------------------------------------------
## Premium (Implementa Categoria)

**Mensaje:** precioPlazas(int plazas)
*Pre:*
- ...
*Post:*
- devuelve el valor de las plazas por dia de coche Premiun