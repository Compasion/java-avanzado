/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alicia_1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author casa
 */
public class ejercicio {
    int[] profesores={7,5,6,2,1};
    int[] cursos={4,7,12,5,3,5,7,15};
    //Integer[] cursos={4,7,12,5,3,5,7,15};
    int presupuesto = 20;
    int presupuestoSol=0; //se guarda el sobrante del presupuesto; 
    
    int numMaxPro=0;
    int contadorcursos=0;
    
    List<Integer> solPro = new ArrayList<>();
    List<Integer> solProFi = new ArrayList<>();
    
    List<Integer> solCur = new ArrayList<>();
    List<Integer> solCurFi = new ArrayList<>();
   
    public void calcularProfesor(){
    
        if (!(presupuesto>0)){
            if (presupuesto!=0){
                if ((solPro.size()-1 >= numMaxPro)){
                    //mejor solucion
                    int sumaPro=0;
                    int sumaProFi=0;
                    for (int i=0; i<solPro.size()-1; i++){
                         sumaPro = sumaPro + profesores[solPro.get(i)];
                    }
                    for (int i=0; i<solProFi.size()-1; i++){
                         sumaProFi = sumaProFi + profesores[solProFi.get(i)];
                    }
                    if (sumaPro>sumaProFi){
                        numMaxPro = solPro.size()-1;
                        solProFi.clear();
                        for (int i=0; i<solPro.size()-1; i++){
                              solProFi.add(solPro.get(i));
                        }
                    }

                }
            }
            /*for (int i=0; i<solPro.size(); i++){
                System.out.print(solPro.get(i)+ "/");
            }
            System.out.println();
            for (int i=0; i<solPro.size()-1; i++){
                    suma = suma + profesores[solPro.get(i)];
                }
            }
            
            */
        }else{
             for (int i=0;i<profesores.length;i++){
                 if (!(solPro.contains(i))){
                    // if (presupuesto - profesores[i]>= 0){
                        presupuesto = presupuesto - profesores[i];
                        solPro.add(i);
                        calcularProfesor();
                        presupuesto = presupuesto + profesores[i];
                        solPro.remove(solPro.size()-1);
                    // }
                 }
             }
        }
    
    }
    public void optimizarcursos(){
        //ordenar un array por intercambio ****************************************
         for(int i=0;i<(cursos.length-1);i++){
            for(int j=i+1;j<cursos.length;j++){
                if(cursos[i]>cursos[j]){
                    //Intercambiamos valores
                    int variableauxiliar=cursos[i];
                    cursos[i]=cursos[j];
                    cursos[j]=variableauxiliar;            
                }
            }
        }
        //************************************************************
        //Arrays.sort(cursos);
        //Arrays.sort(cursos, Collections.reverseOrder());
        int j=0;
        for (int i=cursos.length-1;j<numMaxPro;i--){
            solCurFi.add(cursos[i]);
            j++;
        }
    }
    public void lanzar(){
        calcularProfesor();
        int suma=0;
       for (int i=0; i<solProFi.size(); i++){
            System.out.println("Profesor: " +solProFi.get(i)+ "/ Coste " + profesores[solProFi.get(i)]);
            suma = suma + profesores[solProFi.get(i)];
            
        }
        System.out.println("Total presupuesto " + suma);
        
        optimizarcursos();
        int sumac=0;
         for (int i=0; i<solCurFi.size(); i++){
            System.out.println("Curso: " + i + "/ Alumnos " + solCurFi.get(i));
            sumac = sumac + solCurFi.get(i);
            
        }
        System.out.println("Total alumnos " + sumac);
    }
}
