/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ruta {
    private LocalDate fechaRealizacion;
    private LocalTime horaInicio;
    private ParadaEnRuta paradaEnRuta; //array
    private Furgoneta furgoneta;
    private Parada paradaActual;
   
    Ruta(LocalDate fecha) {
        fechaRealizacion = fecha;
    }
    
    void asignarFurgoneta(Furgoneta furgoneta){ this.furgoneta = furgoneta; }
    void incluirParada(Parada parada){}
    void registrarConclusion(){}
    void registrarInicio(){}
    void registrarParadaCompleta(){}
    void sinParadaActual(){}
    void modificarHoraInicio(LocalTime horaInicio){}
    void modificarParadaActual(Parada parada){}
    ParadaEnRuta obtenerParadaEnRuta(Parada paradaActual){}
    Parada siguienteParada(){}
}
