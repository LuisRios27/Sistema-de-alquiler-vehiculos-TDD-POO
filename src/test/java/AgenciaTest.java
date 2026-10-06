import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class AgenciaTest {

    private Agencia unaAgencia; 

    @BeforeEach 
    public void setUp() {
        this.unaAgencia = new Agencia();
    }

    @Test
    @DisplayName("Una agencia es creada con un precio total de alquileres igual a 0 (cero).")
    public void test01AgenciaSeCreaConPrecioTotalIgualACero() {
        // Arrange & Act
        double precioTotalRetornado = unaAgencia.precioTotal();

        // Assert
        assertEquals(0.0, precioTotalRetornado);
    }

    @Test 
    @DisplayName("Al agregar el primer cliente, el metodo devuelve (1).")
    public void test02AgregarElPrimerClienteDevuelveUno() {
        // Arrange & Act
        int numeroDeClienteAgregado = unaAgencia.agregarCliente();
        
        // Assert
        assertEquals(1, numeroDeClienteAgregado);
    }

    @Test
    @DisplayName("Al agregar un segundo cliente, el metodo devuelve (2)")
    public void test03AgregarElSegundoClienteDevuelveDos() {
        // Arrange & Act
        unaAgencia.agregarCliente();
        int numeroDeClienteAgregado = unaAgencia.agregarCliente();
        
        // Assert
        assertEquals(2, numeroDeClienteAgregado);
    }

    @Test
    @DisplayName("Al registrar un vehiculo este queda disponible para alquilar")
    public void test04AgenciaRegistraUnVehiculoQueQuedaDisponibleParaAlquilar() {
        // Arrange
        Vehiculo primerVehiculo = new Camion("LMRH-2827");
        Vehiculo segundoVehiculo = new Camion("LMRH-2701");
        Vehiculo tercerVehiculo = new Camion("TLCP-2809");
        unaAgencia.registrarVehiculo(primerVehiculo);
        unaAgencia.registrarVehiculo(segundoVehiculo);
        unaAgencia.registrarVehiculo(tercerVehiculo);

        // Act & Assert
        assertEquals(true, unaAgencia.estaRegistrado(primerVehiculo));
        assertEquals(true, unaAgencia.estaRegistrado(segundoVehiculo));
        assertEquals(true, unaAgencia.estaRegistrado(tercerVehiculo));
    }
    
    @Test 
    @DisplayName("Si se intenta registrar un vehiculo con una patente ya registrada, se lanza la excepcion.")
    public void test05RegistrarVehiculoConPatenteYaRegistradaAnteriormenteLanzaExcepcion() {
        // Arrange
        Vehiculo unVehiculo = new Camion("LMRH-2827");
        Vehiculo otroVehiculo = new Camion("LMRH-2827");
        
        // Act
        unaAgencia.registrarVehiculo(unVehiculo);
        
        // Assert
        assertThrows(VehiculoYaRegistradoAnteriormenteException.class, () -> {
            unaAgencia.registrarVehiculo(otroVehiculo);
        });
    }

    @Test
    @DisplayName("Si se intenta alquilar para un numero de cliente no registrado, se lanza la excepcion.")
    public void test06AlquilarParaClienteNoRegistradoLanzaClienteNoRegistradoException() {
        // Arrange
        Vehiculo unVehiculo = new Camion("LMRH-2827");
        unaAgencia.registrarVehiculo(unVehiculo);

        // Act & Assert
        assertThrows(ClienteNoRegistradoException.class, () -> {
            unaAgencia.alquilar(1, unVehiculo, 3);
        });
    }

    @Test
    @DisplayName("Si un cliente alquila un camion por 3 dias, el precio total de la agencia es 30000.0")
    public void test07PrecioTotalDeAgenciaConUnAlquilerDeCamionEs30000() {
        // Arrange
        Vehiculo unCamion = new Camion("LMRH-2827");
        unaAgencia.registrarVehiculo(unCamion);
        int numeroDeCliente = unaAgencia.agregarCliente();

        // Act
        unaAgencia.alquilar(numeroDeCliente, unCamion, 3);

        // Assert
        assertEquals(30000.0, unaAgencia.precioTotal());
    }

    @Test
    @DisplayName("Si dos clientes alquilan un camion y un microbus por 3 dias, el precio total de la agencia es 35000.0")
    public void test08PrecioTotalDeAgenciaConAlquileresDeDosClientesEs35000() {
        // Arrange
        Vehiculo unCamion = new Camion("LMRH-2827");
        Vehiculo unMicrobus = new Microbus("TLCP-2809");
        unaAgencia.registrarVehiculo(unCamion);
        unaAgencia.registrarVehiculo(unMicrobus);
        int primerCliente = unaAgencia.agregarCliente();
        int segundoCliente = unaAgencia.agregarCliente();

        // Act
        unaAgencia.alquilar(primerCliente, unCamion, 3);
        unaAgencia.alquilar(segundoCliente, unMicrobus, 3);

        // Assert
        assertEquals(35000.0, unaAgencia.precioTotal());
    }

    @Test
    @DisplayName("Si se intenta alquilar un vehiculo no registrado, se lanza la excepcion.")
    public void test09AlquilarVehiculoNoRegistradoLanzaVehiculoNoRegistradoException() {
        // Arrange
        Vehiculo vehiculoSinRegistrar = new Camion("LMRH-2827");
        int numeroDeCliente = unaAgencia.agregarCliente();

        // Act & Assert
        assertThrows(VehiculoNoRegistradoException.class, () -> {
            unaAgencia.alquilar(numeroDeCliente, vehiculoSinRegistrar, 3);
        });
    }

}