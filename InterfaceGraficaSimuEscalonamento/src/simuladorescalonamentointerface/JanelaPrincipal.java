package simuladorescalonamentointerface;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author filipe
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    private int quantum;
    private int tipo;

    public JanelaPrincipal() {
        initComponents();
        //Inicialização da janela 
        painelArquivo.setVisible(false);
        painelQuantum.setVisible(false);
        painel1.setBackground(java.awt.SystemColor.window);
        btnProx.setEnabled(false);
        this.painelArquivo.setBackground(java.awt.SystemColor.window);
        this.painelQuantum.setBackground(java.awt.SystemColor.window);
        
        //Deixando o botão próximo desabilitado até que duas opções sejam selecionadas 
        ChangeListener cl = (ChangeEvent e) -> {
            if (buttonGroup1.getSelection() != null && buttonGroup2.getSelection() != null){
                btnProx.setEnabled(true);
            } else {
                btnProx.setEnabled(false);
            }
        };
        this.radioArquivoOP.addChangeListener(cl);
        this.radioFCFS.addChangeListener(cl);
        this.radioManualOP.addChangeListener(cl);
        this.radioRR.addChangeListener(cl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox<>();
        painel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radioArquivoOP = new javax.swing.JRadioButton();
        radioManualOP = new javax.swing.JRadioButton();
        radioFCFS = new javax.swing.JRadioButton();
        radioRR = new javax.swing.JRadioButton();
        painelArquivo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtArqPath = new javax.swing.JTextField();
        btnProcurarArquivo = new javax.swing.JButton();
        btnProx = new javax.swing.JButton();
        painelQuantum = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboQuantum = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(747, 515));

        painel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painel1.setPreferredSize(new java.awt.Dimension(747, 515));

        jLabel1.setFont(new java.awt.Font("Noto Sans Mono", 0, 16)); // NOI18N
        jLabel1.setText("Entrada");

        jLabel2.setFont(new java.awt.Font("Noto Sans Mono", 0, 16)); // NOI18N
        jLabel2.setText("Tipo de Escalonamento");

        jLabel3.setFont(new java.awt.Font("Noto Sans Mono", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TRABALHO 2 - ALGORITMOS DE ESCALONAMENTO");
        jLabel3.setToolTipText("");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        buttonGroup1.add(radioArquivoOP);
        radioArquivoOP.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        radioArquivoOP.setText("Arquivo");
        radioArquivoOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioArquivoOPActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioManualOP);
        radioManualOP.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        radioManualOP.setText("Manual");
        radioManualOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioManualOPActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioFCFS);
        radioFCFS.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        radioFCFS.setText("FCFS");
        radioFCFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFCFSActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioRR);
        radioRR.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        radioRR.setText("Round-Robin");
        radioRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioRRActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        jLabel4.setText("Arquivo:");

        txtArqPath.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        txtArqPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArqPathActionPerformed(evt);
            }
        });

        btnProcurarArquivo.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        btnProcurarArquivo.setText("Procurar");
        btnProcurarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelArquivoLayout = new javax.swing.GroupLayout(painelArquivo);
        painelArquivo.setLayout(painelArquivoLayout);
        painelArquivoLayout.setHorizontalGroup(
            painelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelArquivoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArqPath, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProcurarArquivo)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        painelArquivoLayout.setVerticalGroup(
            painelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelArquivoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtArqPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcurarArquivo))
                .addContainerGap())
        );

        painelArquivoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnProcurarArquivo, jLabel4, txtArqPath});

        btnProx.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        btnProx.setText("Próximo");
        btnProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        jLabel5.setText("Quantum:");

        comboQuantum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));

        javax.swing.GroupLayout painelQuantumLayout = new javax.swing.GroupLayout(painelQuantum);
        painelQuantum.setLayout(painelQuantumLayout);
        painelQuantumLayout.setHorizontalGroup(
            painelQuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelQuantumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        painelQuantumLayout.setVerticalGroup(
            painelQuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelQuantumLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(painelQuantumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout painel1Layout = new javax.swing.GroupLayout(painel1);
        painel1.setLayout(painel1Layout);
        painel1Layout.setHorizontalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel1Layout.createSequentialGroup()
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painel1Layout.createSequentialGroup()
                        .addContainerGap(34, Short.MAX_VALUE)
                        .addComponent(painelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(radioArquivoOP)
                                .addComponent(radioManualOP))
                            .addGroup(painel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                        .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioFCFS)
                            .addComponent(jLabel2)
                            .addComponent(radioRR)
                            .addComponent(painelQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProx)
                .addGap(54, 54, 54))
            .addGroup(painel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painel1Layout.setVerticalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioArquivoOP)
                    .addComponent(radioFCFS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioManualOP)
                    .addComponent(radioRR))
                .addGap(3, 3, 3)
                .addComponent(painelQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(painelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnProx)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radioArquivoOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioArquivoOPActionPerformed
       this.painelArquivo.setVisible(true);
    }//GEN-LAST:event_radioArquivoOPActionPerformed

    private void radioManualOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioManualOPActionPerformed
        this.painelArquivo.setVisible(false);
    }//GEN-LAST:event_radioManualOPActionPerformed

    private void btnProcurarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarArquivoActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = fc.showOpenDialog(null);
        if(resultado == JFileChooser.APPROVE_OPTION){
            File arquivo = fc.getSelectedFile();
            txtArqPath.setText(arquivo.getPath());
        } 
    }//GEN-LAST:event_btnProcurarArquivoActionPerformed

    private void txtArqPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArqPathActionPerformed
    }//GEN-LAST:event_txtArqPathActionPerformed

    private void radioRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRRActionPerformed
        this.painelQuantum.setVisible(true);
        this.tipo = 1;
    }//GEN-LAST:event_radioRRActionPerformed

    private void radioFCFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFCFSActionPerformed
        this.painelQuantum.setVisible(false);
        this.tipo = 0;
    }//GEN-LAST:event_radioFCFSActionPerformed

    private void btnProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxActionPerformed
        this.quantum = this.comboQuantum.getSelectedIndex();
        if(this.radioArquivoOP.isSelected()){
            if(this.txtArqPath.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Não foi inserido um caminho para o arquivo de entrada.");
            }else{
                this.dispose();
                if(this.radioFCFS.isSelected()){
                    Janela2Arq j2A = new Janela2Arq(this.txtArqPath.getText(), this.tipo);
                    j2A.setVisible(true);
                } else if(this.radioRR.isSelected()){
                    Janela2Arq j2A = new Janela2Arq(this.txtArqPath.getText(), this.tipo, this.quantum);
                    j2A.setVisible(true);
                }
            }
        } else if (this.radioManualOP.isSelected()){
            this.dispose();
            if(this.tipo == 0){
                Janela2Manual jm = new Janela2Manual(this.tipo);
                jm.setVisible(true);
            }else{
                Janela2Manual jm = new Janela2Manual(this.tipo, this.quantum);
                jm.setVisible(true);
            }            
        }
    }//GEN-LAST:event_btnProxActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcurarArquivo;
    private javax.swing.JButton btnProx;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboQuantum;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel painel1;
    private javax.swing.JPanel painelArquivo;
    private javax.swing.JPanel painelQuantum;
    private javax.swing.JRadioButton radioArquivoOP;
    private javax.swing.JRadioButton radioFCFS;
    private javax.swing.JRadioButton radioManualOP;
    private javax.swing.JRadioButton radioRR;
    private javax.swing.JTextField txtArqPath;
    // End of variables declaration//GEN-END:variables
}
