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

public class ejercicio {
    List<Vertices> grafo = new ArrayList<>();
    
    
    public void crearGrafo(){
        /* Grafo del ejercicio  solucion 3,8,9*/
        Vertices v0 =new Vertices(0);
        Vertices v1 =new Vertices(1);
        Vertices v2 =new Vertices(2);
        Vertices v3 =new Vertices(3);
        Vertices v4 =new Vertices(4);
        Vertices v5 =new Vertices(5);
        Vertices v6 =new Vertices(6);
        Vertices v7 =new Vertices(7);
        Vertices v8 =new Vertices(8);
        Vertices v9 =new Vertices(9);
        Vertices v10 =new Vertices(10);
       
        v0.aniadiadyacente(v1);
        v0.aniadiadyacente(v2);
        v0.aniadiadyacente(v3);
        
        v1.aniadiadyacente(v0);
        v1.aniadiadyacente(v2);
        v1.aniadiadyacente(v4);
        
        v2.aniadiadyacente(v0);
        v2.aniadiadyacente(v1);
        v2.aniadiadyacente(v3);
        v2.aniadiadyacente(v4);
        v2.aniadiadyacente(v5);
        
        v3.aniadiadyacente(v0);
        v3.aniadiadyacente(v2);
        v3.aniadiadyacente(v5);
        v3.aniadiadyacente(v6);
        
        v4.aniadiadyacente(v1);
        v4.aniadiadyacente(v2);
        v4.aniadiadyacente(v5);
        v4.aniadiadyacente(v7);
        v4.aniadiadyacente(v8);
        
        v5.aniadiadyacente(v2);
        v5.aniadiadyacente(v3);
        v5.aniadiadyacente(v4);
        v5.aniadiadyacente(v6);
        v5.aniadiadyacente(v7);
         
        v6.aniadiadyacente(v3);
        v6.aniadiadyacente(v5);
        v6.aniadiadyacente(v7);
        
        v7.aniadiadyacente(v4);
        v7.aniadiadyacente(v5);
        v7.aniadiadyacente(v6);
        v7.aniadiadyacente(v8);
        v7.aniadiadyacente(v9);
        
        v8.aniadiadyacente(v4);
        v8.aniadiadyacente(v7);
        v8.aniadiadyacente(v9);
        v8.aniadiadyacente(v10);
       
        v9.aniadiadyacente(v7);
        v9.aniadiadyacente(v8);
        v9.aniadiadyacente(v10);
        
        v10.aniadiadyacente(v8);
        v10.aniadiadyacente(v9);
        
        grafo.add(v0);
        grafo.add(v1);
        grafo.add(v2);
        grafo.add(v3);
        grafo.add(v4);
        grafo.add(v5);
        grafo.add(v6);
        grafo.add(v7);
        grafo.add(v8);
        grafo.add(v9);
        grafo.add(v10);
        
    }
    public void lanzar() {
        crearGrafo();
        for (int i=0; i<grafo.size(); i++){
            for( int j=0; j<grafo.size();j++ ){
                    grafo.get(j).setEstado(false);
                    grafo.get(j).setEstacion(0);
            } 
            calcular(i);
            
        }
        //imprimir();
       
    
    }
    
    public void imprimir(){
        for (int i=0; i<grafo.size(); i++){
            System.out.println("Nombre " + grafo.get(i).getNombre());
            System.out.println("Estacion " + grafo.get(i).getEstacion());
            
        }
        System.out.println("_______________________________ ");
    }
    
    public boolean todosNoVisitados(){
       boolean noVisitados = false;
       for (int i=0; i<grafo.size(); i++){
           if (grafo.get(i).isEstado() == false){
               noVisitados = true;
               break;
           }
       }
       return noVisitados;
    }
    
    public void calcular(int v){
        List<Vertices> adyacente;
        if (todosNoVisitados()){
            grafo.get(v).setEstacion(1); //pongo que tienen bombero en el terreno
            grafo.get(v).setEstado(true); //lo pongo a solucionado
            adyacente = grafo.get(v).getAdyacente();
            //ponemos todos los adyacente a que tienen bomberos
            for( int i=0; i<adyacente.size();i++ ){
                grafo.get(adyacente.get(i).getNombre()).setEstado(true);
            }
            for (int i=0; i<grafo.size(); i++){
                if (grafo.get(i).isEstado()== false){
                    calcular(i);
                }
            }
            if (!todosNoVisitados()){
                imprimir();
              /* for( int i=0; i<grafo.size();i++ ){
                    grafo.get(i).setEstado(false);
                    grafo.get(i).setEstacion(0);
                } 
              */
            }
            //grafo.get(v).setEstacion(0); //pongo que tienen bombero en el terreno
            //grafo.get(v).setEstado(false); //lo pongo a solucionado
            //adyacente = grafo.get(v).getAdyacente();
            //ponemos todos los adyacente a que tienen bomberos
            //for( int i=0; i<adyacente.size();i++ ){
            //    grafo.get(adyacente.get(i).getNombre()).setEstado(false);
            //}
      
        }
    
    }
}
