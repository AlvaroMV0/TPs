package main.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import main.builder.Usuario;
import main.factory.Libro;


@Getter
@Setter
@ToString

public class Prestamo implements Cloneable {
    private Libro libro;
    private Usuario usuario;
    private String fechaInicio;
    private String fechaFin;

    public Prestamo(Libro libro, Usuario usuario, String fechaInicio, String fechaFin) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Shallowcopy
    @Override
    public Prestamo clone() throws CloneNotSupportedException {
        return (Prestamo) super.clone();
    }

    //DeepCopy
    public Prestamo deepClone() throws CloneNotSupportedException {
        Prestamo cloned = (Prestamo) super.clone();
        cloned.setUsuario(this.usuario.clone());
        cloned.setLibro(this.libro.clone());
        return cloned;
    }
}
