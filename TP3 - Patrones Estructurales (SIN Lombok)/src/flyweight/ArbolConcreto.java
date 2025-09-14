package flyweight;


public class ArbolConcreto implements Arbol {
    private final String tipo;
    private final String textura;
    private final String color;

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

    public String getTipo() {
        return this.tipo;
    }

    public String getTextura() {
        return this.textura;
    }

    public String getColor() {
        return this.color;
    }

    public String toString() {
        return "ArbolConcreto(tipo=" + this.getTipo() + ", textura=" + this.getTextura() + ", color=" + this.getColor() + ")";
    }
}
