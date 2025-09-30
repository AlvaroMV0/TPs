package chain_of_Responsibility;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Profesor extends Handler {
    @Override
    protected boolean procesar(String problema, int nivel) {
        if(nivel == 2) {
            System.out.println("Problema solucionado por Profesor");
            return true;
        }
        return false;
    }
}
