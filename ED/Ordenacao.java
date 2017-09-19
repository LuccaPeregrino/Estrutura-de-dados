/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.lang.*;

/**
 *
 * @author Lucca Peregrino
 */
public class Ordenacao {
    public static void main(String[] args){
    int n = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int w = 0;
    int c = 0;
    int d = 0;
    int t = 0;
      
    
    Scanner s = new Scanner(System.in);
    Scanner f = new Scanner(System.in);
    
    //pega o valor digitado e iguala a n
    n = s.nextInt();
    
    int array1[] = new int[n];
    
    //pega a String de numeros digitadas, separa os caracteres diferentes de ' ', converte para inteiro e adiciona no array1;
    
    for(i = 0;i<n;i++){
        array1[i] = s.nextInt();
    }
   
    //pega o valor digitado e iguala a m
    m = s.nextInt();
    int array2[] = new int[m];
    
    //pega a String de numeros digitadas, separa os caracteres diferentes de ' ', converte para inteiro e adiciona no array2;
   
    for(j = 0; j <m ;j++){
       array2[j] = s.nextInt();
   }
   
   
    int aux = 0;

    for(c = 0;c < n;c++){
        for(d = 0;d < m;d++){
            if(array1[c]!=array2[d]){
               w = 0; 
            }else{
            w = 1;
            break;
            }
        }
        d = 0;
        
        if(w==0){
            aux++;
        }     
    }
  
    
           
    int array_aux[] = new int[aux];
    int g = 0;
    int contador = 0;
    for(k = 0;k <n;k++){
        for(t = 0;t < m;t++){
            if(array1[k]!= array2[t]){
               g = 0; 
            }else{
                g = 1;
            break;
            }
        }
       
        if(g==0){
            array_aux[contador] = array1[k];
            contador++;
        }
    }
    
    for(int e = 0; e < aux; e++){
    System.out.printf("%d ", array_aux[e]);
    }
    
    }

}
