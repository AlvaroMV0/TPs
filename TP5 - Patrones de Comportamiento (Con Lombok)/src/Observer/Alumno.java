package Observer;

class Alumno implements Observer{
    private String nombre;

    public Alumno(String n){
        this.nombre=n;
    }
    @Override
    public void update(String msg){
        System.out.println("Alumno "+nombre+ " recibió notificación: "+msg);
    }
}
