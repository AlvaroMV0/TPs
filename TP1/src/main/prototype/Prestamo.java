package main.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.builder.Usuario;
import main.factory.Libro;

@Getter @Setter
@AllArgsConstructor


public class Prestamo implements Cloneable {
    private Libro libro;
    private Usuario usuario;
    private String fechaInicio;
    private String fechaFin;




    // Shallowcopy
    @Override
    public Prestamo clone() throws CloneNotSupportedException
    {
        return (Prestamo) super.clone();
    }

    //DeepCopy
    // En la clase Prestamo
    public Prestamo deepClone() throws CloneNotSupportedException {
        Prestamo cloned = (Prestamo) super.clone();
        cloned.setUsuario(this.usuario.clone());
        cloned.setLibro(this.libro.clone()); // <-- AÑADIR ESTA LÍNEA
        return cloned;
    }
}
