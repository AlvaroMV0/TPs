package command;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class InscribirseCursoCommand implements CommandInterface {
    @Override
    public void execute() {
        System.out.println("Inscripción completada");
    }
}
