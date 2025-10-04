package org.example.ConversorTemperatura;

public class ConversorTemperatura {

    public static double convertirACelsius(double tempEnFahrenheit) {
        return (((tempEnFahrenheit - 32) * 5) / 9);
    }

    public static double convertirAFahrenheit(double tempEnCelsius) {
        return (tempEnCelsius * 9 / 5) + 32;
    }


}
