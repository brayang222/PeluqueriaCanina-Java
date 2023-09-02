package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.peristencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, 
    String observaciones, String nombreDuenio, String celDuenio, String alergico, String atencion) {
       
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencion);
        mascota.setObsevaciones(observaciones);
        mascota.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio, mascota);
    }

    public List<Mascota> traerMascotas() {
      return controlPersis.traerMascotas();   
    }

    public void borrarMascota(int numCliente) {
        controlPersis.borrarMascota(numCliente);
    }

    public Mascota traerMascota(int numCliente) {
      return controlPersis.traerMascota (numCliente);
    }

    public void modificarMascota(Mascota mascota, String nombreMascota, String raza, 
            String color, String observaciones, String nombreDuenio, String celDuenio,
            String alergico, String atencion) {
        
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObsevaciones(observaciones);
        mascota.setAtencionEspecial(atencion);
        mascota.setAlergico(alergico);
        
        //modifico mascota
        controlPersis.modificarMascota(mascota);
        
        Duenio dueno = this.buscarDuenio(mascota.getUnDuenio().getIdDuenio());
        dueno.setCelDuenio(celDuenio);
        dueno.setNombre(nombreDuenio);
        
        //llamar al modificar 
        this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int idDuenio) {
        return controlPersis.traerDuenio(idDuenio);
                
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }

    
    
}
