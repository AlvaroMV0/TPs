package main.prototype;

import main.builder.Usuario;
import main.factory.Libro;


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
    // En la clase Prestamo
    public Prestamo deepClone() throws CloneNotSupportedException {
        Prestamo cloned = (Prestamo) super.clone();
        cloned.setUsuario(this.usuario.clone());
        cloned.setLibro(this.libro.clone()); // <-- AÑADIR ESTA LÍNEA
        return cloned;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro +
                ", usuario=" + usuario +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }
}
