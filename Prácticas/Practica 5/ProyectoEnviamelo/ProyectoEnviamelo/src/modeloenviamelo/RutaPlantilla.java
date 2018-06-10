/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class RutaPlantilla {
    private int numeroRuta;
    private LocalTime horaPrevistaInicio;
    private boolean activa = true;
    private List<Parada> parada = new ArrayList(); //array
    private List<Ruta> rutas = new ArrayList(); //array
   
    RutaPlantilla(int numeroRuta, LocalTime horaPrevistaInicio) {
        this.numeroRuta = numeroRuta;
        this.horaPrevistaInicio = horaPrevistaInicio;
    }
    
    void asignarRutaFurgoneta(LocalDate idRutaDiaria, Furgoneta furgoneta){
        Ruta ruta = buscarRuta(idRutaDiaria);
        ruta.asignarFurgoneta(furgoneta);
    }
    
    void añadirParada(LocalTime horaPrevistaLlegada, Almacen almacen){
        Parada unaParada = new Parada(horaPrevistaLlegada, almacen);
        parada.add(unaParada);
    }
    
    void generarRutaDiaria(LocalDate fecha){
        Ruta unaRuta = new Ruta(fecha);
        
        for(int i = 0; i < parada.size(); i++){
            unaRuta.incluirParada(parada.get(i));
            rutas.add(unaRuta);
        }
    }
    
    String obtenerDistritoPrimeraParada(){        
        Parada primeraParada = parada.get(0);
        String distrito = primeraParada.obtenerDistrito();
        
        return distrito;
    }
    
    int obtenerNumeroParadas(){ return parada.size(); }
    int obtenerNumeroRuta(){ return numeroRuta;}
    boolean RutaActiva(){ return activa; }
       
    //idRutaDiaria = fechaActual
    void registrarConclusionRuta(){
        LocalDate idRutaDiaria = LocalDate.now();
        Ruta ruta = buscarRuta(idRutaDiaria);
        
        ruta.registrarConclusion();
    }
    
    void registrarInicioRuta(){
        LocalDate idRutaDiaria = LocalDate.now();
        Ruta ruta = buscarRuta(idRutaDiaria);
        ruta.registrarInicio();
    }
    
    //idRuta = fechaActual
    List registrarParadaCompleta(){
        LocalDate idRuta = LocalDate.now();
        Ruta ruta = buscarRuta(idRuta);
        
        List datosSiguienteParada = ruta.registrarParadaCompleta();        
        return datosSiguienteParada;
    }
    
    Ruta buscarRuta(LocalDate idRutaDiaria){
        Ruta ruta = null;
        
        for (Ruta ruta1 : rutas) {
            if(ruta1.FechaRealizacion() == idRutaDiaria){
                ruta = ruta1;
            }
        }
        
        return ruta;
    }
    
}
