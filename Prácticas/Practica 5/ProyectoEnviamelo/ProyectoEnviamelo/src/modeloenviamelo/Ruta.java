/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Ruta {
    private LocalDate fechaRealizacion;
    private LocalTime horaInicio;
    private List<ParadaEnRuta> paradaEnRuta = new ArrayList(); //array
    private Furgoneta furgoneta = null;
    private Parada actual = null;
   
    Ruta(LocalDate fecha) {
        fechaRealizacion = fecha;
    }
    
    LocalDate getFecha(){ return fechaRealizacion; }
    
    void asignarFurgoneta(Furgoneta furgoneta){ 
        this.furgoneta = furgoneta; 
        furgoneta.modificarDisponibilidad(false);
    }
    
    void incluirParada(Parada parada){
        ParadaEnRuta unaParadaEnRuta = new ParadaEnRuta(parada);
        paradaEnRuta.add(unaParadaEnRuta);
    }
    
    void registrarConclusion(){
        Almacen almacen = actual.obtenerAlmacen();
        furgoneta.modificarLocalizacion(almacen);
        furgoneta.modificarDisponibilidad(true);
        sinParadaActual();
    }
    
    void registrarInicio(){
        Parada primeraParada = siguienteParada();
        modificarParadaActual(primeraParada);
        LocalTime horaActual = LocalTime.now();
        modificarHoraInicio(horaActual);
    }
    
    List registrarParadaCompleta(){
        ParadaEnRuta paradaEnRuta = obtenerParadaEnRuta(actual);
        LocalTime horaActual = LocalTime.now();
        paradaEnRuta.modificarHoraLlegada(horaActual);
        Parada parada = siguienteParada();
        modificarParadaActual(parada);
        
        List datosSiguienteParada = parada.obtenerDatos();
        return datosSiguienteParada;
    }
    
    void sinParadaActual(){}
    
    void modificarHoraInicio(LocalTime horaInicio){}
    
    void modificarParadaActual(Parada parada){}
    
    ParadaEnRuta obtenerParadaEnRuta(Parada paradaActual){
        ParadaEnRuta parada = null;
        return parada;
    }
    
    Parada siguienteParada(){
        Parada primeraParada = null;
        
        if(actual == null){
            actual = paradaEnRuta.get(0).getParada();
            primeraParada = actual;
        }
        else{
            for(int i = 0; i < paradaEnRuta.size(); i++){
                if(paradaEnRuta.get(i).getParada() == actual)
                    primeraParada = paradaEnRuta.get(i+1).getParada();
            }
        }
                
        return primeraParada;
    }
}
