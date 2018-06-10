/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloenviamelo;

import java.time.LocalTime;
import java.util.*;

public class Parada {
    private LocalTime horaPrevistaLlegada;
    private Almacen almacen;
   
    Parada(LocalTime horaPrevistaLlegada, Almacen almacen) {
        this.horaPrevistaLlegada = horaPrevistaLlegada;
        this.almacen = almacen;
    }
    
   String obtenerDistrito(){ return almacen.obtenerDistrito(); }   
   Almacen obtenerAlmacen(){ return almacen; }
   
   List obtenerDatos(){
       List datosSiguienteParada = new ArrayList();
       datosSiguienteParada.add(horaPrevistaLlegada);
       String distrito = almacen.obtenerDistrito();
       datosSiguienteParada.add(distrito);
       String direccion = almacen.obtenerDireccion();
       datosSiguienteParada.add(direccion);
       
       return datosSiguienteParada;
   }
}
