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
    public static Enviamelo getInstancia(){ return instancia; }
    private Enviamelo(){ this.inicalizar(); }
    
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
    
    public List<Almacen> obtenerAlmacen(){ return almacenes; }
    
    // proporciona todos los numeros de ruta plantilla que estén activas 
    public int[] obtenerRutasActivas() {
        int[] numeroRutaActiva = null;
        int i = 0;
        
        for (RutaPlantilla rutaPlantilla1 : rutaPlantilla) {
            if(rutaPlantilla1.RutaActiva()){
                numeroRutaActiva[i] = rutaPlantilla1.obtenerNumeroRuta();
                i++;
            }
        }
        
        return numeroRutaActiva;
    }

    public int registrarInicioRuta(int numeroRuta) {        
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(numeroRuta);
        rutaPlantilla.registrarInicioRuta();        
        int numeroParadas = rutaPlantilla.obtenerNumeroParadas();
        
        return numeroParadas;
    }

    public List registrarParadaCompletada(int numeroRuta) {       
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(numeroRuta);
        List datosSiguienteParada = rutaPlantilla.registrarParadaCompleta();
        
        return datosSiguienteParada;
    }
    
    //idRutaPlantilla = numeroRuta
    public void registrarConclusionRuta(int numeroRuta) {
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(numeroRuta);
        rutaPlantilla.registrarConclusionRuta();
    }

    public int crearRutaPlantilla(int numeroRuta, LocalTime horaPrevistaInicio) {
        boolean existe = existeRutaPlantilla(numeroRuta);
            
        if(existe)  throw new UnsupportedOperationException("Ya existe la ruta plantilla con ese numero de ruta.");
        
        RutaPlantilla unaRutaPlantilla = new RutaPlantilla(numeroRuta, horaPrevistaInicio);
        rutaPlantilla.add(unaRutaPlantilla);
        int idRutaPlantilla = unaRutaPlantilla.obtenerNumeroRuta(); //idRutaPlantilla = numeroRuta
        
        return idRutaPlantilla;
    }
    
    //idRutaPlantilla = numeroRuta, idAlmacen = distritoPostal
    public void añadirParadaRutaPlantilla(int idRutaPlantilla, LocalTime horaPrevistaLlegada, String idAlmacen){
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        Almacen almacen = buscarAlmacen(idAlmacen);
        
        rutaPlantilla.añadirParada(horaPrevistaLlegada, almacen);
    }
    
    //idRuta = idRutaPlantilla +idRutaDiaria, idRutaPlantilla = numeroRuta
    // idRutaDiaria = fecha, idFurgoneta = matricula
    public void asignarRutaFurgoneta(int idRutaPlantilla, LocalDate idRutaDiaria, String idFurgoneta){
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        Furgoneta furgoneta = buscarFurgoneta(idFurgoneta);
        
        rutaPlantilla.asignarRutaFurgoneta(idRutaDiaria, furgoneta);
    }
    
    public void generarRutaDiaria(LocalDate fecha, int idRutaPlantilla){
        LocalDate fechaActual = LocalDate.now();        
        if(fecha.isBefore(fechaActual)) throw new UnsupportedOperationException("La fecha debe ser igual o posterior a la fecha actual");        
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        
        rutaPlantilla.generarRutaDiaria(fecha);
    }
    
    public List obtenerFurgonetasRuta(int idRutaPlantilla){
        List datosFurgonetas = null;
        RutaPlantilla rutaPlantilla = buscarRutaPlantilla(idRutaPlantilla);
        
        String distrito = rutaPlantilla.obtenerDistritoPrimeraParada();
        Furgoneta[] furgo = seleccionarFurgonetasDisponibles(distrito);
        
        for (Furgoneta furgoneta : furgo) {
            List datosFurgo = furgoneta.obtenerDatos();
            datosFurgonetas = datosFurgo;
        }
        
        return datosFurgonetas;
    }
        
    private Almacen buscarAlmacen(String idAlmacen){
        Almacen almacen = null;
        
        for (Almacen almacen1 : almacenes) {
            if(almacen.obtenerDistrito() == idAlmacen){
                almacen = almacen1;
            }
        }
        
        return almacen;
    }
    
    private Furgoneta buscarFurgoneta(String idFurgoneta){
        Furgoneta furgoneta = null;
        
        for (Furgoneta furgo : furgonetas) {
            if(furgo.obtenerMatricula() == idFurgoneta){
                furgoneta = furgo;
            }
        }
        
        return furgoneta;
    }
    
    private RutaPlantilla buscarRutaPlantilla(int idRutaPlantilla){
        RutaPlantilla rutaPlantilla = null;
        
        for (RutaPlantilla miruta : this.rutaPlantilla) {
            if(miruta.obtenerNumeroRuta() == idRutaPlantilla){
                rutaPlantilla = miruta;
            }
        }
        
        return rutaPlantilla;
    }
    
    private boolean existeRutaPlantilla(int numeroRP){
        
        for (RutaPlantilla rutaPlantilla1 : rutaPlantilla) {
            if(rutaPlantilla1.obtenerNumeroRuta() == numeroRP)
                return true;
        }
        return false;
    }
    
    private Furgoneta[] seleccionarFurgonetasDisponibles(String distrito){
        Furgoneta[] furgoneta = null;
        int i  = 0;
        
        for (Furgoneta furgo : furgonetas) {
            if(furgo.obtenerAlmacen().obtenerDistrito() == distrito && furgo.disponibilidad()){
                furgoneta[i] = furgo;
                i++;
            }
        }
        
        return furgoneta;
    }
          
}
