/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecaocartoes;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author geova
 */
public class ColecaoCartoes extends javax.swing.JFrame {

    ColecionadorImpl colecionador;

    /**
     * Creates new form ColecaoCartoes
     *
     * @param colecionador
     */
    public ColecaoCartoes(ColecionadorImpl colecionador) {
        initComponents();
        jPanelAdd.setVisible(false);
        jPanelExchange.setVisible(false);
        this.colecionador = colecionador;
        CBType.setModel(new DefaultComboBoxModel<>(Colecao.Cartao.values()));
        CBTypeEx1.setModel(new DefaultComboBoxModel<>(Colecao.Cartao.values()));
        CBTypeEx2.setModel(new DefaultComboBoxModel<>(Colecao.Cartao.values()));
        this.setTitle("Colecionador " + this.colecionador.id);
    }

    public ColecaoCartoes() {
        initComponents();
        jPanelAdd.setVisible(false);
        CBType.setModel(new DefaultComboBoxModel<>(Colecao.Cartao.values()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jBAddCards = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelAdd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TQntd = new javax.swing.JTextField();
        CBType = new javax.swing.JComboBox<>();
        BNew = new javax.swing.JButton();
        BClean = new javax.swing.JButton();
        BRefresh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        BRefresh2 = new javax.swing.JButton();
        BGetCollections = new javax.swing.JButton();
        BExchange = new javax.swing.JButton();
        jPanelExchange = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTQntd1 = new javax.swing.JTextField();
        jTQntd2 = new javax.swing.JTextField();
        CBTypeEx1 = new javax.swing.JComboBox<>();
        CBTypeEx2 = new javax.swing.JComboBox<>();
        BExchangeCards = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBAddCards.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add(1).png"))); // NOI18N
        jBAddCards.setText("Adicionar Cartões");
        jBAddCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddCardsActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo", "Qntd"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Tipo");

        jLabel2.setText("Quantidade");

        BNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        BNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNewActionPerformed(evt);
            }
        });

        BClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wiping.png"))); // NOI18N
        BClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAddLayout = new javax.swing.GroupLayout(jPanelAdd);
        jPanelAdd.setLayout(jPanelAddLayout);
        jPanelAddLayout.setHorizontalGroup(
            jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CBType, 0, 73, Short.MAX_VALUE)
                    .addComponent(TQntd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(115, 115, 115))
        );
        jPanelAddLayout.setVerticalGroup(
            jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TQntd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BClean))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        BRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh-button.png"))); // NOI18N
        BRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBAddCards)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BRefresh))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBAddCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Minha Coleção", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Colecionador", "Coleção", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        BRefresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh-button.png"))); // NOI18N
        BRefresh2.setToolTipText("");
        BRefresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRefresh2ActionPerformed(evt);
            }
        });

        BGetCollections.setText("Todas as Coleções");
        BGetCollections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGetCollectionsActionPerformed(evt);
            }
        });

        BExchange.setText("Trocar");
        BExchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExchangeActionPerformed(evt);
            }
        });

        jLabel3.setText("Qual você quer trocar?");

        jLabel4.setText("Por qual?");

        jLabel5.setText("Tipo");

        jLabel6.setText("Quantidade");

        jLabel7.setText("Tipo");

        jLabel8.setText("Quantidade");

        BExchangeCards.setText("Trocar");
        BExchangeCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExchangeCardsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelExchangeLayout = new javax.swing.GroupLayout(jPanelExchange);
        jPanelExchange.setLayout(jPanelExchangeLayout);
        jPanelExchangeLayout.setHorizontalGroup(
            jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExchangeLayout.createSequentialGroup()
                .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelExchangeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanelExchangeLayout.createSequentialGroup()
                                .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTQntd1)
                                    .addComponent(CBTypeEx1, 0, 72, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTQntd2)
                            .addComponent(CBTypeEx2, 0, 72, Short.MAX_VALUE)))
                    .addGroup(jPanelExchangeLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(BExchangeCards)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelExchangeLayout.setVerticalGroup(
            jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExchangeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelExchangeLayout.createSequentialGroup()
                        .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(CBTypeEx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTQntd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelExchangeLayout.createSequentialGroup()
                        .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(CBTypeEx2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelExchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTQntd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BExchangeCards)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(BGetCollections)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BExchange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BRefresh2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelExchange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BRefresh2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BGetCollections)
                        .addComponent(BExchange)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelExchange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Geral", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddCardsActionPerformed
        // TODO add your handling code here:
        if (jPanelAdd.isVisible()) {
            jPanelAdd.setVisible(false);
        } else {
            jPanelAdd.setVisible(true);
        }
    }//GEN-LAST:event_jBAddCardsActionPerformed

    private void BCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCleanActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_BCleanActionPerformed

    private void BNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNewActionPerformed
        if (!CBType.getSelectedItem().equals(-1) || TQntd.getText().isEmpty()) {
            Colecao.Cartao type = (Colecao.Cartao) CBType.getSelectedItem();
            Integer qntd = Integer.parseInt(TQntd.getText());
            colecionador.colecao.cartoesQtd.put(type, colecionador.colecao.cartoesQtd.get(type) + qntd);

            clean();
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os dados");
        }
    }//GEN-LAST:event_BNewActionPerformed

    private void BRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRefreshActionPerformed
        updateTable();
    }//GEN-LAST:event_BRefreshActionPerformed

    private void BGetCollectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGetCollectionsActionPerformed
        try {
            List<Colecao> todasColec = colecionador.coord.consultarColecoes(0);
            if(todasColec!=null)
                updateTable(todasColec);
        } catch (RemoteException ex) {
            Logger.getLogger(ColecaoCartoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BGetCollectionsActionPerformed

    private void BRefresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRefresh2ActionPerformed
        try {
            List<Colecao> todasColec = colecionador.coord.consultarColecoes(0);
            updateTable(todasColec);
        } catch (RemoteException ex) {
            Logger.getLogger(ColecaoCartoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BRefresh2ActionPerformed

    private void BExchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExchangeActionPerformed
        if (jPanelExchange.isVisible()) {
            jPanelExchange.setVisible(false);
        } else {
            jPanelExchange.setVisible(true);
        }
    }//GEN-LAST:event_BExchangeActionPerformed

    private void BExchangeCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExchangeCardsActionPerformed
        int linha = jTable2.getSelectedRow();
        if (linha != -1) {
            if (!CBTypeEx1.getSelectedItem().equals(-1) || !CBTypeEx2.getSelectedItem().equals(-1) || jTQntd1.getText().isEmpty() || jTQntd2.getText().isEmpty()) {
                
                try {
                    Colecao.Cartao type1 = (Colecao.Cartao) CBTypeEx1.getSelectedItem();
                    Colecao.Cartao type2 = (Colecao.Cartao) CBTypeEx2.getSelectedItem();
                    Integer qntd1 = Integer.parseInt(jTQntd1.getText());
                    Integer qntd2 = Integer.parseInt(jTQntd2.getText());
                    long id_colec2 = Long.parseLong(jTable2.getValueAt(linha, 0).toString());
                    
                    colecionador.coord.trocarCartoes(0, type1,type2,qntd1,qntd2,this.colecionador.id,id_colec2);
                    
                    clean();
                    updateTable();
                } catch (RemoteException ex) {
                    Logger.getLogger(ColecaoCartoes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha os dados");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma coleção selecionada");
        }

    }//GEN-LAST:event_BExchangeCardsActionPerformed

    public void updateTable(List<Colecao> todasColec) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        //atualizar a tabela a partir dos dados do servidor
        tableModel.setRowCount(0);
        for (Colecao c : todasColec) {
            if(c.cartoesQtd.get(Colecao.Cartao.ANIMAL)!=0)
                tableModel.addRow(new Object[]{c.id_colecionador, Colecao.Cartao.ANIMAL.toString(), c.cartoesQtd.get(Colecao.Cartao.ANIMAL)});
            if(c.cartoesQtd.get(Colecao.Cartao.CIDADE)!=0)
                tableModel.addRow(new Object[]{c.id_colecionador, Colecao.Cartao.CIDADE.toString(), c.cartoesQtd.get(Colecao.Cartao.CIDADE)});
            if(c.cartoesQtd.get(Colecao.Cartao.PAISAGEM)!=0)
                tableModel.addRow(new Object[]{c.id_colecionador, Colecao.Cartao.PAISAGEM.toString(), c.cartoesQtd.get(Colecao.Cartao.PAISAGEM)});
        }
        jTable2.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    public void updateTable() {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        //atualizar a tabela a partir dos dados do servidor
        tableModel.setRowCount(0);

        tableModel.addRow(new Object[]{Colecao.Cartao.ANIMAL.toString(), colecionador.colecao.cartoesQtd.get(Colecao.Cartao.ANIMAL)});
        tableModel.addRow(new Object[]{Colecao.Cartao.CIDADE.toString(), colecionador.colecao.cartoesQtd.get(Colecao.Cartao.CIDADE)});
        tableModel.addRow(new Object[]{Colecao.Cartao.PAISAGEM.toString(), colecionador.colecao.cartoesQtd.get(Colecao.Cartao.PAISAGEM)});

        jTable1.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    public void clean() {
        CBType.setSelectedIndex(-1);
        TQntd.setText("");
        updateTable();
    }
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColecaoCartoes().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BClean;
    private javax.swing.JButton BExchange;
    private javax.swing.JButton BExchangeCards;
    private javax.swing.JButton BGetCollections;
    private javax.swing.JButton BNew;
    private javax.swing.JButton BRefresh;
    private javax.swing.JButton BRefresh2;
    private javax.swing.JComboBox<Colecao.Cartao> CBType;
    private javax.swing.JComboBox<Colecao.Cartao> CBTypeEx1;
    private javax.swing.JComboBox<Colecao.Cartao> CBTypeEx2;
    private javax.swing.JTextField TQntd;
    private javax.swing.JButton jBAddCards;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAdd;
    private javax.swing.JPanel jPanelExchange;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTQntd1;
    private javax.swing.JTextField jTQntd2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
