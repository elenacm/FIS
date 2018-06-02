/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloenviamelo;

import java.time.LocalTime;

public class Parada {
    private LocalTime horaPrevistaLlegada;
    private Almacen almacen;
   
    Parada(LocalTime horaPrevistaLlegada, Almacen almacen) {
        this.horaPrevistaLlegada = horaPrevistaLlegada;
        this.almacen = almacen;
    }
    
   String obtenerDistrito(){ return almacen.obtenerDistrito(); }
   Almacen obtenerAlmacen(){ return almacen; }
   lista obtenerDatos(){}
}
