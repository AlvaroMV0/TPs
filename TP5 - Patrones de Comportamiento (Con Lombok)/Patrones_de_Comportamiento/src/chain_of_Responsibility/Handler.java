package chain_of_Responsibility;

import lombok.Setter;

abstract class Handler {
    @Setter
    private Handler siguiente;

    public void manejar(String problema, int nivel){
        if (!procesar(problema,nivel) && siguiente != null){
            siguiente.manejar(problema,nivel);
        }
    }
    protected abstract boolean procesar(String problema,int nivel);
}
