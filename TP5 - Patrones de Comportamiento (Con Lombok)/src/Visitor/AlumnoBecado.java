package Visitor;

class AlumnoBecado implements AlumnoElement {
    private String nombre;
    private double porcentajeBeca;
    public AlumnoBecado(String n, double p) {
        this.nombre = n;
        this.porcentajeBeca = p;
    }
    public String getNombre() { return nombre; }
    public double getPorcentajeBeca() { return porcentajeBeca; }
    @Override
    public void aceptar(Visitor v) { v.visitar(this); }
}