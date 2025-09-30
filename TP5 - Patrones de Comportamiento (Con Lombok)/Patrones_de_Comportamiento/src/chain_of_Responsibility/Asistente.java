package chain_of_Responsibility;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Asistente extends Handler{
    @Override
    protected boolean procesar(String problema, int nivel) {
        if(nivel <= 1) {
            System.out.println("Problema solucionado por Asistente");
            return true;
        }
        return false;
    }
}
