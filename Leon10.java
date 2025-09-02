package ejercicios;

public class Leon10 extends Felino10 {
    private int numManada;
    private float potenciaRugidoDecibel;
    
    public Leon10(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras,
            int velocidad, int numManada, float potenciaRugidoDecibel) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    @Override
    public String comer() {
        return "El león come carne";
    }

    @Override
    public String dormir() {
        return "El león duerme 20 horas al día";
    }

    @Override
    public String correr() {
        return "El león puede correr a una velocidad de 80 km/h";
    }

    @Override
    public String comunicarse() {
        return "El león ruge con una potencia de " + potenciaRugidoDecibel + " decibeles";
    }

    public int getNumManada() {
        return numManada;
    }

    public void setNumManada(Integer numManada) {
        this.numManada = numManada;
    }

    public float getPotenciaRugidoDecibel() {
        return potenciaRugidoDecibel;
    }

    public void setPotenciaRugidoDecibel(Float potenciaRugidoDecibel) {
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    @Override
    public String toString() {
        return "{habitat: " + habitat + ", numManada: " + numManada + ", tamanoGarras: " + tamanoGarras
                + ", altura: " + altura + ", potenciaRugidoDecibel: " + potenciaRugidoDecibel + ", velocidad: " + velocidad
                + ", largo: " + largo + ", peso: " + peso + ", nombreCientifico: " + nombreCientifico + "}";
    }    

    
}
