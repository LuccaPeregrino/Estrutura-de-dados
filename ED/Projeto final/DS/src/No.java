public class No {
            private int conteudo;
            private int y;
            private int x;
            private No esq;
            private No dir;

            public No(){
                    esq = null;
                    dir = null;
                    y = 150;
                    x = 800;
            }

            public int getConteudo() {
                    return conteudo;
            }
            public void setConteudo(int conteudo) {
                    this.conteudo = conteudo;
            }
            
             public int getY() {
                    return y;
            }
            public void setY(int y) {
                    this.y = y;
            }
            
             public int getX() {
                    return x;
            }
            public void setX(int x) {
                    this.x = x;
            }
            
            public No getEsq() {
                    return esq;
            }
            public void setEsq(No esq) {
                    this.esq = esq;
            }

            public No getDir() {
                    return dir;
            }

            public void setDir(No dir) {
                    this.dir = dir;
            }
            
    }