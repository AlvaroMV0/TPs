package org.example;

import org.example.CuentaBancaria.Cliente;
import org.example.CuentaBancaria.CuentaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("JavadocReference")
public class CuentaBancariaTest {
    Cliente alvaro;
    CuentaBancaria alvaroCuentaBancaria;

    @BeforeEach
    public void setUpTests() {
        this.alvaro = new Cliente("Alvaro");
        this.alvaroCuentaBancaria = new CuentaBancaria(alvaro);
    }


    /**
     * <b>Tests relacionados con MontoMinimoOperacional: </b><br>
     * <p>
     * {@link CuentaBancaria#montoMinimoOperacional}
     * </p>
     */

    @Test
    public void testRetirarMenosDelMontoMinimoOperacional() {
        alvaroCuentaBancaria.ingresarDinero(4000);
        assertThrows(IllegalArgumentException.class, () -> alvaroCuentaBancaria.retirarDinero(50));
    }

    @Test
    public void testIngresarMenosDelMontoMinimoOperacional() {
        assertThrows(IllegalArgumentException.class, () -> alvaroCuentaBancaria.ingresarDinero(50));
    }


    /**
     * <b>Verifica que se lanza una excepción al intentar retirar más dinero del que posee la cuenta.</b>
     * <p>
     * Saldo inicial en la cuenta: 4000
     * Intento de retiro: 5000
     * </p>
     */
    @Test
    public void testRetirarMasDelSaldo() {
        alvaroCuentaBancaria.ingresarDinero(4000);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> alvaroCuentaBancaria.retirarDinero(5000));
        assertEquals("El monto a retirar no puede ser mayor que el saldo", exception.getMessage());
    }


    /**
     * <b>Verifica que el cliente no puede ser null</b>
     * <p>
     * {@link CuentaBancaria#titular}
     * </p>
     *
     */

    @Test
    public void testInicializarCuentaBancariaConClienteNull() {

        NullPointerException exception = assertThrows(NullPointerException.class, () -> new CuentaBancaria(null));
        assertEquals("El cliente no puede ser null", exception.getMessage());
    }


    /**
     * <b>Verifica que las operaciones funcionen correctamente</b>
     */

    @Test
    public void testOperacionValidaFuncionaCorrectamente() {
        alvaroCuentaBancaria.ingresarDinero(5000);
        assertDoesNotThrow(() -> {
            alvaroCuentaBancaria.retirarDinero(2000);
        });
        assertEquals(3000, alvaroCuentaBancaria.getSaldo());
    }

}
