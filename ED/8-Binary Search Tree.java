
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucca Peregrino
 */
class BinarySearchTree {
    public static class No{ 
            private int conteudo;
            private No FilhoEsquerda;
            private No FilhoDireita;

            public No(int c){
               conteudo = c;
               FilhoEsquerda = null;
               FilhoDireita = null;
           }
            public int getConteudo() {
             return conteudo;
            }

            public void setConteudo(int c) {
             conteudo = c;
            }

            public No getFilhoEsquerda() {
                return FilhoEsquerda;
            }

            public void setFilhoEsquerda(No n) {
                FilhoEsquerda = n;
            }

            public No getFilhoDireita() {
                return FilhoDireita;
            }

            public void setFilhoDireita(No n) {
                FilhoDireita = n;
            }

        }
    public static class arvoreBST {
      
        int indice;
        private No raiz;
    
        
        public arvoreBST(){
            raiz = null;
            indice = 0;
        }
        
        public No getRaiz(){
            return raiz;
        }
        
        public void inserir(int X, No N){
            indice++;
            
            if(X < N.getConteudo()){
                if(N.getFilhoEsquerda() == null){
                    No no = new No(X);
                    no.setConteudo(X);
                    N.setFilhoEsquerda(no);

                }else{
                    inserir (X, N.getFilhoEsquerda());
                }    
            }else if(X > N.getConteudo()){    
                if(N.getFilhoDireita()==null){
                    No no = new No(X);
                    no.setConteudo(X);
                    N.setFilhoDireita(no);
                
                }else{
                    inserir (X, N.getFilhoDireita());
                }
            }
        }
        
        public void inserirRaiz(int X) {
            No newNode = new No(X);
            raiz = newNode;
        }
    }
    
public static void main(String[] args){
        
        arvoreBST arvore = new arvoreBST();
    
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        
        int aux;
        
        for (int i = 1; i <= t; i++) {
            aux = Integer.parseInt(s.nextLine());
            if (i == 1) {
                    arvore.inserirRaiz(aux);
                    System.out.println(arvore.indice);
                } else {
                    arvore.inserir(aux, arvore.raiz);
                    System.out.println(arvore.indice);
                }
        }
    }
}