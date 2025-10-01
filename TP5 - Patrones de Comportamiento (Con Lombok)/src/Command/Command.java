package Command;
//Command es un patron de diseño de comportamiento que convierte
// una solicitud en un objeto independiente
// que contiene toda la información, permitiendo
//retrasar o poner en cola la solicitud

public interface Command {
    void execute();
}
