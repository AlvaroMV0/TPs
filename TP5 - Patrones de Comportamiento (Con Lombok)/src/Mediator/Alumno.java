package Mediator;

class Alumno extends Usuario{
    public Alumno(ChatMediator m, String n){super(m,n);}
    @Override

    public void enviar(String mensaje){
        System.out.println("Alumno "+nombre +" envía: "+mensaje);
        mediator.enviar(mensaje, this);
    }
    @Override
    public void recibir(String mensaje){
        System.out.println("Alumno "+nombre+ " recibe: "+mensaje);
    }
}