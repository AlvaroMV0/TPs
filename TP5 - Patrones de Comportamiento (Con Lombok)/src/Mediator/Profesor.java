package Mediator;

class Profesor extends Usuario {
    public Profesor(ChatMediator m, String n){super(m,n);}
    @Override
    public void enviar(String mensaje){
        System.out.println("Profesor "+nombre+ " envía: "+mensaje);
        mediator.enviar(mensaje,this);
    }
    @Override
    public void recibir(String mensaje){
        System.out.println("Profesor "+nombre+ " recibe: "+mensaje);
    }
}
