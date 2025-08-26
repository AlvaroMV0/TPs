package main.builder;

public class Usuario {
    private String nombre, email,domicilio, fechaDeNacimiento;
    private int telefono;


    @Override
    public String toString(){
        return ("Información de usuario: \n" +
                "Nombre: " +((this.nombre==null)? "Ninguno": this.nombre )+" \n" +
                "Email: " + ((this.email==null)? "Ninguno": this.email )+" \n" +
                "domicilio: " +((this.domicilio==null)? "Ninguno": this.domicilio )+" \n" +
                "fechaDeNacimiento: " +((this.fechaDeNacimiento==null)? "Ninguna": this.fechaDeNacimiento ));
    }


    // Builder
    public static class Builder {
        private String nombre, email,domicilio, fechaDeNacimiento;
        private int telefono;

        public Builder nombre(String nombre){this.nombre = nombre;return this;}
        public Builder email(String email){this.email = email;return this;}
        public Builder domicilio(String domicilio){this.domicilio = domicilio;return this;}
        public Builder fechaDeNacimiento(String fechaDeNacimiento){this.fechaDeNacimiento = fechaDeNacimiento;return this;}

        public Usuario build(){
            Usuario u = new Usuario();
            u.nombre=nombre;u.email=email;u.domicilio=domicilio;u.fechaDeNacimiento=fechaDeNacimiento;
            return u;
        }

    }
}
