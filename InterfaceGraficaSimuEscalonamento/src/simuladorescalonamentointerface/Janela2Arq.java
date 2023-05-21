package simuladorescalonamentointerface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFileChooser;

/**
 *
 * @author filipe
 */
public class Janela2Arq extends javax.swing.JFrame {
    private int quantum;
    private String pathEntrada;
    private String pathSaida;
    private int tipo; //1 - RR 0 - FCFS
    
    public Janela2Arq(){
        initComponents();
    }
    
    //Caso seja FCFS
    public Janela2Arq(String pathEntrada, int tipo){
        initComponents();
        if(tipo == 0){
            tituloLbl.setText("Método First Come-First Served");
        } else{
            tituloLbl.setText("Método Round-Robin");
        }
        this.tipo = tipo;
        this.pathEntrada = pathEntrada;
        painelP.setBackground(java.awt.SystemColor.window);
    }
    //Caso seja RR
    public Janela2Arq(String pathEntrada, int tipo, int quantum){
        initComponents();
        tituloLbl.setText("Método Round-Robin");
        this.tipo = tipo;
        this.pathEntrada = pathEntrada;
        painelP.setBackground(java.awt.SystemColor.window);
        this.quantum = quantum;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelP = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        btnProcurar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tituloLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Noto Sans Mono", 0, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        jLabel2.setText("Arquivo: ");

        txtPath.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N

        btnProcurar.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        jButton2.setText("Executar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Noto Sans Mono", 0, 16)); // NOI18N
        jLabel3.setText("Selecione o local de saída do arquivo:");

        tituloLbl.setFont(new java.awt.Font("Noto Sans Mono", 0, 18)); // NOI18N
        tituloLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLbl.setText("Titulo");
        tituloLbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout painelPLayout = new javax.swing.GroupLayout(painelP);
        painelP.setLayout(painelPLayout);
        painelPLayout.setHorizontalGroup(
            painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                        .addComponent(tituloLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))))
            .addGroup(painelPLayout.createSequentialGroup()
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(lblTitulo))
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(painelPLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnProcurar)))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        painelPLayout.setVerticalGroup(
            painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(tituloLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo)
                .addGap(73, 73, 73)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnProcurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resultado = fc.showOpenDialog(null);
        if(resultado == JFileChooser.APPROVE_OPTION){
            File arquivo = fc.getSelectedFile();
            txtPath.setText(arquivo.getPath());
        }
        this.pathSaida = txtPath.getText();
    }//GEN-LAST:event_btnProcurarActionPerformed
    
    //Ao apertar o botão próximo ele identifica e executa o algoritmo escolhido 
    //  e salva na pasta de destino
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<String> linhasArq = new ArrayList<>();
        if(this.tipo == 0){
            this.pathSaida += "/saidaFCFS";
        } else{
            this.pathSaida += "/saidaRR";
        }
        ManipuladorArquivosTXT manipulador = new ManipuladorArquivosTXT();
        try {
            manipulador.leitor(this.pathEntrada);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        linhasArq = manipulador.getLinhas();
        int tamanho = 0;
        
        ArrayList<String[]> listaFrases = new ArrayList<>();
        
        for (String l : linhasArq){
            String[] palavras = l.split("-");
            tamanho = palavras.length;
            listaFrases.add(palavras);
        }
        String[] processos = new String[tamanho - 1];
        Integer[] tempos = new Integer[tamanho - 1];
        Integer[] chegada = new Integer[tamanho - 1];
        Integer[] prioridade = new Integer[tamanho -1];
        ArrayList<Processo> listaProcessos = new ArrayList<>();
        
        for(String[] linha : listaFrases){
            for(int i = 1; i<tamanho; i++){
                if (linha[0].equalsIgnoreCase("Processo")){
                    processos[i-1] = linha[i];
                } else if (linha[0].equalsIgnoreCase("Tempo")){
                    tempos[i-1] = Integer.valueOf(linha[i]);
                } else if (linha[0].equalsIgnoreCase("Chegada")){
                    chegada[i-1]= Integer.valueOf(linha[i]);
                } else if (linha[0].equalsIgnoreCase("Prioridade")){
                    prioridade[i-1] = Integer.valueOf(linha[i]);
                }
            }
        }
        
        //Armazenando as informações dentro de processo
        for (int i = 0; i < tamanho - 1; i++){
            listaProcessos.add(new Processo(processos[i], tempos[i], chegada[i], prioridade[i]));
        }
        
        //Ordenando a lista de processos por chegada
        Comparator<Processo> comparador = (Processo p1, Processo p2) -> Integer.compare(p1.getChegada(), p2.getChegada());
        Collections.sort(listaProcessos, comparador);
        
        if (this.tipo == 0){
            try {
                new FCFS((ArrayList<Processo>) listaProcessos.clone(), this.pathSaida);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else{
            try {
                new RoundRobin((ArrayList<Processo>) listaProcessos.clone(), this.quantum, this.pathSaida);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        this.dispose();
        JanelaFinalArq jf = new JanelaFinalArq();
        jf.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Janela2Arq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela2Arq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela2Arq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela2Arq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela2Arq().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelP;
    private javax.swing.JLabel tituloLbl;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
