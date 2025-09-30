package command;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class AbandonarCursoCommand implements CommandInterface{
    @Override
    public void execute() {
        System.out.println("Curso Abandonado");
    }
}
