package org.example;

import org.example.ConversorTemperatura.ConversorTemperatura;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversorTemperaturaTest {

    @Test
    public void testConvertirCelsiusAFahrenheit() {
        assertEquals(89.6, ConversorTemperatura.convertirAFahrenheit(32.0), 0.01);
    }

    @Test
    public void testConvertirFahrenheitACelsius() {
        assertEquals(32.0, ConversorTemperatura.convertirACelsius(89.6), 0.01);
    }


}