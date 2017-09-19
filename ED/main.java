import java.io.*;

class main {
    static class nos{
        private String conteudo;
        private nos proximo;
        
        public nos(){
            proximo = null;
	}
        public void setProx(nos prox) {
            this.proximo = prox;
        }
        
        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
	}
	
        public nos getProx() {
            return proximo;
	}

    }
    
    static class Lista{
        protected nos in;
        protected int tamanho;
        protected boolean vazia;
        
        public Lista(int t){
            in = null;		
            tamanho = t;
            vazia = true;
        }
        
        public void inserir(String o){
            nos novo = new nos();
            novo.setConteudo(o);
            novo.setProx(null);

            if(vazia){
                in = novo;
                vazia = false;
            }else{
                nos aux = in;
                
                while(aux.getProx() != null){
                    aux = aux.getProx();
                }
                aux.setProx(novo);
            }
        }
        
    
        public int busca(String t){
            int n = 0;
            nos aux = in;
            for(int i = 0; i < tamanho; i++){
                if(aux.getConteudo().startsWith(t)){
                    n++;
                }
                aux = aux.getProx();
            }
            return n;
        } 
    }
    
    public static void main(String[] args) throws Exception{
        int n;
        int m;
        String pre;
        String w;
        String aux;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        
        w = in.readLine();
        String[] partes = w.split(" ");
        n = Integer.parseInt(partes[0]);
        m = Integer.parseInt(partes[1]);

             
        Lista total = new Lista(n);

        for(int i = 0; i < n; i++){
            aux = in.readLine();
            total.inserir(aux);
        }

        for(int i = 0; i < m; i++){
            pre = in.readLine();

            int x = total.busca(pre);
            System.out.println(x);
        }
    }
}