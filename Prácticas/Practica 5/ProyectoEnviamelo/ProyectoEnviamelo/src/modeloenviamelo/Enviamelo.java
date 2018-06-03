/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloenviamelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 *
 * @author aanaya
 */
public class Enviamelo {
    private static Enviamelo instancia = new Enviamelo();
    public static Enviamelo getInstancia(){
        return instancia;
    }
    private Enviamelo(){    
        this.inicalizar();
    }
    
    private List<Almacen> almacenes = new ArrayList();
    private List<Furgoneta> furgonetas = new ArrayList();
    private List<RutaPlantilla> rutaPlantilla = new ArrayList();    //Array de ruta plantilla
    
    private void inicalizar() {
        Almacen a1 = new Almacen("18000","el florio, Granada","958345678","Antonio");
        Almacen a2 = new Almacen("29000","el potril, Málaga","952785678", "Maria");
        Almacen a3 =new Almacen("04000","el poniente, Almería","954087654", "Mario");
        Almacen a4 = new Almacen("23000", "los olivares, Jaén", "953765432", "Antonia");
        almacenes.add(a1);  
        almacenes.add(a2);
        almacenes.add(a3);
        almacenes.add(a4);
       
        furgonetas.add(new Furgoneta("3654 FFF", 2000, a1));
        furgonetas.add(new Furgoneta("3756 CDD", 3000, a1));
        furgonetas.add(new Furgoneta("9086 KDG", 1000, a2));
        furgonetas.add(new Furgoneta("9876 JJJ", 1000, a2));
        furgonetas.add(new Furgoneta("2111 HHH", 2000, a3));
        furgonetas.add(new Furgoneta("4545 HFG", 1000, a3));
        furgonetas.add(new Furgoneta("2885 JHG", 5000, a4));
        furgonetas.add(new Furgoneta("3335 DCD", 5000, a4));
    }
    // proporciona todos los numeros de ruta plantilla que estén activas 
    public int[] obtenerRutasActivas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int registrarInicioRuta(int numeroRuta) {
        int numeroParadas = 0;
        
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(numeroRuta);
        rutaPlantilla.registrarInicioRuta();
        numeroParadas = rutaPlantilla.obtenerNumeroParadas();
        
        return numeroParadas;
    }

    public List registrarParadaCompletada(int numeroRuta) {
        List datosSiguienteParada = null;
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(numeroRuta);
        datosSiguienteParada = rutaPlantilla.registrarParadaCompleta();
        
        return datosSiguienteParada;
    }

    public void registrarConclusionRuta(int numeroRuta) {
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(numeroRuta);
        rutaPlantilla.registrarConclusionRuta();
    }

    public int crearRutaPlantilla(int numeroRuta, LocalTime horaPrevistaInicio) {
        boolean existe = existeRutaPlantilla(numeroRuta);
            
        if(existe)  throw new UnsupportedOperationException("Ya existe la ruta plantilla con ese numero de ruta.");
        
        RutaPlantilla unaRutaPlantilla = new RutaPlantilla(numeroRuta, horaPrevistaInicio);
        rutaPlantilla.add(unaRutaPlantilla);
        int idRutaPlantilla = unaRutaPlantilla.obtenerNumeroRuta();
        
        return idRutaPlantilla;
    }
    
    public void añadirParadaRutaPlantilla(int idRutaPlantilla, LocalTime horaPrevistaLlegada, int idAlmacen){
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        Almacen almacen = buscarAlmacen(idAlmacen);
        
        rutaPlantilla.añadirParada(horaPrevistaLlegada, almacen);
    }
    
    public void asignarRutaFurgoneta(int idRutaPlantilla, LocalDate idRutaDiaria, int idFurgoneta){
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        Furgoneta furgoneta = buscarFurgoneta(idFurgoneta);
        
        rutaPlantilla.asignarRutaFurgoneta(idRutaDiaria, furgoneta);
    }
    
    public void generarRutaDiaria(LocalDate fecha, int idRutaPlantilla){
        LocalDate fechaActual = LocalDate.now();        
        //if(fecha < fechaActual) throw new UnsupportedOperationException("La fecha debe ser igual o posterior a la fecha actual");        
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        
        rutaPlantilla.generarRutaDiaria(fecha);
    }
    
    public List obtenerFurgonetasRuta(int idRutaPlantilla){
        List datosFurgonetas = null;
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        
        String distrito = rutaPlantilla.obtenerDistritoPrimeraParada();
        Furgoneta[] furgo = seleccionarFurgonetasDisponibles(distrito);
        
        for(int i = 0; i < furgo.length; i++){
           List datosFurgo = furgo[i].obtenerDatos();
           datosFurgonetas = datosFurgo;
        }
        
        return datosFurgonetas;
    }
        
    private Almacen buscarAlmacen(int idAlmacen){
        Almacen almacen = null;
        
        for(int i = 0; i < almacenes.size(); i++){
        }
        
        return almacen;
    }
    
    private Furgoneta buscarFurgoneta(int idFurgoneta){
        Furgoneta furgoneta = null;
        return furgoneta;
    }
    
    private RutaPlantilla buscarRutaPlantilla(int idRutaPlantilla){
        RutaPlantilla rutaPlantilla = null;
        return rutaPlantilla;
    }
    
    private boolean existeRutaPlantilla(int numeroRP){
        return true;
    }
    
    private Furgoneta[] seleccionarFurgonetasDisponibles(String distrito){
        Furgoneta[] furgoneta = null;
        return furgoneta;
    }
          
}
