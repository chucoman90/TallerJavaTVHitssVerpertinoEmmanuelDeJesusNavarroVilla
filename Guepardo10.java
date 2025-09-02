package ejercicios;

public class Guepardo10 extends Felino10 {

    public Guepardo10(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras,
            int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
    }

    @Override
    public String comer() {
        return "El guepardo come carne";
    }

    @Override
    public String dormir() {
        return "El guepardo duerme 12 horas al día";
    }

    @Override
    public String correr() {
        return "El guepardo puede correr a una velocidad de 120 km/h";
    }

    @Override
    public String comunicarse() {
        return "El guepardo emite sonidos como maullidos y ronroneos";
    }

    @Override
    public String toString() {
        return "{habitat: " + habitat + ", tamanoGarras: " + tamanoGarras + ", altura: " + altura + ", velocidad: "
                + velocidad + ", largo: " + largo + ", peso: " + peso + ", nombreCientifico: " + nombreCientifico + "}";
    }

    
    
}
