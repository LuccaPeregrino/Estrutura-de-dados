/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucca Peregrino
 */
public class No {
    
    private No ant;
    private String conteudo;
    private String proximo;
    private String anterior;
    private No prox;

    public No(){
        ant = null;
        proximo = null;
    }

    public No getAnterior(){
        return ant;
    }

    public void setAnterior(No a){
        ant = a;
    }

    public No getProximo(){
        return prox;
    }

    public void setProximo(No p){
        prox = p;
    }

    public String getConteudo(){
        return conteudo;
    }

    public void setConteudo(String c){
        conteudo = c;
    }
    public String getConteudoAnt(){
        return anterior;
    }
    public void setConteudoAnt(String a){
        anterior = a;
    }
    public String getConteudoProx(){
        return proximo;
    }
    public void setConteudoProx(String a){
        proximo = a;
    }
}
