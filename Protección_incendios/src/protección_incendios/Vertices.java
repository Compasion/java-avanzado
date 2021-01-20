/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protección_incendios;

/**
 *
 * @author casa
 */
import java.util.List;
import java.util.ArrayList;


public class Vertices {
    int nombre;
    boolean estado;
    int estacion;  //se inicia a cero no tiene estacion de bomberos 1 tiene estacion.
    List<Vertices> adyacente = new ArrayList<>();

    
    public Vertices(int n){
        this.nombre=n;
        this.estado=false;
        this.estacion=0;
    }
    
    
    public int getNombre() {
        return nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getEstacion() {
        return estacion;
    }

    public List<Vertices> getAdyacente() {
        return adyacente;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setEstacion(int estacion) {
        this.estacion = estacion;
    }

    public void setAdyacente(List<Vertices> adyacente) {
        this.adyacente = adyacente;
    }
    
     public void aniadiadyacente(Vertices v){
        adyacente.add(v);
    }
    public void quitaradyacente(Vertices v){
        adyacente.remove(v);
    }
    
}
