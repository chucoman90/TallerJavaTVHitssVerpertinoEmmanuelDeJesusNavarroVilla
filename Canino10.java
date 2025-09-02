package ejercicios;

public abstract class Canino10  extends Mamifero10 {
    
    protected String color;
    protected float tamanoColmillos;

    public Canino10(String habitat, float altura, float largo, float peso, String nombreCientifico, String color,
            float tamanoColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamanoColmillos = tamanoColmillos;
    }

    public String getColor() {
        return color;
    }

    public float getTamanoColmillos() {
        return tamanoColmillos;
    }   
}
