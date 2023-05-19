package simuladorescalonamentointerface;

import javax.swing.JComponent;
import javax.swing.JSpinner.DefaultEditor;

/**
 *
 * @author filipe
 */

//Janela que indica a quantidade de processos que vai ser trabalhado 
public class Janela2Manual extends javax.swing.JFrame {
    private int tipo;
    private int quantum;
    public Janela2Manual(){
        initComponents();
    }
    public Janela2Manual(int tipo) {
        initComponents();
        JComponent editor = this.txtQtdeProc.getEditor();
        if (editor instanceof DefaultEditor defaultEditor) {
            defaultEditor.getTextField().setEditable(false);
        }
        this.painelP.setBackground(java.awt.SystemColor.window);
        this.tipo = tipo;
        this.txtTItulo.setText("Algoritmo First Come-First Served");
    }
    public Janela2Manual(int tipo, int quantum){
        initComponents();
        JComponent editor = this.txtQtdeProc.getEditor();
        if (editor instanceof DefaultEditor defaultEditor) {
            defaultEditor.getTextField().setEditable(false);
        }
        this.painelP.setBackground(java.awt.SystemColor.window);
        this.tipo = tipo;
        this.quantum = quantum;
        this.txtTItulo.setText("Algoritmo Round-Robin");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelP = new javax.swing.JPanel();
        txtTItulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtQtdeProc = new javax.swing.JSpinner();
        btnProx = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtTItulo.setFont(new java.awt.Font("Noto Sans Mono", 0, 18)); // NOI18N
        txtTItulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTItulo.setText("Titulo");

        jLabel2.setFont(new java.awt.Font("Noto Sans Mono", 0, 16)); // NOI18N
        jLabel2.setText("Quantidade de Processo: ");

        txtQtdeProc.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        txtQtdeProc.setModel(new javax.swing.SpinnerNumberModel(2, 2, 20, 1));
        txtQtdeProc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtQtdeProc.setEditor(new javax.swing.JSpinner.NumberEditor(txtQtdeProc, ""));
        txtQtdeProc.setFocusable(false);

        btnProx.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        btnProx.setText("Próximo");
        btnProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPLayout = new javax.swing.GroupLayout(painelP);
        painelP.setLayout(painelPLayout);
        painelPLayout.setHorizontalGroup(
            painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnProx)
                .addGap(61, 61, 61))
            .addGroup(painelPLayout.createSequentialGroup()
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtQtdeProc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(txtTItulo, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        painelPLayout.setVerticalGroup(
            painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(txtTItulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQtdeProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(btnProx)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxActionPerformed
        int qtdeProcessos = Integer.parseInt(this.txtQtdeProc.getValue().toString());
        if (tipo == 0){
            this.dispose();
            Janela3Manual jm = new Janela3Manual(this.tipo, qtdeProcessos);
            jm.setVisible(true);
        } else {
            this.dispose();
            Janela3Manual jm = new Janela3Manual(this.tipo, this.quantum, qtdeProcessos);
            jm.setVisible(true);
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
            java.util.logging.Logger.getLogger(Janela2Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela2Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela2Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela2Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela2Manual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProx;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel painelP;
    private javax.swing.JSpinner txtQtdeProc;
    private javax.swing.JLabel txtTItulo;
    // End of variables declaration//GEN-END:variables
}
