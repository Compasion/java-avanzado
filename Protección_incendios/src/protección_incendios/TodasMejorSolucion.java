/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protección_incendios;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author casa
 */
public class TodasMejorSolucion {
    List<Integer> solucion = new ArrayList<>();
    int cantidadBombas;
    int posicion; //posicion que ocupa en todas las posibles posiciones

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }
    
    public List<Integer> getSolucion() {
        return solucion;
    }

    public void setSolucion(List<Integer> solucion) {
        this.solucion = solucion;
    }
    public void aniadirVertice(Integer v){
        solucion.add(v);
    }
    
    
    public void imprimir(){
        System.out.println("____________Posible Solucion "+ this.posicion + "___________________ ");
        for (int i=0; i<solucion.size(); i++){
             System.out.println("Nombre " + (solucion.get(i)+1));
                        
        }
        System.out.println("_______________________________ ");
    }

    public void setCantidadBombas(int cantidadBombas) {
        this.cantidadBombas = cantidadBombas;
    }

    public int getCantidadBombas() {
        return cantidadBombas;
    }
}
