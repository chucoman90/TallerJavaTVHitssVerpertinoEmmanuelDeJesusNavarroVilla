package ejercicios;

import java.util.ArrayList;
import java.util.List;


public class ServicioGenerico14 <T extends Identificable14<ID>,ID> {

    private List<T> datos = new ArrayList<>();

    public void agregar(T elemento){
        if (buscarPorId(elemento.getId()) != null) {
            System.out.println("Ya existe el elemento con ID: " + elemento.getId());
        }else{
            datos.add(elemento);//Agrega un elemento al final de la lista
            System.out.println("Guardado: " + elemento);
        }
        
    }

    public List<T> listar(){
        //return new ArrayList<>(datos);
        return datos;
    }

    public T  buscarPorId(ID id){
        for (T elemento : datos) {
            if(elemento.getId().equals(id)){
                return elemento;
            }
        }
        return null;
    }

    public boolean eliminarPorId(ID id){
        
        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).getId().equals(id)) {
                datos.remove(i);//Elimina un elemento atraves de su indice
                System.out.println("eliminado ID: " + id);
                return true;
            }    
        }

        System.out.println("no se encontro ID: " + id);
        return false;
    }

    public boolean actualizar(ID id,T nuevoElemento){

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).getId().equals(id)) {
                datos.set(i, nuevoElemento);//Remplaza por medio del indice un elemento
                System.out.println("Actualizado ID: " + id + " con: " + nuevoElemento);
                return true;
            }
        }
        System.out.println("No se encontró ID: " + id + " para actualizar");
        return false;
    }
}
