/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class RutaPlantilla {
    private int numeroRuta;
    private LocalTime horaPrevistaInicio;
    private boolean activa = true;
    private Parada parada; //array
    private Ruta rutas; //array
   
    RutaPlantilla(int numeroRuta, LocalTime horaPrevistaInicio) {
        this.numeroRuta = numeroRuta;
        this.horaPrevistaInicio = horaPrevistaInicio;
    }
    
    void asignarRutaFurgoneta(LocalDate idRutaDiaria, Furgoneta furgoneta){}
    void añadirParada(LocalTime horaPrevistaLlegada, Almacen almacen){}
    void generarRutaDiaria(LocalDate Fecha){}
    String obtenerDistritoPrimeraParada(){}
    int obtenerNumeroParadas(){}
    int obtenerNumeroRuta(){}
    void registrarConclusionRuta(){}
    void registrarInicioRuta(){}
    void registrarParadaCompleta(){}
    Ruta buscarRuta(LocalDate idRutaDiaria){}
}
