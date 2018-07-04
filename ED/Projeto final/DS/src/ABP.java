public class ABP {
	private No raiz;
        private int nElementos;
        private No[] percurso;
        private int indice;
	
	public ABP(){
		raiz = null;
                nElementos = 0;
	}
	
	/** Verifica se a árvore está vazia */
	public boolean vazia (){
		return (raiz == null);
	}
        
        public int tamanho(){
            return nElementos;
        }
       
	/**Buscar recursivamente a partir da raiz.
	    Retorna o endereço se o elemento for
	    encontrado, caso contrário retorna NULL*/
	private No busca(No T, int valor) {
		if (T == null)
			return null;  // Arvore Vazia
		if(T.getConteudo() == valor)
			return T; 	// Elem. encontrado na raiz
		if (valor < T.getConteudo())
			return busca(T.getEsq(), valor);
                else
			return busca(T.getDir(), valor);
	}
	
	/**Buscar um elemento na ABP
            Retorna o endereço se o elemento for
            encontrado, caso contrário retorna NULL*/
	public No busca(int valor) {          
		if (raiz != null) 
			return busca(raiz, valor);
		
		return null;
	}
	
        private void exibePre(No T){
            if (T != null) {
                        percurso[indice++] = T;
			exibePre(T.getEsq());
			exibePre(T.getDir());
		}
               
	}

	public No[] exibePre() {
            percurso = new No[nElementos];
            
            if (raiz == null){
                System.out.println("Arvore vazia");
                return null;
            } else{
                indice = 0;
                exibePre(raiz);
                return percurso;
            }
	}
        
	/**Insere um nó em uma árvore ABP
	    Retorna 1 se a inserção for com sucesso.
	    Caso contrário retorna 0*/
	public boolean insere(int valor){
            No novoNo = new No();
            novoNo.setConteudo(valor);
            novoNo.setEsq(null);
            novoNo.setDir(null);
            nElementos++;

            if (raiz == null){ // Arvore vazia
                    raiz = novoNo;
                    return true;
            }

            // Procura a posicao correta pra inserir o novo no
            No aux = raiz;
            No p = null;
            while (aux != null) {
                    p = aux;
                    if (valor < aux.getConteudo())
                            aux = aux.getEsq();
                    else
                            aux = aux.getDir();
            }

            // Encontrou um nó folha para inserir
            novoNo.setY(p.getY() + 100);
                    
            if (valor < p.getConteudo()){
               novoNo.setX((int) (p.getX() - 700 + (p.getY() * 1.8)));
               p.setEsq(novoNo);    
            } else {
               novoNo.setX((int) (p.getX() + 700 - (p.getY() * 1.8)));
               p.setDir(novoNo);
            }
          
            return true;
	}
}
