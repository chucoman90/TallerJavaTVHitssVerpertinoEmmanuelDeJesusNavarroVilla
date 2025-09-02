package ejercicios;

public abstract class Felino10 extends Mamifero10 {

    protected float tamanoGarras;
    protected int velocidad;    

    public Felino10(String habitat, float altura, float largo, float peso, String nombreCientifico,
            float tamanoGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.tamanoGarras = tamanoGarras;
        this.velocidad = velocidad;
    }

    public void setTamanoGarras(float tamanoGarras) {
        this.tamanoGarras = tamanoGarras;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
