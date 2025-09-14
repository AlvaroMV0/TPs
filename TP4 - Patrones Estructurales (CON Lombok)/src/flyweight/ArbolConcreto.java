package flyweight;

import lombok.Getter;
import lombok.ToString;


@ToString
@Getter

public class ArbolConcreto implements Arbol {
    private final String tipo;
    private final String textura;
    private final String color;


    //No colocamos RequieredArgsConstructors porque tenemos un output personalizado en el constructor
    public ArbolConcreto(String tipo, String textura, String color) {
        this.tipo = tipo;
        this.textura = textura;
        this.color = color;
        System.out.println("- - - -creando arbol del tipo: '" + tipo + "' con textura: '" + textura + "' y color: '" + color + "'");
    }

    @Override
    public void posicion(int x, int y) {
        System.out.println("Dibujando arbol '" + this + "' en: x: " + x + ". y: " + y);
    }
}
