package simuladorescalonamentointerface;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Janela3Manual extends javax.swing.JFrame {
    private int quantum;
    private int tipo;
    private int qtdProcessos;
    private int countP;
    private ArrayList<Processo> listaProcessos = new ArrayList<>();
    
    public Janela3Manual() {
        initComponents();
    }
    //Caso FCFS
    public Janela3Manual(int tipo, int qtdProcessos) {
        initComponents();
        this.tipo = tipo;
        this.qtdProcessos = qtdProcessos;
        this.painelP.setBackground(java.awt.SystemColor.window);  
        this.countP = 0;
        this.alinharTabela();
        this.txtTitulo.setText("Algoritmo First Come-First Served");
        this.btnProx.setEnabled(false);
        this.lblNumP.setText(Integer.toString(this.countP+1));
    }
    //Caso RR
    public Janela3Manual(int tipo, int quantum, int qtdProcessos) {
        initComponents();
        this.quantum = quantum;
        this.tipo = tipo;
        this.qtdProcessos = qtdProcessos;
        this.painelP.setBackground(java.awt.SystemColor.window);  
        this.countP = 0;
        this.alinharTabela();
        this.txtTitulo.setText("Algoritmo Round-Robin");
        this.btnProx.setEnabled(false);
        this.lblNumP.setText(Integer.toString(this.countP+1));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaIn = new javax.swing.JTable();
        txtTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNumP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTempo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtChegada = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrioridade = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnProx = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tabelaIn.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        tabelaIn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Processo", "Tempo", "Chegada", "Prioridade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaIn.setGridColor(new java.awt.Color(30, 30, 30));
        tabelaIn.setRowHeight(22);
        tabelaIn.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tabelaIn.setSelectionForeground(new java.awt.Color(0, 0, 51));
        jScrollPane1.setViewportView(tabelaIn);

        txtTitulo.setFont(new java.awt.Font("Noto Sans Mono", 0, 18)); // NOI18N
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("Título");

        jLabel1.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        jLabel1.setText("Processo");

        lblNumP.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        lblNumP.setText("n");

        jLabel2.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        jLabel2.setText("->");

        jLabel3.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        jLabel3.setText("Nome :");

        txtNome.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        jLabel4.setText("Tempo :");

        txtTempo.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        jLabel5.setText("Chegada :");

        txtChegada.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        jLabel6.setText("Prioridade :");

        txtPrioridade.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        txtPrioridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrioridadeActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

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
            .addGroup(painelPLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtChegada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnAdd))
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(painelPLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                        .addComponent(btnProx)
                        .addGap(15, 15, 15))))
        );
        painelPLayout.setVerticalGroup(
            painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtTitulo)
                .addGap(18, 18, 18)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNumP)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnProx)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrioridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrioridadeActionPerformed
    }//GEN-LAST:event_txtPrioridadeActionPerformed
    
    //Adiciona o processo digitado pelo usuario 
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        txtNome.requestFocus();
        if (this.countP < this.qtdProcessos && this.validadarDados()){
            String nome = this.txtNome.getText().toUpperCase();
            int tempo = Integer.parseInt(this.txtTempo.getText());
            int chegada = Integer.parseInt(this.txtChegada.getText());
            int prioridade = Integer.parseInt(this.txtPrioridade.getText());
            
            Processo p = new Processo(nome, tempo, chegada, prioridade);
            this.listaProcessos.add(p);

            DefaultTableModel tabela = (DefaultTableModel) this.tabelaIn.getModel();
            tabela.addRow(p.getDados());
            
            this.countP++;
            
            this.lblNumP.setText(Integer.toString(this.countP+1));
            
            this.txtNome.setText("");
            this.txtChegada.setText("");
            this.txtPrioridade.setText("");
            this.txtTempo.setText("");
        }else if (this.countP >= this.qtdProcessos){
            JOptionPane.showMessageDialog(this, "ERRO: Impossível inserir mais processos.");
        }
        if (this.countP == this.qtdProcessos){
            this.btnProx.setEnabled(true);
        }                
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxActionPerformed
        this.dispose();
        //Lista de processos, tipo, quatum (caso rr)
        if (this.tipo == 0){
            Janela4Manual jm = new Janela4Manual(this.listaProcessos, this.tipo);
            jm.setVisible(true);
        } else{
            Janela4Manual jm = new Janela4Manual(this.listaProcessos, this.tipo, this.quantum);
            jm.setVisible(true);
        }
        
    }//GEN-LAST:event_btnProxActionPerformed
    
    //Faz a validação das informações digitadas pelo usuario 
    public boolean validadarDados(){
        boolean valido = true;
        if (this.txtNome.getText().trim().isEmpty()){
            valido = false;
            JOptionPane.showMessageDialog(this, "Campo Nome obrigatório!!");
        }
        if (this.txtChegada.getText().trim().isEmpty()){
            valido = false;
            JOptionPane.showMessageDialog(this, "Campo Chegada obrigatório!!");
        }
        if (this.txtTempo.getText().trim().isEmpty()){
            valido = false;
            JOptionPane.showMessageDialog(this, "Campo Tempo obrigatório!!");
        }
        if (this.txtPrioridade.getText().trim().isEmpty()){
            valido = false;
            JOptionPane.showMessageDialog(this, "Campo Prioridade obrigatório!!");
        }
        try{            
            Integer.valueOf(this.txtChegada.getText());            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "O campo Chegada aceita apenas números!");
            valido = false;
        }
        try{
            Integer.valueOf(this.txtTempo.getText());
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "O campo Tempo aceita apenas números!");
            valido = false;
        }
        try{            
            Integer.valueOf(this.txtPrioridade.getText());
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "O campo Prioridade aceita apenas números!");
            valido = false;
        }
        return valido;
    }
    
    //Alinha as informações para o centro de cada item da tabela
    private void alinharTabela(){
        class AlinharCentro extends DefaultTableCellRenderer{
            public AlinharCentro(){
              setHorizontalAlignment(CENTER); // ou LEFT, RIGHT, etc
            }
        }
        TableCellRenderer tcr = new AlinharCentro();
        TableColumn column = tabelaIn.getColumnModel().getColumn(0);
        column.setCellRenderer(tcr);
        column = tabelaIn.getColumnModel().getColumn(1);
        column.setCellRenderer(tcr);
        column = tabelaIn.getColumnModel().getColumn(2);
        column.setCellRenderer(tcr);
        column = tabelaIn.getColumnModel().getColumn(3);
        column.setCellRenderer(tcr);
    }
    
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
            java.util.logging.Logger.getLogger(Janela3Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela3Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela3Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela3Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela3Manual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnProx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumP;
    private javax.swing.JPanel painelP;
    private javax.swing.JTable tabelaIn;
    private javax.swing.JTextField txtChegada;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPrioridade;
    private javax.swing.JTextField txtTempo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
