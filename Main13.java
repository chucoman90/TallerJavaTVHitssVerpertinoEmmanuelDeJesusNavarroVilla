package ejercicios;

public class Main13 {
    public static void main(String[] args) {
        // Bolsa de Lacteos
        Bolsa13<Lacteo13> bolsaLacteos = new Bolsa13<>();

        bolsaLacteos.addProducto(new Lacteo13("Leche", 22.5, 1000, 8));
        bolsaLacteos.addProducto(new Lacteo13("Yogurt", 15.0, 500, 5));
        bolsaLacteos.addProducto(new Lacteo13("Queso", 40.0, 200, 12));
        bolsaLacteos.addProducto(new Lacteo13("Crema", 18.0, 250, 4));
        bolsaLacteos.addProducto(new Lacteo13("Mantequilla", 25.0, 300, 3));

        System.out.println("---- Bolsa de Lácteos ----");
        for (Lacteo13 lacteo : bolsaLacteos.getProductos()) {
            System.out.println("{Nombre: " + lacteo.getNombre() + 
                            ", Precio: " + lacteo.getPrecio() + 
                            ", Cantidad: " + lacteo.getCantidad() + "ml" +
                            ", Proteínas: " + lacteo.getProteinas() + "g}");
        }

        // Bolsa de Frutas
        Bolsa13<Fruta13> bolsaFrutas = new Bolsa13<>();
        bolsaFrutas.addProducto(new Fruta13("Manzana", 12.0, 0.2, "Rojo"));
        bolsaFrutas.addProducto(new Fruta13("Plátano", 10.0, 0.25, "Amarillo"));
        bolsaFrutas.addProducto(new Fruta13("Pera", 14.0, 0.22, "Verde"));
        bolsaFrutas.addProducto(new Fruta13("Mango", 18.0, 0.5, "Naranja"));
        bolsaFrutas.addProducto(new Fruta13("Sandía", 40.0, 5.0, "Verde/Rojo"));

        System.out.println("---- Bolsa de Frutas ----");
        for (Fruta13 fruta : bolsaFrutas.getProductos()) {
            System.out.println("{Nombre: " + fruta.getNombre() + 
                            ", Precio: " + fruta.getPrecio() + 
                            ", Peso: " + fruta.getPeso() + "kg" +
                            ", Color: " + fruta.getColor()+"}");
        }

        // Bolsa de Limpieza
        Bolsa13<Limpieza13> bolsaLimpieza = new Bolsa13<>();
        bolsaLimpieza.addProducto(new Limpieza13("Cloro", 30.0, "Hipoclorito", 1.0));
        bolsaLimpieza.addProducto(new Limpieza13("Detergente", 28.0, "Aniónicos", 2.0));
        bolsaLimpieza.addProducto(new Limpieza13("Suavizante", 25.0, "Cationicos", 1.5));
        bolsaLimpieza.addProducto(new Limpieza13("Jabón Líquido", 35.0, "Glicerina", 1.2));
        bolsaLimpieza.addProducto(new Limpieza13("Limpiador Multiusos", 20.0, "Alcohol", 0.9));

        System.out.println("---- Bolsa de Limpieza ----");
        for (Limpieza13 limpieza : bolsaLimpieza.getProductos()) {
            System.out.println("{Nombre: " + limpieza.getNombre() + 
                            ", Precio: " + limpieza.getPrecio() + 
                            ", Componentes: " + limpieza.getComponentes() +
                            ", Litros: " + limpieza.getLitros()+"}");
        }

        // Bolsa de NoPerecibles
        Bolsa13<NoPerecible13> bolsaNoPerecibles = new Bolsa13<>();
        bolsaNoPerecibles.addProducto(new NoPerecible13("Arroz", 18.0, 1000, 360));
        bolsaNoPerecibles.addProducto(new NoPerecible13("Frijoles", 22.0, 800, 320));
        bolsaNoPerecibles.addProducto(new NoPerecible13("Pasta", 15.0, 500, 250));
        bolsaNoPerecibles.addProducto(new NoPerecible13("Harina", 20.0, 1000, 340));
        bolsaNoPerecibles.addProducto(new NoPerecible13("Azúcar", 16.0, 1000, 400));

        System.out.println("---- Bolsa de No Perecibles ----");
        for (NoPerecible13 np : bolsaNoPerecibles.getProductos()) {
            System.out.println("{Nombre: " + np.getNombre() + 
                            ", Precio: " + np.getPrecio() + 
                            ", Contenido: " + np.getContenido() + "g" +
                            ", Calorías: " + np.getCalorias()+"}");
        }
    }
}
