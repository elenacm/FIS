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
class Furgoneta {
    private String matricula;
    private double pesoMaximo;
    private boolean disponibilidad = true;
    private Almacen almacen;
   
    Furgoneta(String matricula, double pesoMaximo, Almacen almacen) {
        this.matricula = matricula;
        this.pesoMaximo =pesoMaximo;
        this.almacen = almacen;
    }
    
    
  
    
}
