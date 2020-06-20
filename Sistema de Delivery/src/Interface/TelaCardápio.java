/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import static Interface.TelaCarrinho.txtAreaCarrinho;
import static Interface.TelaInicialCliente.tblPesquisar;
import bd20191.Cliente;
import conexoes.ConexaoSQlite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Luiz Cardoso
 */
public class TelaCardápio extends javax.swing.JFrame {
    public double total = 0;
    private Cliente clienteLogado;

    /**
     * Creates new form TelaCardápio
     */
    public TelaCardápio(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
        
        initComponents();
    }

    private TelaCardápio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void pesquisarPratos() {

        String sql = "SELECT Nome, Descrição, Valor"
                + " FROM tbl_prato"
                + " WHERE id_rest"
                + " LIKE ?";
        
        int setar = tblPesquisar.getSelectedRow();
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            //pstmt.setString(1, txtPesquisarP.getText() + "%");
            pstmt.setInt(1, Integer.parseInt(tblPesquisar.getModel().getValueAt(setar, 0).toString()));
            resultset = pstmt.executeQuery();
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPratos.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setarDescriçao(){
    
        int setar = tblPratos.getSelectedRow();
        txtDescriçao.setText(tblPratos.getModel().getValueAt(setar, 1).toString());
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPratos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescriçao = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        lblNomeCardapio = new javax.swing.JLabel();
        btnAddCarrinho = new javax.swing.JButton();
        btnAbrirCarrinho = new javax.swing.JButton();

        jScrollPane3.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cardápio");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblPratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPratos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblPratosMouseMoved(evt);
            }
        });
        tblPratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPratosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPratos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cardápio:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Ci Food");

        txtDescriçao.setColumns(20);
        txtDescriçao.setRows(5);
        jScrollPane2.setViewportView(txtDescriçao);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Descrição:");

        lblNomeCardapio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNomeCardapio.setText("NOME RESTAURANTE");

        btnAddCarrinho.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAddCarrinho.setText("Adicionar ao Carrinho");
        btnAddCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCarrinhoActionPerformed(evt);
            }
        });

        btnAbrirCarrinho.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAbrirCarrinho.setText("Abrir Carrinho");
        btnAbrirCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lblNomeCardapio))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbrirCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddCarrinho)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(lblNomeCardapio)
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCarrinho)
                    .addComponent(btnAbrirCarrinho))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(429, 655));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblPratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPratosMouseClicked
        // TODO add your handling code here:
        //evento usado para setar os campos clicando com o mouse
        setarDescriçao();
    }//GEN-LAST:event_tblPratosMouseClicked

    private void tblPratosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPratosMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPratosMouseMoved

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        pesquisarPratos();
    }//GEN-LAST:event_formWindowActivated

    private void btnAbrirCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirCarrinhoActionPerformed
        // TODO add your handling code here:
        TelaCarrinho telacarrinho = new TelaCarrinho(clienteLogado);
        telacarrinho.setVisible(true);
    }//GEN-LAST:event_btnAbrirCarrinhoActionPerformed

    private void btnAddCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCarrinhoActionPerformed
        // TODO add your handling code here:
        int setar = tblPratos.getSelectedRow();
        String nomePrato = tblPratos.getModel().getValueAt(setar, 0).toString();
        String valorPrato = tblPratos.getModel().getValueAt(setar, 2).toString();
        TelaCarrinho.txtAreaCarrinho.append(nomePrato + " R$ " + valorPrato + " ");
        
        //atualizar valor total do carinho
        //System.out.println(valorPrato);
        
        double aux = Double.parseDouble(valorPrato);
        //System.out.println(aux);
        total = total + aux;
        //System.out.println("Subtotal = " + total);
        TelaCarrinho.txtValorTotal.setText("Subtotal = R$ " + Double.toString(total));
    }//GEN-LAST:event_btnAddCarrinhoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        pesquisarPratos();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(TelaCardápio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCardápio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCardápio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCardápio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCardápio().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirCarrinho;
    private javax.swing.JButton btnAddCarrinho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    public static javax.swing.JLabel lblNomeCardapio;
    public static javax.swing.JTable tblPratos;
    private javax.swing.JTextArea txtDescriçao;
    // End of variables declaration//GEN-END:variables
}
