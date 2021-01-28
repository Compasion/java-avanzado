/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author casa
 */

public class ejercicio {
    final int TAM=9;
    int fila=0;
    int columna=0;
    int solucion=1;
    int[][] tablero= new int[TAM][TAM];
    public void imprimirTablero(){
        System.out.println("___________"+ solucion + "________________");
        for (int i=0; i<TAM; i++){
           for (int j=0; j<TAM; j++){
               System.out.print(tablero[i][j] + " ");
            } 
           System.out.println();
        }
        
        solucion++;
    }
    public boolean completado(){
        boolean completo=true;
        for (int i=0; i<tablero.length; i++){
            for (int j=0; j<tablero.length; j++){
                if (tablero[i][j] == 0){
                    completo=false;
                }
            }
        }
        return completo;
    }
    public boolean esSolucion(){
        return true;
    }
    public boolean noEstaFC(int valor){
        boolean pasa=true;
        
        for (int i=0; i<TAM; i++){
            if (tablero[fila][i]== valor){
                pasa=false;
                break;
            }
            if (tablero[i][columna]==valor){
                pasa=false;
                break;
            }
        }
        return pasa;
    }
    public boolean noEstaCuadrado(int valor){
        boolean pasa=true;
        int cuadradoF =(int) fila/3;
        int cuadradoC =(int) columna/3;
        int x=0;
        int y=0;
        int auxX;
        int auxY;
        
        switch(cuadradoF){
            case 0:
                switch(cuadradoC){
                    case 0:
                        x=1;
                        y=1;
                        break;
                    case 1:
                        x=1;
                        y=4;
                        break;
                    case 2:
                        x=1;
                        y=7;
                        break;
                }
                break;
            case 1:
                switch(cuadradoC){
                    case 0:
                        x=4;
                        y=1;
                        break;
                    case 1:
                        x=4;
                        y=4;
                        break;
                    case 2:
                        x=4;
                        y=7;
                        break;
                }
                break;
            case 2:
                switch(cuadradoC){
                    case 0:
                        x=7;
                        y=1;
                        break;
                    case 1:
                        x=7;
                        y=4;
                        break;
                    case 2:
                        x=7;
                        y=7;
                        break;
                }
                break;
                
        }
        for(int i=-1; i<=1;i++){
            auxX=x+i;
            for(int j=-1;j<=1;j++){
                auxY=y+j;
                if (auxX>(x-2) && auxY>(y-2) && auxX<(x+2) && auxY<(y+2)){
                    if (tablero[auxX][auxY]==valor){
                        pasa=false;
                        break;
                    }
                }
            }
        }
        return pasa;
    
    }
    public void lanzar (){
        if (completado()){
            if (esSolucion()){
                imprimirTablero();
            }
        }else{
            for (int i=1;i <= TAM ; i++){
                
                if (noEstaFC(i)){
                    if(noEstaCuadrado(i)){
                        tablero[fila][columna]=i;
                        columna++;
                        if (columna == TAM){
                            fila ++;
                            columna=0;
                        }
                        lanzar();
                        columna--;
                        if (columna == -1){
                            fila --;
                            columna=TAM-1;
                        }
                        tablero[fila][columna]=0;
                    }
                }
            }
        }
    
    }
    
}
