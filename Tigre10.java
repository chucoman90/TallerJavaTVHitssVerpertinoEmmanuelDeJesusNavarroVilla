package ejercicios;

public class Tigre10 extends Felino10 {

    private String especieTigre;

    public Tigre10(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras,
            int velocidad, String especieTigre) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    @Override
    public String comer() {
        return "El tigre come carne";
    }

    @Override
    public String dormir() {
        return "El tigre duerme 16 horas al día";
    }

    @Override
    public String correr() {
        return "El tigre puede correr a una velocidad de 80 km/h";
    }

    @Override
    public String comunicarse() {
        return "El tigre ruge";
    }

    public String getEspecieTigre() {
        return especieTigre;
    }

    public void setEspecieTigre(String especieTigre) {
        this.especieTigre = especieTigre;
    }

    @Override
    public String toString() {
        return "{habitat: " + habitat + ", especieTigre: " + especieTigre + ", tamanoGarras: " + tamanoGarras
                + ", altura: " + altura + ", velocidad: " + velocidad + ", largo: " + largo + ", peso: " + peso
                + ", nombreCientifico: " + nombreCientifico + "}";
    }
    
    
}
