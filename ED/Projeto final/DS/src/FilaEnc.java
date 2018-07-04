public class FilaEnc {
    class No {

        private int conteudo;
        private No prox;

        public No() {
            setProx(null);
        }

        public int getConteudo() {
            return conteudo;
        }

        public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
        }

        public No getProx() {
            return prox;
        }

        public void setProx(No prox) {
            this.prox = prox;
        }
    }
    
    private No inicio;  // aponta para o inicio da fila 
    private No fim;    	// aponta para o fim da fila  
    private int nElementos;

    
    //Cria uma Fila
    public FilaEnc() {
        inicio = null;
        fim = null;
        nElementos = 0;
    }

    /**
     * Verifica se a Fila está vazia
     */
    public boolean vazia() {
        if (nElementos == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtém o tamanho da Fila
     */
    public int tamanho() {
        return nElementos;
    }

    /**
     * Consulta o elemento do início da fila Retorna -1 se a fila estiver vazia
     */
    public int primeiro() {
        if (vazia()) {
            return -1; // Erro: Fila vazia 
        }
        return inicio.getConteudo();
    }
    
    public int elemento (int pos) {
	    No aux = inicio;
	    int cont = 1;

	    if (vazia()) {
	        return -1; // Consulta falhou 
	    }

	    if ((pos < 1) || (pos > tamanho())){
	        return -1; // Posicao invalida 
	    }

	    // Percorre a lista do 1o elemento até pos 
	    while (cont < pos){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	        cont++;
	    }

	    return aux.getConteudo();
    }

    /**
     * Insere um elemento no fim de uma fila Retorna false se a mem. for
     * insuficiente, true caso contrário
     */
    public boolean insere(int valor) {
        No novoNo = new No();
        novoNo.setConteudo(valor);
        novoNo.setProx(null);

        if (vazia()) {
            /*Inserção em fila vazia */
            inicio = novoNo;
        } else {
            fim.setProx(novoNo);
            /* liga com a fila */
        }
        fim = novoNo;
        /* atualiza o novo fim */
        nElementos++;
        return true;
    }

    /**
     * Retira o elemento do início da fila e retorna o seu valor Retorna -1 se a
     * fila estiver vazia.
     */
    public int remove() {
        if (vazia()) {
            return -1; // Erro: Fila vazia 
        }

        int valor = primeiro();
        No p = inicio;
        if (inicio == fim) { // Fila com 1 elemento 
            fim = null;
            inicio = null;
        } else {
            inicio = p.getProx();
        }
        /* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
        p = null;

        nElementos--;
        return valor;
    }

}
