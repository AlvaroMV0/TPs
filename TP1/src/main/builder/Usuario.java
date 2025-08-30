package main.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@Builder
@ToString

// Cloneable para poder implementar deep clone en prestamo
public class Usuario implements Cloneable {
    @NonNull
    private String nombre, email;
    private String domicilio, fechaDeNacimiento;
    private int telefono;


    @Override
    public Usuario clone() throws CloneNotSupportedException {
        return (Usuario) super.clone();
    }
}