package ejercicios;

import java.time.LocalDate;
import java.time.LocalTime;

public record Vuelo15(String nombre, String origen, String destino, LocalDate fechaLlegada, LocalTime horaLlegada,int numPasajeros) {
}
