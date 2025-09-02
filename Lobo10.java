package ejercicios;

public class Lobo10 extends Canino10 {
    
    private int numCamada;
    private String especieLobo;
    
    public Lobo10(String habitat, float altura, float largo, float peso, String nombreCientifico, String color,
            float tamanoColmillos, int numCamada, String especieLobo) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;
    }

    @Override
    public String comer() {
        return "El lobo come carne";
    }

    @Override
    public String dormir() {
        return "El lobo duerme 8 horas al día";
    }

    @Override
    public String correr() {
        return "El lobo puede correr a una velocidad de 60 km/h";
    }

    @Override
    public String comunicarse() {
        return "El lobo aúlla";
    }

    public int getNumCamada() {
        return numCamada;
    }

    public void setNumCamada(Integer numCamada) {
        this.numCamada = numCamada;
    }

    public String getEspecieLobo() {
        return especieLobo;
    }

    public void setEspecieLobo(String especieLobo) {
        this.especieLobo = especieLobo;
    }

    @Override
    public String toString() {
        return "{habitat: " + habitat + ", numCamada: " + numCamada + ", color: " + color + ", altura: " + altura
                + ", especieLobo: " + especieLobo + ", tamanoColmillos: " + tamanoColmillos + ", largo: " + largo
                + ", peso: " + peso + ", nombreCientifico: " + nombreCientifico + "}";
    }

    
}
