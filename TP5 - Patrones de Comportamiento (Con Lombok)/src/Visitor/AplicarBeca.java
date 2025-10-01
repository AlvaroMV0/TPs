package Visitor;

class AplicarBeca implements Visitor {
    @Override
    public void visitar(AlumnoRegular a) {
        System.out.println("  - AplicarBeca a Alumno Regular " + a.getNombre() + ": Recibe descuento del 10% por pago puntual.");
    }

    @Override
    public void visitar(AlumnoBecado a) {
        System.out.println("  - AplicarBeca a Alumno Becado " + a.getNombre() + ": Beca del " + (int)(a.getPorcentajeBeca() * 100) + "% aplicada.");
    }
}