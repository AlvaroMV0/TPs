package chain_of_Responsibility;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Coordinador extends Handler{
    @Override
    protected boolean procesar(String problema, int nivel) {
        if(nivel >= 3) {
            System.out.println("Problema solucionado por Coordinador");
            return true;
        }
        return false;
    }
}
