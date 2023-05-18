package simuladorescalonamentointerface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Janela4Manual extends javax.swing.JFrame {
    private ArrayList<Processo> listaProcessos;
    private int tipo; 
    private int tempoTotal;
    private int tempoAtual;
    private int passo;
    private FCFS escalonadorFCFS;
    private RoundRobin escalonadorRR;
    
    
    public Janela4Manual() {
        initComponents();
        painelP.setBackground(java.awt.SystemColor.window);
        this.alinharTabela();
        this.tempoTotal = 0;
        ArrayList<Processo> listaProc = new ArrayList<>();
        listaProc.add(new Processo("A", 12, 5, 0));
        listaProc.add(new Processo("B", 15, 20, 0));
        listaProc.add(new Processo("C", 17, 10, 0));
        escalonadorFCFS = new FCFS(listaProc);
        this.sliderPasso.setValue(1);
        Processo primeiroProcesso = listaProc.get(0);
        this.tabelaExecucao.setValueAt(primeiroProcesso.getProcesso(), 0, 0);
        this.tabelaExecucao.setValueAt(primeiroProcesso.getTempoAux(), 0, 1);
        this.tabelaExecucao.setValueAt(primeiroProcesso.getChegada(), 0, 2);
        for (int i = 0; i < listaProc.size(); i++){
            Processo p = listaProc.get(i);
            this.tabelaProcessos.setValueAt(p.getProcesso(), i, 0);
            this.tabelaProcessos.setValueAt(p.getTempoAux(), i, 1);
            this.tabelaProcessos.setValueAt(p.getChegada(), i, 2);
        }
        for (Processo p : listaProc){
            this.tempoTotal += p.getChegada();
        }
        this.tipo = 0;
    }
    public Janela4Manual(ArrayList<Processo> listaProcessos, int tipo) {
        initComponents();
        painelP.setBackground(java.awt.SystemColor.window);
        this.tempoTotal = 0;
        this.listaProcessos = listaProcessos;
        this.tipo = tipo;
        this.alinharTabela();
        Comparator<Processo> comparador = (Processo p1, Processo p2) -> Integer.compare(p1.getChegada(), p2.getChegada());
        Collections.sort(this.listaProcessos, comparador);
        Processo primeiroProcesso = listaProcessos.get(0);
        this.tabelaExecucao.setValueAt(primeiroProcesso.getProcesso(), 0, 0);
        this.tabelaExecucao.setValueAt(primeiroProcesso.getTempoAux(), 0, 1);
        this.tabelaExecucao.setValueAt(primeiroProcesso.getChegada(), 0, 2);
        for (int i = 0; i < listaProcessos.size(); i++){
            Processo p = listaProcessos.get(i);
            this.tabelaProcessos.setValueAt(p.getProcesso(), i, 0);
            this.tabelaProcessos.setValueAt(p.getTempoAux(), i, 1);
            this.tabelaProcessos.setValueAt(p.getChegada(), i, 2);
        }
        escalonadorFCFS = new FCFS(this.listaProcessos);
        this.sliderPasso.setValue(1);
        this.lblTitulo.setText("Algoritmo First Come-First Served");
        for (Processo p : listaProcessos){
            this.tempoTotal += p.getChegada();
        }
    }
    public Janela4Manual(ArrayList<Processo> listaProcessos, int tipo, int quantum) {
        initComponents();
        painelP.setBackground(java.awt.SystemColor.window);
        this.listaProcessos = listaProcessos;
        this.tipo = tipo;
        this.tempoTotal = 0;
        this.alinharTabela();
        Comparator<Processo> comparador = (Processo p1, Processo p2) -> Integer.compare(p1.getChegada(), p2.getChegada());
        Collections.sort(this.listaProcessos, comparador);        
        Processo primeiroProcesso = listaProcessos.get(0);
        this.tabelaExecucao.setValueAt(primeiroProcesso.getProcesso(), 0, 0);
        this.tabelaExecucao.setValueAt(primeiroProcesso.getTempoAux(), 0, 1);
        this.tabelaExecucao.setValueAt(primeiroProcesso.getChegada(), 0, 2);
        for (int i = 0; i < listaProcessos.size(); i++){
            Processo p = listaProcessos.get(i);
            this.tabelaProcessos.setValueAt(p.getProcesso(), i, 0);
            this.tabelaProcessos.setValueAt(p.getTempoAux(), i, 1);
            this.tabelaProcessos.setValueAt(p.getChegada(), i, 2);
        }
        escalonadorRR = new RoundRobin(this.listaProcessos, quantum);
        for (Processo p : listaProcessos){
            this.tempoTotal += p.getChegada();
        }
        this.sliderPasso.setValue(1);
        this.lblTitulo.setText("Algoritmo Round-Robin");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelP = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProcessos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaExecucao = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaExecutados = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaEspera = new javax.swing.JTable();
        btnFinalizar = new javax.swing.JButton();
        btnPaP = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtLinhaTempo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sliderPasso = new javax.swing.JSlider();
        lblValPasso = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTempo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTMR = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTME = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        lblTitulo.setFont(new java.awt.Font("Noto Sans Mono", 0, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Titulo");

        tabelaProcessos.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        tabelaProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Processo", "Execução", "Chegada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaProcessos);

        tabelaExecucao.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        tabelaExecucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Processo", "Execução", "Chegada"
            }
        ));
        jScrollPane1.setViewportView(tabelaExecucao);

        tabelaExecutados.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        tabelaExecutados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Processo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaExecutados);

        tabelaEspera.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        tabelaEspera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Processo", "Execução"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabelaEspera);

        btnFinalizar.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnPaP.setFont(new java.awt.Font("Noto Sans Mono", 0, 15)); // NOI18N
        btnPaP.setText("Próximo Ciclo");
        btnPaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaPActionPerformed(evt);
            }
        });

        txtLinhaTempo.setColumns(20);
        txtLinhaTempo.setFont(new java.awt.Font("Noto Sans Mono", 0, 13)); // NOI18N
        txtLinhaTempo.setLineWrap(true);
        txtLinhaTempo.setRows(5);
        jScrollPane5.setViewportView(txtLinhaTempo);

        jLabel1.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        jLabel1.setText("Linha do Tempo");

        jLabel2.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        jLabel2.setText("Processos");

        jLabel3.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        jLabel3.setText("Processo em Execução");

        jLabel4.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        jLabel4.setText("Executados");

        jLabel5.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        jLabel5.setText("Lista de Espera");

        sliderPasso.setMaximum(10);
        sliderPasso.setMinimum(1);
        sliderPasso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderPassoStateChanged(evt);
            }
        });

        lblValPasso.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        lblValPasso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValPasso.setText("0");

        jLabel6.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        jLabel6.setText("Tempo Exec:");

        lblTempo.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        lblTempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTempo.setText("0");

        jLabel7.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        jLabel7.setText("TMR:");

        jLabel8.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        jLabel8.setText("TME:");

        lblTMR.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        lblTMR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTMR.setText("0");

        jLabel11.setText("Passo:");

        lblTME.setFont(new java.awt.Font("Noto Sans Mono", 0, 14)); // NOI18N
        lblTME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTME.setText("0");

        javax.swing.GroupLayout painelPLayout = new javax.swing.GroupLayout(painelP);
        painelP.setLayout(painelPLayout);
        painelPLayout.setHorizontalGroup(
            painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelPLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                        .addComponent(btnPaP)
                        .addGap(6, 6, 6))
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFinalizar)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelPLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(painelPLayout.createSequentialGroup()
                                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(40, 40, 40)
                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(painelPLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelPLayout.createSequentialGroup()
                                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(painelPLayout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblTMR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(painelPLayout.createSequentialGroup()
                                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(painelPLayout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblTME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGap(34, 34, 34))
                                                .addComponent(sliderPasso, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(painelPLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblValPasso, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        painelPLayout.setVerticalGroup(
            painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPaP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelPLayout.createSequentialGroup()
                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblTempo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblTMR))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblTME))
                        .addGap(10, 10, 10)
                        .addGroup(painelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lblValPasso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderPasso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFinalizar)
                .addGap(15, 15, 15))
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

    private void btnPaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaPActionPerformed
        
        if (this.tipo == 0){
            ArrayList<ArrayList<Processo>> lista = escalonadorFCFS.executar(this.passo);
            //Lista espera --> 1 | Executados -> 2 | Processos -> 0 | Processo Atual -> 3 | Linha Tempo -> 4
            ArrayList<Processo> processoAtual = lista.get(3);
            ArrayList<Processo> listaEspera = lista.get(1);
            ArrayList<Processo> listaExecutados = lista.get(2);
            if (processoAtual.size() == 2  || this.tempoAtual < this.tempoTotal){
                this.atualizarDados(listaEspera, processoAtual, listaExecutados);
            } else {
                this.atualizarDados(listaEspera, processoAtual, listaExecutados);
                JOptionPane.showMessageDialog(this, "Processo Finalizado!!");
                this.btnFinalizar.setText("Sair");
            }
        } else if (tipo == 1){
            ArrayList<ArrayList<Processo>> lista = escalonadorRR.executar(this.passo);
            //Lista espera --> 1 | Executados -> 2 | Processos -> 0 | Processo Atual -> 3 
            ArrayList<Processo> processoAtual = lista.get(3);
            ArrayList<Processo> listaEspera = lista.get(1);
            ArrayList<Processo> listaExecutados = lista.get(2);
            System.out.println("Tamanho lista espera: " + listaEspera.size());
            System.out.println("Tamanho proceesso atual: " + processoAtual.size());
            if (processoAtual.size() == 2  || this.tempoAtual < this.tempoTotal){
                this.atualizarDados(listaEspera, processoAtual, listaExecutados);
            } else {
                this.atualizarDados(listaEspera, processoAtual, listaExecutados);
                JOptionPane.showMessageDialog(this, "Processo Finalizado!!");
                this.btnFinalizar.setText("Sair");
            }
        } 
    }//GEN-LAST:event_btnPaPActionPerformed

    private void sliderPassoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderPassoStateChanged
        this.lblValPasso.setText(Integer.toString(this.sliderPasso.getValue()));
        this.passo = this.sliderPasso.getValue();
    }//GEN-LAST:event_sliderPassoStateChanged

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (this.btnFinalizar.getText().equalsIgnoreCase("Sair")){
            this.dispose();
        }
        if (this.tipo == 0){
            ArrayList<ArrayList<Processo>> lista = escalonadorFCFS.executar(-1);
            ArrayList<Processo> processoAtual = lista.get(3);
            ArrayList<Processo> listaEspera = lista.get(1);
            ArrayList<Processo> listaExecutados = lista.get(2);
            if (processoAtual.size() == 2){
                this.atualizarDados(listaEspera, processoAtual, listaExecutados);
            } else if (!this.btnFinalizar.getText().equalsIgnoreCase("Sair")){
                this.atualizarDados(listaEspera, processoAtual, listaExecutados);
                JOptionPane.showMessageDialog(this, "Processo Finalizado!!");
                this.btnFinalizar.setText("Sair");
            }
        } else if (this.tipo == 1){
            ArrayList<ArrayList<Processo>> lista = escalonadorRR.executar(-1);
            ArrayList<Processo> processoAtual = lista.get(3);
            ArrayList<Processo> listaEspera = lista.get(1);
            ArrayList<Processo> listaExecutados = lista.get(2);
            System.out.println("Tamanho lista espera: " + listaEspera.size());
            System.out.println("Tamanho proceesso atual: " + processoAtual.size());
            if (processoAtual.size() == 2){
                this.atualizarDados(listaEspera, processoAtual, listaExecutados);
            } else if (!this.btnFinalizar.getText().equalsIgnoreCase("Sair")){
                this.atualizarDados(listaEspera, processoAtual, listaExecutados);
                JOptionPane.showMessageDialog(this, "Processo Finalizado!!");
                this.btnFinalizar.setText("Sair");
            }
        }
        
    }//GEN-LAST:event_btnFinalizarActionPerformed
    
    private void limparTabelas(){
        for (int i = 0; i < 20; i++){
            this.tabelaEspera.setValueAt("", i, 0);
            this.tabelaEspera.setValueAt("", i, 1);
            this.tabelaExecutados.setValueAt("", i, 0);
        }
        this.tabelaExecucao.setValueAt("", 0, 0);
        this.tabelaExecucao.setValueAt("", 0, 1);
        this.tabelaExecucao.setValueAt("", 0, 2);
    }
    
    private void alinharTabela(){
        class AlinharCentro extends DefaultTableCellRenderer{
            public AlinharCentro(){
              setHorizontalAlignment(CENTER);
            }
        }
        TableCellRenderer tcr = new AlinharCentro();
        TableColumn column = tabelaEspera.getColumnModel().getColumn(0);
        column.setCellRenderer(tcr);
        column = tabelaEspera.getColumnModel().getColumn(1);
        column.setCellRenderer(tcr);
        column = tabelaProcessos.getColumnModel().getColumn(0);
        column.setCellRenderer(tcr);
        column = tabelaProcessos.getColumnModel().getColumn(1);
        column.setCellRenderer(tcr);
        column = tabelaProcessos.getColumnModel().getColumn(2);
        column.setCellRenderer(tcr);
        column = tabelaExecucao.getColumnModel().getColumn(0);
        column.setCellRenderer(tcr);
        column = tabelaExecucao.getColumnModel().getColumn(1);
        column.setCellRenderer(tcr);
        column = tabelaExecucao.getColumnModel().getColumn(2);
        column.setCellRenderer(tcr);
        column = tabelaExecutados.getColumnModel().getColumn(0);
        column.setCellRenderer(tcr);
    }
    

    private void atualizarDados(ArrayList<Processo> listaEspera, ArrayList<Processo> processoAtual, ArrayList<Processo> listaExecutados){
        limparTabelas();
        int count = 0;
        for (Processo p : listaEspera){
            this.tabelaEspera.setValueAt(p.getProcesso(), count, 0);
            String execucao = Integer.toString(p.getTempoAux());
            this.tabelaEspera.setValueAt(execucao, count, 1);
            count++;
        }
        count = 0;

        for (Processo p : listaExecutados){
            this.tabelaExecutados.setValueAt(p.getProcesso(), count, 0);
            count++;
        }
        count = 0;
        Processo tempoM = processoAtual.get(0);
        System.out.println("Tamanho ProcessoAtual: " + processoAtual.size());
        this.tempoAtual = tempoM.getTempo();
        
        if (processoAtual.size() == 2 && processoAtual.get(1).getTempoAux() > 0){
            Processo processoExec = processoAtual.get(1);
            this.tabelaExecucao.setValueAt(processoExec.getProcesso(), count, 0);
            String execucao = Integer.toString(processoExec.getTempoAux());
            this.tabelaExecucao.setValueAt(execucao, count, 1);
            String chegada = Integer.toString(processoExec.getChegada());
            this.tabelaExecucao.setValueAt(chegada, count, 2);
            this.lblTempo.setText(Integer.toString(tempoM.getTempo()));
        } else if (processoAtual.size() == 1   || this.tempoAtual < this.tempoTotal){
            this.lblTempo.setText(Integer.toString(tempoM.getTempoAux()));
            this.tabelaExecucao.setValueAt("", 0, 0);
            this.tabelaExecucao.setValueAt("", 0, 1);
            this.tabelaExecucao.setValueAt("", 0, 2);
            String tmr = Float.toString(tempoM.getTmr());
            int ponto = tmr.indexOf(".");
            tmr = tmr.substring(0, ponto+2);
            this.lblTMR.setText(tmr);
            String tme = Float.toString(tempoM.getTme());
            ponto = tme.indexOf(".");
            tme = tme.substring(0, ponto+2);
            this.lblTME.setText(tme);
        }
        this.txtLinhaTempo.setText(tempoM.getProcesso());
            
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
            java.util.logging.Logger.getLogger(Janela4Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela4Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela4Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela4Manual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela4Manual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnPaP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblTME;
    private javax.swing.JLabel lblTMR;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValPasso;
    private javax.swing.JPanel painelP;
    private javax.swing.JSlider sliderPasso;
    private javax.swing.JTable tabelaEspera;
    private javax.swing.JTable tabelaExecucao;
    private javax.swing.JTable tabelaExecutados;
    private javax.swing.JTable tabelaProcessos;
    private javax.swing.JTextArea txtLinhaTempo;
    // End of variables declaration//GEN-END:variables
}
