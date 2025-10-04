package org.example.CuentaBancaria;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public class CuentaBancaria {
    private final Cliente titular;
    private final int montoMinimoOperacional = 1500;
    private final String CVU;
    @Getter
    private int saldo;

    public CuentaBancaria(Cliente titular) {
        Objects.requireNonNull(titular, "El cliente no puede ser null");
        this.titular = titular;
        this.saldo = 0;
        this.CVU = generarCVU();
    }

    public void retirarDinero(int monto) {
        if (monto < montoMinimoOperacional) {
            throw new IllegalArgumentException("El monto a retirar no puede ser menor a " + montoMinimoOperacional + ".");
        }
        if (monto > saldo) {
            throw new IllegalArgumentException("El monto a retirar no puede ser mayor que el saldo");
        }


        saldo -= monto;
    }

    public void ingresarDinero(int monto) {
        if (monto < montoMinimoOperacional) {
            throw new IllegalArgumentException("El monto a ingresar no puede ser menor a " + montoMinimoOperacional + ".");
        }
        saldo += monto;

    }

    public String saldoToString() {
        return ("Saldo: " + this.saldo + "$ (ARS)");
    }

    public String cuentaToString() {
        return ("Titular: " + titular.getNombre() + "\n" +
                "CVU : " + this.CVU + "\n" +
                saldoToString());
    }

    private String generarCVU() {
        // Esto genera una cadena larga y única. La recortamos a 22 para simular un CVU. (Simula generar un CVU)
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").replaceAll("[a-zA-Z]", "0");
        return uuid.substring(0, 22);
    }

}
