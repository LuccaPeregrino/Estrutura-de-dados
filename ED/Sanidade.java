/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Lucca Peregrino
 */
 class Sanidade {
    
    static class Lista {
    
    
    private No inicio;
    private No fim;
    private int tamanho;

    public Lista(){
    inicio = null;
    fim = null;
    tamanho = 0;
    }
    
  
    public int tamanho() {
        return tamanho;
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
    
   
    void insere(No n) {
     int i = 0;
        if (tamanho != 0){ 
            No m = inicio;
            while(m.getProximo() != null){
               m = m.getProximo();
             }
               n.setProximo(null);
               m.setProximo(n);
               n.setAnterior(fim);
               fim.setProximo(n);
               fim = n;
               ++tamanho;
        
        }else{
           n.setProximo(inicio);
           n.setAnterior(null);
           fim = n;
           inicio = n;
           tamanho++;
        }  
        
    }
}
    
    static class No {
    
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


    public static void main(String[] args){
        Lista l = new Lista();
        Scanner scan = new Scanner(System.in);      
        String anterior,conteudo,proximo,anterior2,conteudo2,proximo2;
        boolean sano = true;
       

        
        //separar os elementos da string s(ptr1) e cria o ptr1
        String f = scan.nextLine();
        No ptr1 = new No();
        String res1 = " ";
        
        
        int result = f.indexOf(res1);
        conteudo = f.substring(0,result);
        ptr1.setConteudo(conteudo);
        
        int result2 = f.lastIndexOf(res1);
        anterior = f.substring(result + 1, result2);
        ptr1.setConteudoAnt(anterior);
        
        proximo = f.substring(result2 + 1,f.length());
        ptr1.setConteudoProx(proximo);
        l.insere(ptr1);
        
        
        
        //separa os elementos da string d(ptr2) e cria o ptr2
        String d = scan.nextLine();
        No ptr2 = new No();
        int result3 = d.indexOf(res1);
        conteudo2 = d.substring(0, result3);
        ptr2.setConteudo(conteudo2);
        
        int result4 = d.lastIndexOf(res1);
        anterior2 = d.substring(result3 + 1,result4);
        ptr2.setConteudoAnt(anterior2);
        
        proximo2 = d.substring(result4 + 1,d.length());
        ptr2.setConteudoProx(proximo2);
        
        l.insere(ptr2);
        
        

        //cria quantos nós eu quiser digitar
        while(true){
          
            String s = scan.nextLine();
            if(s.isEmpty()){
                break;
            }
            
            No NovoNo = new No();
            
            String res = " ";
        
            int result5 = s.indexOf(res);
            conteudo = s.substring(0, result5);
            NovoNo.setConteudo(conteudo);
        
            int result6 = s.lastIndexOf(res);
            anterior = s.substring(result5 + 1,result6);
            NovoNo.setConteudoAnt(anterior);
        
            proximo = s.substring(result6 + 1,s.length());
            NovoNo.setConteudoProx(proximo);
           
            l.insere(NovoNo);
        }
        
       
        
        //Cria duas string para comparar
        String FrenteTras = new String();
        String TrasFrente = new String();
        


        //Preenche a string FrenteTras 
        int aux = 0;
        FrenteTras += ptr1.getConteudo();
	for (No n = ptr1; n != ptr2; ++aux) {
		// encontra o proximo na lista
		for (int i = 0; i < l.tamanho(); i++) {
                    
			if (n.getConteudoProx().equals(l.pegaNo(i).getConteudo())) {
                                
				n = l.pegaNo(i);

				//adiciona à string FrenteTras
				FrenteTras += l.pegaNo(i).getConteudo();
                                break;
                                
			}
		}
		
		if (aux > l.tamanho()) {
			//Fim da lista(termino das procuras)
			sano = false;
			break;
		}
	}
        
        
        
        
        //Preenche a string TrasFrente
        int aux2 = 0;
        TrasFrente += ptr2.getConteudo();
        for (No n = ptr2; n != ptr1; ++aux2) {
            // encontra o proximo na lista
            for (int i = 0; i < l.tamanho(); ++i) {
		if (n.getConteudoAnt().equals(l.pegaNo(i).getConteudo())) {
		
                    n = l.pegaNo(i);

                // adiciona à string TrasFrente
                TrasFrente += l.pegaNo(i).getConteudo();
                    break;
		}
            }
		
            if (aux2 > l.tamanho()) {
		//Fim da lista(termino das procuras)
		sano = false;
		break;
		}
	}
        
        //inverte a strig TrasFrente
        StringBuffer sb = new StringBuffer(TrasFrente);
        
        
        //compara a string TrasFrente com a string FrenteTras
        if (FrenteTras.equals(sb.reverse().toString()) && sano) {
		System.out.println("Sana");
	} else {
		System.out.println("Insana");
	}
    
    }    

}
