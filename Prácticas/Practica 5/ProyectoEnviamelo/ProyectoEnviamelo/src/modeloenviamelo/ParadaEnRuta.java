/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloenviamelo;
import java.time.LocalTime;

public class ParadaEnRuta {
    private LocalTime horaLlegada;
    private float pesoParada;
    private Parada parada;
   
    ParadaEnRuta(Parada parada) {
        this.parada = parada;
    }
    
   void modificarHoraLlegada(LocalTime hora){ horaLlegada = hora; }
}
