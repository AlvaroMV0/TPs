package org.example.CuentaBancaria;

public class MainCuentaBancaria {
    public static void main(String[] args) {
        System.out.println("\n--- Cuenta Bancaria --- \n\n ");

        // 1. Crear un cliente y su cuenta bancaria
        Cliente cliente = new Cliente("Alvaro");
        CuentaBancaria cuenta = new CuentaBancaria(cliente);

        System.out.println(cuenta.cuentaToString()+"\n\n");

        System.out.println("Ingresando 5000 ARS...");
        cuenta.ingresarDinero(5000);
        System.out.println(cuenta.saldoToString()+"\n");


        System.out.println("Retiramos 2000 ARS...");
        cuenta.retirarDinero(2000);
        System.out.println(cuenta.saldoToString()+"\n\n");


        try {
            System.out.println("Intentando retirar 4000 ARS (más que el saldo)...");
            cuenta.retirarDinero(4000);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR capturado: " + e.getMessage());
            System.out.println(cuenta.saldoToString()+"\n");
        }
        System.out.println("\n\n --------------------------------");
    }
}