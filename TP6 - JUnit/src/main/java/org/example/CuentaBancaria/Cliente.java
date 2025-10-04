package org.example.CuentaBancaria;

import lombok.Getter;

import java.util.Objects;


public class Cliente {
    @Getter
    private final String nombre;

    public Cliente(String nombre) {
        Objects.requireNonNull(nombre, "El nombre del cliente no puede ser null");
        this.nombre = nombre;
    }
}
