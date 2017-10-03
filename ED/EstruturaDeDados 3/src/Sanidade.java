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
public class Sanidade {
    
    public static void main(String[] args){
        Lista l = new Lista();
        Scanner scan = new Scanner(System.in);      
        String anterior,conteudo,proximo,anterior2,conteudo2,proximo2;
        boolean sano = true;
       

        
         //separar os elementos da string s(ptr1)
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
        
        
        //separa os elementos da string d (ptr2)
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
        for(int j = 1;j<+l.tamanho();j++){
            System.out.println(l.elemento(j));
        }
        
 
       String FrenteTras = new String();
       String TrasFrente = new String();
        


        //////////////////////////////////////////////
        int aux = 0;
        FrenteTras += ptr1.getConteudo();
	for (No n = ptr1; n != ptr2; ++aux) {
		// Find next in list
		for (int i = 0; i < l.tamanho(); ++i) {
			if (n.getConteudoProx().equals(l.elemento(i))) {
				// Move forward
				n = l.pegaNo(i);

				// Add to the traversed string
				FrenteTras += l.elemento(i);
				break;
			}
		}
		
		if (aux > l.tamanho()) {
			// Couldn't reach the end
			sano = false;
			break;
		}
	}
        
        
        
        
        ////////////////////////////////////////
        aux = 0;
        TrasFrente += ptr2.getConteudo();
        for (No n = ptr2; n != ptr1; ++aux) {
            // Find previous in list
            for (int i = 0; i < l.tamanho(); ++i) {
		if (n.getConteudoAnt().equals(l.elemento(i))) {
		// Move forward
                    n = l.pegaNo(i);

                // Add to the traversed string
                TrasFrente += l.elemento(i);
                    break;
		}
            }
		
            if (aux > l.tamanho()) {
		// Couldn't reach the beginning
		sano = false;
		break;
		}
	}
        
        for(int j = 1;j<=l.tamanho();j++){
            System.out.println(FrenteTras);
            System.out.println(TrasFrente);
        }
        //////////////////////////////////////////
        if (FrenteTras.equals(TrasFrente) && sano) {
		System.out.println("Sana");
	} else {
		System.out.println("Insana");
	}

	
    }    
    
}
