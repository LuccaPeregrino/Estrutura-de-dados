
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Tree_order {
	
	static class No{

		int conteudo;
		No esquerda;
		No direita; 

		public No(int valor) {
		    esquerda = null;
		    direita = null;
                    conteudo = valor;
			
		}
	}
        //criação de árvores e seus métodos para manuseio
	static class Arvbin{

		protected static String conteudo = "";
                protected int preIndex = 0;

		private String getString() {
			return conteudo;
		}
                
                //Forma a string que representa a posOrdem, com auxílio do conceito de recursividade
		private void FormarString(No no) {
			if (no == null) 
				return;

			//pela esquerda
			FormarString(no.esquerda);

			//pela direita
			FormarString(no.direita);

			
			conteudo += no.conteudo + " ";

		}
                
                //apenas nos retorna a string posOrdem
		
                private int Busca(String ar[], int Inicio, int Fim, int conteudo) 
		{
			int i;
			for (i = Inicio; i <= Fim; i++) {
			    int aux = Integer.parseInt(ar[i]);
		            if (aux == conteudo)
	 		    return i;
			}
			return i;
		}

		//responsável pela construção da árvore, utilizando o conceito de recursividade
		private No construirArv(String in[], String pre[], int Inicio, int Fim) {

			if (Inicio > Fim) {

				return null;
			}
                        
			int valor = Integer.parseInt(pre[preIndex++]);
			No no = new No(valor);

			if (Inicio == Fim) { 
				return no;
			}
	
			int inIndex = Busca(in, Inicio, Fim, no.conteudo);

			no.esquerda = construirArv(in, pre, Inicio, inIndex - 1);
			no.direita = construirArv(in, pre, inIndex + 1, Fim);

			return no;
		}
	}


	public static void main(String[] args) throws IOException{
		try {
			Arvbin a = new Arvbin();

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int tamanho = Integer.parseInt(in.readLine());

			String preOrdem = in.readLine();
			String preOrd[] = preOrdem.split(" ");

			String posOrdem = in.readLine();

			String inOrdem = in.readLine();
			String inOrd[] = inOrdem.split(" ");

			No no = a.construirArv(inOrd, preOrd, 0, tamanho -1);

			a.FormarString(no);
			String aux = a.getString();

			String stringComparacao = aux.substring(0, aux.length() - 1);

			if(posOrdem.equals(stringComparacao)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}catch(Exception e) {

		}

	}

}