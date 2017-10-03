/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucca Peregrino
 */
public class Lista {
    
    
    private No inicio;
    private No fim;
    private int tamanho;

    public Lista(){
    inicio = null;
    fim = null;
    tamanho = 0;
    }
    
    public boolean vazia(){
        if (tamanho == 0 ){ 
            return true;
        }else{
            return false;
        }
    }
    
    public int tamanho() {
        return tamanho;
    }
  
    public String elemento (int pos) {
        No aux = inicio;
        int cont = 1;
        if (vazia()) return "invalido"; // Consulta falhou
        if ((pos < 1) || (pos > tamanho))
            return "invalido"; // Posicao invalida
        // Percorre a lista do 1o elemento até pos
        while (cont < pos){
            aux = aux.getProximo();
            cont++;
        }
        
        return aux.getConteudo();
    }
    
    No pegaNo(int pos) {
	if (pos > tamanho) {
            return null;
        }

	No n = inicio;
	for (int i = 0; i < pos; ++i) {
            n = n.getProximo();
	}
	return n;
    }
    
    /**Insere um elemento em uma determinada posição
    Retorna true se conseguir inserir e
    false caso contrario */
    void insere(No n) {
     int i = 0;
        if (tamanho != 0){ // insercao no inicio da lista
            No m = inicio;
            while(m.getProximo() != null){
                m = m.getProximo();
             }
               n = m.getProximo();
               m = n.getAnterior();
                ++tamanho;
            
            
        }
        else{  //inserção no fim
            n = inicio;
            tamanho++;
        }  
    }
}
