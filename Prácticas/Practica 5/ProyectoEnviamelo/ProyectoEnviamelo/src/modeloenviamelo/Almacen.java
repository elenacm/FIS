/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloenviamelo;

/**
 *
 * @author aanaya
 */
class Almacen {
    private String distrito;
    private String direccion;
    private String telefono;
    private String responsable;
   
    Almacen(String distrito, String direccion, String telefono, String responsable) {  
        this.distrito = distrito;
        this.direccion = direccion;
        this.telefono = telefono;
        this.responsable = responsable;
    }
    
}
