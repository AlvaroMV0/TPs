package org.example;

import org.example.CuentaBancaria.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteTest {

    /**
     * <b>Verifica que el nombre del cliente no puede ser null</b>
     * <p>
     * {@link Cliente#nombre}
     * </p>
     *
     */

    @Test
    public void testInicializarClienteConNombreNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new Cliente(null));
        assertEquals("El nombre del cliente no puede ser null", exception.getMessage());
    }
}
