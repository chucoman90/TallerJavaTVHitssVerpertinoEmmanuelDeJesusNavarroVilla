package ejercicios;

public class Perro10 extends Canino10 {

    private int fuerzaMordida;

    public Perro10(String habitat, float altura, float largo, float peso, String nombreCientifico, String color,
            float tamanoColmillos, int fuerzaMordida) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    @Override
    public String comer() {
        return "El perro come croquetas";
    }

    @Override
    public String dormir() {
        return "El perro duerme 12 horas al día";
    }

    @Override
    public String correr() {
        return "El perro puede correr a una velocidad de 45 km/h";
    }

    @Override
    public String comunicarse() {
        return "El perro ladra con una fuerza de mordida de " + fuerzaMordida + " PSI";
    }

    public int getFuerzaMordida() {
        return fuerzaMordida;
    }

    public void setFuerzaMordida(Integer fuerzaMordida) {
        this.fuerzaMordida = fuerzaMordida;
    }

    @Override
    public String toString() {
        return "{habitat: " + habitat + ", fuerzaMordida: " + fuerzaMordida + ", color: " + color + ", altura: "
                + altura + ", tamanoColmillos: " + tamanoColmillos + ", largo: " + largo + ", peso: " + peso
                + ", nombreCientifico: " + nombreCientifico + "}";
    }

    
    
}
