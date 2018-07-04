import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dijibuja extends javax.swing.JFrame {
    ImageIcon bola = new ImageIcon(getClass().getResource("Bola6.png"));
    // Declarar a ImageIcon com o nome da bola acesa(Botar imagem na pasta):
    ImageIcon bolaAcesa = new ImageIcon(getClass().getResource("Bola5.png"));
    ImageIcon seta1 = new ImageIcon(getClass().getResource("Seta1.png"));
    ImageIcon seta2 = new ImageIcon(getClass().getResource("Seta2.png"));
    ImageIcon SetaBaixo = new ImageIcon(getClass().getResource("SetaBaixo.png"));
    ImageIcon setaLonga1 = new ImageIcon(getClass().getResource("SetaLonga2.png"));
    ImageIcon setaLonga1R = new ImageIcon(getClass().getResource("SetaLonga2R.png"));
    ImageIcon setaLonga2 = new ImageIcon(getClass().getResource("SetaLonga3.png"));
    ImageIcon setaLonga2R = new ImageIcon(getClass().getResource("SetaLonga3R.png"));
    ImageIcon setaLonga3 = new ImageIcon(getClass().getResource("SetaLonga4.png"));
    ImageIcon setaLonga3R = new ImageIcon(getClass().getResource("SetaLonga4R.png"));
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();

    public static LSE2 lista = new LSE2();
    public static LDE listaDE = new LDE();
    public static PilhaEnc pilha = new PilhaEnc();
    public static FilaEnc fila = new FilaEnc();
    public static ABP arvore = new ABP();
    public static No[] percurso;
    public static ListaSeq listaS;
    public static int tamanhoSeq = 0;

    public Dijibuja() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public void Graficar(int p) {
        Graphics2D g2d = (Graphics2D) getGraphics();
        String figuras = jComboBox1.getSelectedItem().toString();
        Image img = bola.getImage();// Converte ImagemIcon para um objeto Image.
        Image img2 = bolaAcesa.getImage();// ---> imagem da bola acesa!
        Image seta = seta1.getImage();
        Image setaDupla = seta2.getImage();
        Image setaBaixo = SetaBaixo.getImage();
        Image setaRot1 = setaLonga1.getImage();
        Image setaRot2 = setaLonga1R.getImage();
        Image setaRot3 = setaLonga2.getImage();
        Image setaRot4 = setaLonga2R.getImage();
        Image setaRot5 = setaLonga3.getImage();
        Image setaRot6 = setaLonga3R.getImage();
        
        int x = 150;
        int y = 150;
        
        switch (figuras) {
            case "Selecione a estrutura de dados":
                JOptionPane.showMessageDialog(null, "Selecione uma estrutura");
                break;
            case "Lista sequencial":
                System.out.println("LISTA: ");
                for (int i = 1; i <= listaS.tamanhoMax(); i++) {
                    if(i==p){
                        System.out.print(listaS.elemento(i) + " ");
                        g2d.setColor(Color.green.darker());
                        g2d.drawImage(img2,x,y, this);// Desenha bola normal;
                        g2d.drawString("P: " + (i), x + 15, y - 10);
                        g2d.setColor(Color.white);
                     
                        if(listaS.elemento(i)== -1){
                            g2d.drawString("0", x + 15, y + 25);
                        }else{
                            g2d.drawString(listaS.elemento(i) + "", x + 15, y + 25);
                        }
                    }else{                  
                        System.out.print(listaS.elemento(i) + " ");
                        g2d.setColor(Color.black);
                        g2d.drawImage(img,x,y, this);// Desenha bola normal;
                        g2d.drawString("P: " + (i), x + 15, y - 10);
                        g2d.setColor(Color.white);
                     
                        if(listaS.elemento(i)== -1){
                            g2d.drawString("0", x + 15, y + 25);
                        }else{
                            g2d.drawString(listaS.elemento(i) + "", x + 15, y + 25);

                        }
                    }
                    x += 70;
                    if (x >= d.width - 150) {
                        x = 150;
                        y += 100;
                    }

                }
                System.out.println("");

                break;        
            case "Lista simplesmente encadeada":
                System.out.println("LISTA: ");
                for (int i = 1; i <= lista.tamanho(); i++) {
                    if (i == p) {
                        System.out.print(lista.elemento(i) + " ");
                        g2d.setColor(Color.green.darker());
                        // Aqui fica a imagem da bolinha quando acertar: troca img pelo nome da nova imagem.
                        g2d.drawImage(img2,x,y, this);
                        g2d.drawString("P: " + (i), x + 15, y - 10);
                        g2d.setColor(Color.white);
                        g2d.drawString(lista.elemento(i) + "", x + 15, y + (50 / 2));
                    } else {
                        System.out.print(lista.elemento(i) + " ");
                        g2d.setColor(Color.black);
                        g2d.drawImage(img,x,y, this); // desenha bola normal;
                        g2d.drawString("P: " + (i), x + 15, y - 10);
                        g2d.setColor(Color.white);
                        g2d.drawString(lista.elemento(i) + "", x + 15, y + (50 / 2));
                    }
                    
                    if(i != lista.tamanho()){
                        g2d.drawImage(seta,x+50,y+17, this);
                    }
                    
                    x += 70;
                    if (x >= d.width - 150) {
                        x = 150;
                        y += 100;
                    }

                }
                System.out.println("");

                break;
            case "Lista duplamente encadeada":
                System.out.println("LISTA: ");
                for (int i = 1; i <= listaDE.tamanho(); i++) {
                    if (i == p) {
                        System.out.print(listaDE.elemento(i) + " ");
                        g2d.setColor(Color.green.darker());
                        // Aqui fica a imagem da bolinha quando acertar: troca img pelo nome da nova imagem.
                        g2d.drawImage(img2,x,y, this);
                        g2d.drawString("P: " + (i), x + 15, y - 10);
                        g2d.setColor(Color.white);
                        g2d.drawString(listaDE.elemento(i) + "", x + 15, y + (50 / 2));

                    } else {
                        System.out.print(listaDE.elemento(i) + " ");
                        g2d.setColor(Color.black);
                        g2d.drawImage(img,x,y, this);
                        g2d.drawString("P: " + (i), x + 15, y - 10);
                        g2d.setColor(Color.white);
                        g2d.drawString(listaDE.elemento(i) + "", x + 15, y + (50 / 2));
                    }
                    
                    if(i != listaDE.tamanho()){
                        g2d.drawImage(setaDupla, x+50, y+14, this);
                    }

                    x += 70;
                    if (x >= d.width - 150) {
                        x = 150;
                        y += 100;
                    }

                }
                System.out.println("");

                break;
            case "Fila":
                 System.out.println("FILA: ");
                for (int i = 1; i <= fila.tamanho(); i++) {
                    if (i == p) {
                        System.out.print(fila.elemento(i) + " ");
                        g2d.setColor(Color.green.darker());
                        // Aqui fica a imagem da bolinha quando acertar: troca img pelo nome da nova imagem.
                        g2d.drawImage(img2,x,y, this);
                        g2d.drawString("P: " + (i), x + 15, y - 10);
                        g2d.setColor(Color.white);
                        g2d.drawString(fila.elemento(i) + "", x + 15, y + (50 / 2));

                    } else {
                        System.out.print(fila.elemento(i) + " ");
                        g2d.setColor(Color.black);
                        g2d.drawImage(img, x, y, this);
                        g2d.drawString("P: " + (i), x + 15, y - 10);
                        g2d.setColor(Color.white);
                        g2d.drawString(fila.elemento(i) + "", x + 15, y + (50 / 2));
                    }
                    
                   if(i != fila.tamanho()){
                        g2d.drawImage(seta,x+50,y+17, this);
                    }
                    x += 70;
                    if (x >= d.width - 150) {
                        x = 150;
                        y += 100;
                    }

                }
                break;
            case "Pilha":
                System.out.println("PILHA: ");
                y = d.height - 150;

                 for (int i = pilha.tamanho(); i >= 1; i--) {
                    if (i == p) {
                        System.out.print(pilha.elemento(i) + " ");
                        g2d.setColor(Color.green.darker());
                        // Aqui fica a imagem da bolinha quando acertar: troca img pelo nome da nova imagem.
                        g2d.drawImage(img2,x,y, this);
                        g2d.setColor(Color.white);
                        g2d.drawString(pilha.elemento(i) + "", x + 15, y + (50 / 2));
                    } else {
                        System.out.print(pilha.elemento(i) + " ");
                        g2d.setColor(Color.black);
                        g2d.drawImage(img, x, y, this);
                        g2d.setColor(Color.white);
                        g2d.drawString(pilha.elemento(i) + "", x + 15, y + (50 / 2));
                    }
                      if(i != pilha.tamanho()){
                        g2d.drawImage(setaBaixo,x+15,y+50, this);
                    }
                    y -= 70;
                    if (y <= 150) {
                        y = d.height - 150;
                        x += 100;
                    }

                }
                System.out.println("");

                break;
                
             case "Árvore de pesquisa":
                No aux;
                System.out.println("ÁRVORE(PREORDEM): ");
                for (int i = 0; i < arvore.tamanho(); i++) {
                    System.out.print(percurso[i].getConteudo() + " ");
                    aux = percurso[i];
                    if(i <= p){
                        g2d.drawImage(img2, aux.getX(), aux.getY(), this);
                        g2d.setColor(Color.white);
                        g2d.drawString(aux.getConteudo() + "", aux.getX() + 15, aux.getY() + (50 / 2));
                    } else {
                        g2d.drawImage(img, aux.getX(), aux.getY(), this); 
                        g2d.setColor(Color.white);
                        g2d.drawString(aux.getConteudo() + "", aux.getX() + 15, aux.getY() + (50 / 2));
                    }
                    
                     switch(aux.getY()){
                        case 150:
                            if(i != arvore.tamanho()){
                                g2d.drawImage(setaRot1, aux.getX() + 60, aux.getY() + 20, this);
                                g2d.drawImage(setaRot2, aux.getX() - 310, aux.getY() + 20, this);
                            }
                            break;
                        case 250:
                             if(i != arvore.tamanho()){
                                g2d.drawImage(setaRot3, aux.getX() + 60, aux.getY() + 10, this);
                                g2d.drawImage(setaRot4, aux.getX() - 200, aux.getY() + 10, this);
                            }
                            break;
                         case 350:
                             if(i != arvore.tamanho()){
                                g2d.drawImage(setaRot5, aux.getX() + 40, aux.getY() + 50, this);
                                g2d.drawImage(setaRot6, aux.getX() - 80, aux.getY() + 50, this);
                            }
                            break;
                    }
                }
                System.out.println("");
                break;

             
        }
                         //case "Lista sequencial": 
            

    }

    public void Graficar() {
        int x = 150;
        int y = 150;
        Graphics2D g2d = (Graphics2D) getGraphics();
        String figuras = jComboBox1.getSelectedItem().toString();
        Image img = bola.getImage();// Converte ImagemIcon para um objeto Image.
        Image seta = seta1.getImage();
        Image setaDupla = seta2.getImage();
        Image setaBaixo = SetaBaixo.getImage();
        Image setaRot1 = setaLonga1.getImage();
        Image setaRot2 = setaLonga1R.getImage();
        Image setaRot3 = setaLonga2.getImage();
        Image setaRot4 = setaLonga2R.getImage();
        Image setaRot5 = setaLonga3.getImage();
        Image setaRot6 = setaLonga3R.getImage();

        switch (figuras) {
            case "Selecione a estrutura de dados":
                JOptionPane.showMessageDialog(null, "Selecione uma estrutura");
                break;
            case "Lista simplesmente encadeada":
                System.out.println("LISTA: ");
                for (int i = 1; i <= lista.tamanho(); i++) {
                    System.out.print(lista.elemento(i) + " ");
                    g2d.setColor(Color.black);
                    g2d.drawImage(img,x,y, this);// Desenha bola normal;
                    g2d.drawString("P: " + (i), x + 15, y - 10);
                    g2d.setColor(Color.white);
                    g2d.drawString(lista.elemento(i) + "", x + 15, y + 25);
                    
                    if(i != lista.tamanho()){
                        g2d.drawImage(seta,x+50,y+17, this);
                    }
                    
                    x += 70;
                    if (x >= d.width - 150) {
                        x = 150;
                        y += 100;
                    }

                }
                System.out.println("");

                break;
             case "Lista sequencial":
                System.out.println("LISTA: ");
                for (int i = 1; i <= listaS.tamanhoMax(); i++) {
                    System.out.print(listaS.elemento(i) + " ");
                    g2d.setColor(Color.black);
                    g2d.drawImage(img,x,y, this);// Desenha bola normal;
                    g2d.drawString("P: " + (i), x + 15, y - 10);
                    g2d.setColor(Color.white);
                    if(listaS.elemento(i)== -1){
                        g2d.drawString("0", x + 15, y + 25);
                    }else{
                        g2d.drawString(listaS.elemento(i) + "", x + 15, y + 25);
                    }

                    x += 70;
                    if (x >= d.width - 150) {
                        x = 150;
                        y += 100;
                    }

                }
                System.out.println("");

                break;    
            case "Lista duplamente encadeada":
                
                System.out.println("LISTA DUPLAMENTE: ");
                for (int i = 1; i <= listaDE.tamanho(); i++) {
                    System.out.print(listaDE.elemento(i) + " ");
                    g2d.setColor(Color.black);
                    g2d.drawImage(img,x,y, this);//Desenha bola normal;
                    g2d.drawString("P: " + (i), x + 15, y - 10);
                    g2d.setColor(Color.white);
                    g2d.drawString(listaDE.elemento(i) + "", x + 15, y + 25);
                    
                    if(i != listaDE.tamanho()){
                        g2d.drawImage(setaDupla, x+50, y+14, this);
                    }
                     
                    x += 70;
                    if (x >= d.width - 150) {
                        x = 150;
                        y += 100;
                    }

                }
                System.out.println("");

                break;
            case "Fila":
                 System.out.println("FILA: ");
                for (int i = 1; i <= fila.tamanho(); i++) {
                    System.out.print(fila.elemento(i) + " ");
                    g2d.setColor(Color.black);
                    g2d.drawImage(img,x,y, this);// Desenha bola normal;
                   // g2d.draw(new Ellipse2D.Double(x, y, 50, 50));
                   // g2d.fill(new Ellipse2D.Double(x, y, 50, 50));
                    g2d.drawString("P: " + (i), x + 15, y - 10);
                    g2d.setColor(Color.white);
                    g2d.drawString(fila.elemento(i) + "", x + 15, y + (50 / 2));
                    
                    if(i != fila.tamanho()){
                        g2d.drawImage(seta,x+50,y+17, this);
                    }
                    x += 70;
                    if (x >= d.width - 150) {
                        x = 150;
                        y += 100;
                    }

                }
                System.out.println("");
                break;
            case "Pilha":
                y = d.height - 150;
                System.out.println("PILHA: ");
                for (int i = pilha.tamanho(); i >= 1; i--) {
                    System.out.print(pilha.elemento(i) + " ");
                    g2d.setColor(Color.black);
                    g2d.drawImage(img,x,y, this);//Desenha bola normal;
                    //g2d.draw(new Ellipse2D.Double(x, y, 50, 50));
                    //g2d.fill(new Ellipse2D.Double(x, y, 50, 50));
                    g2d.setColor(Color.white);
                    g2d.drawString(pilha.elemento(i) + "", x + 15, y + (50 / 2));
                    
                    if(i != pilha.tamanho()){
                        g2d.drawImage(setaBaixo,x+15,y+50, this);
                    }

                    y -= 70;
                    if (y <= 150) {
                        y = d.height - 150;
                        x += 100;
                    }
                    
                }
                System.out.println("");
                break;
            
            case "Árvore de pesquisa":
                percurso = arvore.exibePre();
                No aux;
                System.out.println("ÁRVORE(PREORDEM): ");
                for (int i = 0; i < arvore.tamanho(); i++) {
                    aux = percurso[i];
                    System.out.print(percurso[i].getConteudo() + " ");
                    g2d.drawImage(img, aux.getX(), aux.getY(), this); 
                    g2d.setColor(Color.white);
                    g2d.drawString(aux.getConteudo() + "", aux.getX() + 15, aux.getY() + (50 / 2));
                    
                    switch(aux.getY()){
                        case 150:
                            if(i != arvore.tamanho()){
                                g2d.drawImage(setaRot1, aux.getX() + 60, aux.getY() + 20, this);
                                g2d.drawImage(setaRot2, aux.getX() - 310, aux.getY() + 20, this);
                            }
                            break;
                        case 250:
                             if(i != arvore.tamanho()){
                                g2d.drawImage(setaRot3, aux.getX() + 60, aux.getY() + 10, this);
                                g2d.drawImage(setaRot4, aux.getX() - 200, aux.getY() + 10, this);
                            }
                            break;
                         case 350:
                             if(i != arvore.tamanho()){
                                g2d.drawImage(setaRot5, aux.getX() + 40, aux.getY() + 50, this);
                                g2d.drawImage(setaRot6, aux.getX() - 80, aux.getY() + 50, this);
                            }
                            break;
                    }
                    
                    
                }
                System.out.println("");
                break;

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton1.setVisible(false);
        jButton2 = new javax.swing.JButton();
        jButton2.setVisible(false);
        jButton3 = new javax.swing.JButton();
        jButton3.setVisible(false);
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setVisible(false);
        jTextField2 = new javax.swing.JTextField();
        jTextField2.setVisible(false);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estrutura de Dados");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a estrutura de dados", "Lista simplesmente encadeada", "Lista sequencial", "Lista duplamente encadeada", "Pilha", "Fila", "Árvore de pesquisa" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Graphics g = getGraphics();
        super.paint(g);

        String opcao = jComboBox1.getSelectedItem().toString();
        
        switch (opcao) {
            case "Selecione a estrutura de dados":
                JOptionPane.showMessageDialog(null, "Selecione uma estrutura");
                break;
            case "Lista simplesmente encadeada":
                if (jTextField2.getText().equals("")) {
                    JOptionPane.showInputDialog(null, "Preencha todos os campos");
                    jTextField1.requestFocus();
                } else {
                    lista.remove(Integer.parseInt(jTextField2.getText()));
                    jTextField1.setText("");
                    jTextField2.setText("");
                    Graficar();
                }
                break;
            case "Lista sequencial":
                 if (jTextField2.getText().equals("")) {
                    JOptionPane.showInputDialog(null, "Preencha todos os campos");
                    jTextField1.requestFocus();
                } else {
                    listaS.remove(Integer.parseInt(jTextField2.getText()));
                    jTextField1.setText("");
                    jTextField2.setText("");
                    Graficar();
                }
                
                break;
            case "Lista duplamente encadeada":
                if (jTextField2.getText().equals("")) {
                    JOptionPane.showInputDialog(null, "Preencha todos os campos");
                    jTextField1.requestFocus();
                } else {
                    listaDE.remove(Integer.parseInt(jTextField2.getText()));
                    jTextField1.setText("");
                    jTextField2.setText("");
                    Graficar();
                }
                break;
            case "Fila":
                fila.remove();
                jTextField1.setText("");
                jTextField2.setText("");
                Graficar();
                break;
            case "Pilha":
                pilha.pop();
                jTextField1.setText("");
                jTextField2.setText("");
                Graficar();              
                break;
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Graphics g = getGraphics();
        super.paint(g);
                
        lista = new LSE2();
        listaDE = new LDE();
        pilha = new PilhaEnc();
        fila = new FilaEnc();
        arvore = new ABP();

    
        String opcao = jComboBox1.getSelectedItem().toString();
        switch (opcao) {
            case "Selecione a estrutura de dados":
                jLabel1.setText("");
                jLabel2.setText("");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField1.setVisible(false);
                jTextField2.setVisible(false);
                jButton1.setVisible(false);
                jButton2.setVisible(false);
                jButton3.setVisible(false);
                jButton1.setText("Inserir");
                jButton2.setText("Remover");
                jButton3.setVisible(true);
                break;
            case "Lista sequencial":  
                tamanhoSeq = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho da lista:"));
                listaS = new ListaSeq(tamanhoSeq);
                jLabel1.setText("Valor");
                jLabel2.setText("Posição");
                jTextField1.setEditable(true);
                jTextField2.setEditable(true);
                jTextField1.setVisible(true);
                jTextField2.setVisible(true);
                jTextField1.setText("");
                jTextField2.setText("");
                jButton1.setText("Inserir");
                jButton2.setText("Remover");
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                 Graficar();
                break;    
            case "Lista simplesmente encadeada":
                jLabel1.setText("Valor");
                jLabel2.setText("Posição");
                jTextField1.setEditable(true);
                jTextField2.setEditable(true);
                jTextField1.setVisible(true);
                jTextField2.setVisible(true);
                jTextField1.setText("");
                jTextField2.setText("");
                jButton1.setText("Inserir");
                jButton2.setText("Remover");
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                break;

            case "Lista duplamente encadeada":
                jLabel1.setText("Valor");
                jLabel2.setText("Posição");
                jTextField1.setEditable(true);
                jTextField2.setEditable(true);
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField1.setVisible(true);
                jTextField2.setVisible(true);
                jButton1.setText("Inserir");
                jButton2.setText("Remover");
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                break;

            case "Pilha":
                jLabel1.setText("Valor");
                jLabel2.setText("");
                jTextField1.setEditable(true);
                jTextField2.setEditable(false);
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField1.setVisible(true);
                jTextField2.setVisible(false);
                jButton1.setText("Push");
                jButton2.setText("Pop");
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton3.setVisible(false);
                break;

            case "Fila":
                jLabel1.setText("Valor");
                jLabel2.setText("");
                jTextField1.setEditable(true);
                jTextField2.setEditable(false);
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField1.setVisible(true);
                jTextField2.setVisible(false);
                jButton1.setText("Inserir");
                jButton2.setText("Remover");
                jButton1.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton3.setVisible(false);
                break;
                
            case "Árvore de pesquisa":
                jLabel1.setText("Valor");
                jLabel2.setText("");
                jTextField1.setEditable(true);
                jTextField2.setEditable(false);
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField1.setVisible(true);
                jTextField2.setVisible(false);
                jButton1.setText("Inserir");
                jButton2.setText("Remover");
                jButton1.setVisible(true);
                jButton2.setVisible(false);
                jButton3.setVisible(true);
                break;

        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Graphics g = getGraphics();
        super.paint(g);
        
        String opcoes = jComboBox1.getSelectedItem().toString();

        switch (opcoes) {
            case "Lista simplesmente encadeada":
                if (jTextField1.getText().equals("") || jTextField2.getText().equals("")) {
                    JOptionPane.showInputDialog(null, "Digite todos os campos");
                    jTextField1.requestFocus();
                } else {
                    lista.insere(Integer.parseInt(jTextField2.getText()), Integer.parseInt(jTextField1.getText()));
                    jTextField1.setText("");
                    jTextField2.setText("");
                    Graficar();
                }
                break;
            case "Lista sequencial": 
                if (jTextField1.getText().equals("") || jTextField2.getText().equals("")) {
                    JOptionPane.showInputDialog(null, "Digite todos os campos");
                    jTextField1.requestFocus();
                } else {
                    listaS.insere(Integer.parseInt(jTextField2.getText()), Integer.parseInt(jTextField1.getText()));
                    jTextField1.setText("");
                    jTextField2.setText("");
                    Graficar();
                }
                
                break;
            case "Lista duplamente encadeada":
                if (jTextField1.getText().equals("") || jTextField2.getText().equals("")) {
                    JOptionPane.showInputDialog(null, "Digite todos os campos");
                    jTextField1.requestFocus();
                } else {
                    listaDE.insere(Integer.parseInt(jTextField2.getText()), Integer.parseInt(jTextField1.getText()));
                    jTextField1.setText("");
                    jTextField2.setText("");
                    Graficar();
                }
                break;
            case "Pilha":
                if (jTextField1.getText().equals("")) {
                    JOptionPane.showInputDialog(null, "Digite todos os campos");
                    jTextField1.requestFocus();
                } else {
                    pilha.push(Integer.parseInt(jTextField1.getText()));
                    jTextField1.setText("");
                    jTextField2.setText("");
                    Graficar();
                }
                break;
            case "Fila":
                if (jTextField1.getText().equals("")) {
                    JOptionPane.showInputDialog(null, "Digite todos os campos");
                    jTextField1.requestFocus();
                } else {
                    fila.insere(Integer.parseInt(jTextField1.getText()));
                    jTextField1.setText("");
                    jTextField2.setText("");
                    Graficar();
                }
                break;
                
            case "Árvore de pesquisa":
                if (jTextField1.getText().equals("")) {
                    JOptionPane.showInputDialog(null, "Digite todos os campos");
                    jTextField1.requestFocus();
                } else {
                    arvore.insere(Integer.parseInt(jTextField1.getText()));
                    jTextField1.setText("");
                    jTextField2.setText("");
                    Graficar();
                }
                break;
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int valor = Integer.parseInt(jTextField1.getText());
        int pos = -1;
        String opcoes = jComboBox1.getSelectedItem().toString();
        jTextField1.setText("");
        jTextField2.setText("");
        
        switch (opcoes) {
            case "Lista simplesmente encadeada":
                for (int i = 1; i <= lista.tamanho(); i++) {
                    if (lista.elemento(i) == valor) {
                        pos = i;
                        break;
                    }
                }
                break;
            case "Lista sequencial":
                for (int i = 1; i <= listaS.tamanho(); i++) {
                    if (listaS.elemento(i) == valor) {
                        pos = i;
                   
                        break;
                    }
                }
                
                break;    
            case "Lista duplamente encadeada":
                for (int i = 1; i <= listaDE.tamanho(); i++) {
                    if (listaDE.elemento(i) == valor) {
                        pos = i;
                        break;
                    }
                }
                break;
            case "Pilha":
                
                break;
            case "Fila":
                break;
                
            case "Árvore de pesquisa":
                percurso = arvore.exibePre();
                for (int i = 1; i <= arvore.tamanho(); i++) {
                    if (percurso[i].getConteudo() == valor) {
                        pos = i;
                        break;
                    }
                }
                break;

        }

        if (pos > -1) {
            Graphics g = getGraphics();
            super.paint(g);
            Graficar(pos);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dijibuja.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dijibuja.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dijibuja.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dijibuja.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dijibuja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
