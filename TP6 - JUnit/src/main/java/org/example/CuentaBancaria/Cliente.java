package org.example.CuentaBancaria;

public class Cliente {
    private int saldo;

    void retirarDinero(int monto){
        saldo -= monto;
    }

    void ingresarDinero(int monto){
        saldo += monto;
    }

    public int getSaldo() {
        return saldo;
    }

    public String saldoToString(){
        return (this.saldo+"$ (ARS)");
    }
}
