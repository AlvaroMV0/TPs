package observer;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Alumno implements Observer{

    private String nombre;

    //Uso reflection para dejar en un mismo metodo
    @Override
    public void Update(Object object){
        if(object.getClass().getName() == "java.lang.String"){
            System.out.println("Mensaje recibido por: "+nombre);
        } else if(object.getClass().getName() == "java.time.LocalDateTime"){
            System.out.println("Nuevo horario notificado a alumno: " + nombre);
        }
    }
}
