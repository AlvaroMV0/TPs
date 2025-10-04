package org.example.ConversorTemperatura;

public class MainConversorTemperatura {
    public static void main(String[] args) {
        System.out.println("\n--- Conversor de Temperatura ---  \n\n ");

        // Convertir de Celsius a Fahrenheit
        double temperaturaCelsius = 25.0;
        double resultadoFahrenheit = ConversorTemperatura.convertirAFahrenheit(temperaturaCelsius);
        System.out.println(temperaturaCelsius + "°C equivale a " + resultadoFahrenheit + "°F.");

        // Convertir de Fahrenheit a Celsius
        double temperaturaFahrenheit = 77.0;
        double resultadoCelsius = ConversorTemperatura.convertirACelsius(temperaturaFahrenheit);
        System.out.println(temperaturaFahrenheit + "°F equivale a " + resultadoCelsius + "°C.");
        System.out.println("\n\n ---------------------------------------");
    }
}