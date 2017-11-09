/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Lucca Peregrino
 */
class NICEBTREE{
    public static class No { 
            private char conteudo;
            private No FilhoEsquerda;
            private No FilhoDireita;

            public char getConteudo() {
             return conteudo;
            }

            public void setConteudo(char c) {
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
    
    
    public static class Arvore {
      
        private String percurso;
        private int indice;
        private No raiz;
    
        //Método simples para unicamente retornar a raiz da árvore
        public No getRaiz(){
            return raiz;
        }


        //Método construtor
        public Arvore(String t) {
            percurso = t;
            indice = 0;
        
            //cria a raiz e seus dois filhos
            No no = new No();
            raiz = no;
            raiz.setConteudo(percurso.charAt(indice));
        
            if (raiz.getConteudo() == 'l') {
                raiz.setFilhoEsquerda(null);
                raiz.setFilhoDireita(null);
            } else {
                raiz.setFilhoEsquerda(add(raiz, percurso.charAt(++indice)));
                raiz.setFilhoDireita(add(raiz, percurso.charAt(++indice)));
            }
        }
        
     
        //Método para adicionar nós, sendo isso de forma recursiva, passando o nó parente em vez de passar o conteudo dele 
        //e busca-lo na arvore, visto que como o conteudo desses nós sao iguais entre eles(l ou n), n tem como fazer uma busca 
        //por um nó especifico
        private No add(No parente, char conteudo) {
            No novoNo = new No();
            novoNo.setConteudo(conteudo);
        
            if (conteudo == 'l') {
                novoNo.setFilhoEsquerda(null);
                novoNo.setFilhoDireita(null);
            } 
            else {
                novoNo.setFilhoEsquerda(add(novoNo, percurso.charAt(++indice)));
                novoNo.setFilhoDireita(add(novoNo, percurso.charAt(++indice)));
            }

            return novoNo;
        }
     
        //Nó no equivale a raiz, para que a contada da profundidade seja feita a partir da raiz
        private int getProfundidade(No no) {
        
            if (no == null) {
                return -1;
            }

            int he = getProfundidade(no.getFilhoEsquerda());
            int hd = getProfundidade(no.getFilhoDireita()); 
        
            if (he < hd) {
                return hd+1;
            } else {
                return  he+1;
            }
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        String percurso;
        
        int i;
        for (i = 0; i < t; i++) {
            percurso = s.nextLine();

            Arvore arvore = new Arvore(percurso);
            System.out.println(arvore.getProfundidade(arvore.getRaiz()));
            
        }
    }

}