package main.builder;


import java.util.Objects;

// Cloneable para poder implementar deep clone en la clase prestamo
public class Usuario implements Cloneable {


    private final String nombre;
    private final String email;
    private final String domicilio;
    private final String fechaDeNacimiento;
    private final int telefono;

    Usuario(String nombre,String email, String domicilio, String fechaDeNacimiento, int telefono) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo.");
        this.email = Objects.requireNonNull(email, "El mail no puede ser nulo.");
        this.domicilio = domicilio;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
    }

    @Override
    public Usuario clone() throws CloneNotSupportedException {
        return (Usuario) super.clone();
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    public static class UsuarioBuilder {
        private String nombre;
        private String email;
        private String domicilio;
        private String fechaDeNacimiento;
        private int telefono;

        UsuarioBuilder() {
        }

        public UsuarioBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public UsuarioBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UsuarioBuilder domicilio(String domicilio) {
            this.domicilio = domicilio;
            return this;
        }

        public UsuarioBuilder fechaDeNacimiento(String fechaDeNacimiento) {
            this.fechaDeNacimiento = fechaDeNacimiento;
            return this;
        }

        public UsuarioBuilder telefono(int telefono) {
            this.telefono = telefono;
            return this;
        }

        public Usuario build() {
            return new Usuario(this.nombre, this.email, this.domicilio, this.fechaDeNacimiento, this.telefono);
        }


    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}