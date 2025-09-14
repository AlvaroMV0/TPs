package main.builder;


import lombok.*;

@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Getter

// Cloneable para poder implementar deep clone en la clase prestamo
public class Usuario implements Cloneable {
    @NonNull
    private final String nombre;
    @NonNull
    private final String email;
    private final String domicilio;
    private final String fechaDeNacimiento;
    private final int telefono;


    @Override
    public Usuario clone() throws CloneNotSupportedException {
        return (Usuario) super.clone();
    }


}