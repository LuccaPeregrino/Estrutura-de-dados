/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.util.Scanner;
/**
 *
 * @author Lucca Peregrino
 */
public class ONP{
    static class pilha{
        private int dados[];
        private int topo;
        private int tamMax;

        public pilha(){
            tamMax = 400;
            dados = new int[tamMax];
            topo = -1;
        }
        
        public boolean vazia(){
            if (topo == -1){
                return true;
            }
            else{
                return false;
            }
        }
        
       
        public boolean cheia(){
            if (topo == (tamMax-1))
                return true;
            else
                return false;

        }
        
        public int tamanho(){
            return topo+1;
        }
        
       
        public int top () {
            if (vazia())
            return -1; // pilha vazia

        return dados[topo];
        }
        
        
        public boolean push(int valor) {
            if (cheia()){
                return false; // err: pilha cheia
            }
            topo++;
            dados[topo] = valor;
            return true;
        }
        
        
        public int pop() {
            if (vazia()){
                return -1; // Pilha vazia
            }
            int valor = dados[topo];
            topo--;
            return valor;
        }


    }

    public static LinkedList<String> equacoes = new LinkedList<String>();
    public static void main(String[] args){
        Scanner s =new Scanner(System.in);
        
        int n = Integer.parseInt(s.nextLine());
       
        
        for(int i = 0; i<n ;i++){
            String a = s.nextLine();
            equacoes.add(a);
     
        }
        
        for(String w : equacoes){
            resultar(w);
        }  
    }
    
     public static void resultar(String a){
        pilha p = new pilha();
        char equacao[] = a.toCharArray();
        
        for(int i = 0; i < a.length(); i++){
           char atual = equacao[i];
           
           if (atual == '^' || atual == '(') {
             
                p.push(atual);
           }
           else if (atual == '*' || atual == '/') {
		if (p.top() != '^'){
                  
                    p.push(atual);
                }
	   }
           else if (atual == '+' || atual == '-') {
                if (p.top() != '^' && p.top() != '*' && p.top() != '/'){
                  
                    p.push(atual);
                }
	   }
           else if ((atual == ')')) {
            
            while (p.top() != '(') {
             
		System.out.printf("%c", p.top());
		p.pop();
            }

                p.pop();
            } else {
                
                System.out.printf("%c", atual);
            }
        }
        
        System.out.printf("\n");  
    }
}
    

