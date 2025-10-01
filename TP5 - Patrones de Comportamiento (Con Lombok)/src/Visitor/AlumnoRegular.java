package Visitor;

class AlumnoRegular implements AlumnoElement {
    private String nombre;
    public AlumnoRegular(String n) { this.nombre = n; }
    public String getNombre() { return nombre; }
    @Override
    public void aceptar(Visitor v) { v.visitar(this); }
}