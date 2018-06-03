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
        String distrito;
        
        Parada primeraParada = parada.get(0);
        distrito = primeraParada.obtenerDistrito();
        
        return distrito;
    }
    
    int obtenerNumeroParadas(){ return parada.size(); }
    
    int obtenerNumeroRuta(){ return numeroRuta;}
    
    void registrarConclusionRuta(){
        Ruta ruta = null;   //no se inicializa asi
        ruta.registrarConclusion();
    }
    
    void registrarInicioRuta(){
        Ruta ruta = rutas.get(numeroRuta);  //hay que coger la de la fecha actual
        ruta.registrarInicio();
    }
    
    List registrarParadaCompleta(){
        LocalDate fecha = LocalDate.now();
        Ruta ruta = null;
        
        for(int i  = 0; i < rutas.size(); i++){
            if(rutas.get(i).getFecha() == fecha)
                ruta = rutas.get(i);
        }
        List datosSiguienteParada = ruta.registrarParadaCompleta();
        
        return datosSiguienteParada;
    }
    
    Ruta buscarRuta(LocalDate idRutaDiaria){
        Ruta ruta = null;
        return ruta;
    }
    
}
