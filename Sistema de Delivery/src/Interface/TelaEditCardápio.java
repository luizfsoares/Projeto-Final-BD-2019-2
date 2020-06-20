/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import static Interface.TelaAdicionarPrato.lblNomeRest;
import static Interface.TelaCardápio.tblPratos;
import static Interface.TelaInicialCliente.tblPesquisar;
import bd20191.Restaurante;
import conexoes.ConexaoSQlite;
import java.beans.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Luiz Cardoso
 */
public class TelaEditCardápio extends javax.swing.JFrame {

    private Restaurante restauranteLogado;

    /**
     * Creates new form TelaEditCardápio
     */
    public TelaEditCardápio(Restaurante restauranteLogado) {

        this.restauranteLogado = restauranteLogado;
        initComponents();
    }

    private TelaEditCardápio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pesquisarPratos() {

        String sql = "SELECT idPrato as ID, Nome, Descrição, Valor"
                + " FROM tbl_prato"
                + " WHERE id_rest"
                + " LIKE ?";

        try {
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            //pstmt.setString(1, txtPesquisarP.getText() + "%");
            pstmt.setInt(1, restauranteLogado.getId());
            resultset = pstmt.executeQuery();

            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblEditPratos.setModel(DbUtils.resultSetToTableModel(resultset));

            pstmt.close();
            conexaoSQlite.desconectar();
            /*System.out.println(resultado);
            if (resultado) {
                System.out.println("inseriu");
                JOptionPane.showMessageDialog(null, "Prato adicionado com sucesso");
                pstmt.close();
                conexaoSQlite.desconectar();
            } else {
                System.out.println("nao inseriu");
                pstmt.close();
                conexaoSQlite.desconectar();
            }*/

        } catch (SQLException e) {
            Logger.getLogger(TelaCadastroCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void setarInformações() {

        int setar = tblEditPratos.getSelectedRow();
        txtEditNomeR.setText(tblEditPratos.getModel().getValueAt(setar, 1).toString());
        txtEditDescriçãoR.setText(tblEditPratos.getModel().getValueAt(setar, 2).toString());
        txtEditValorR.setText(tblEditPratos.getModel().getValueAt(setar, 3).toString());
    }

    private void atualizarInformações() {
        
        Date data = new Date();
        DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH'h'mm");

        String sql = "UPDATE tbl_prato"
                + " SET Nome = ?,"
                + " Descrição = ?,"
                + " Valor = ?"
                + " WHERE idPrato"
                + " LIKE ?";

        int setar = tblEditPratos.getSelectedRow();

        try {
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);

            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            pstmt.setString(1, txtEditNomeR.getText());
            pstmt.setString(2, txtEditDescriçãoR.getText());
            pstmt.setString(3, txtEditValorR.getText());
            pstmt.setInt(4, Integer.parseInt(tblEditPratos.getModel().getValueAt(setar, 0).toString()));
            
            //pstmt.setString(1, restauranteLogado.getId());
            int resultado = pstmt.executeUpdate();

            System.out.println(resultado);
            if (resultado == 1) {
                System.out.println("inseriu");
                JOptionPane.showMessageDialog(null, "Informações Atualizadas");
                dispose();
            } else {
                System.out.println("nao inseriu");
            }

            pstmt.close();
            conexaoSQlite.desconectar();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        String sqlInsert1 = "INSERT INTO tbl_preco ("
                //+ "id,"  //primary key se tentar inserir 2 do mesmo id da erro
                + "id_prato,"
                + "data_hora,"
                + "nomeRestaurante,"
                + "valor"
                + ") VALUES(?, ?, ?, ?)"
                + ";";
        
        int setar1 = tblEditPratos.getSelectedRow();
        
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement pstm;
        pstm = conexaoSQlite.criarPreparedStatement(sqlInsert1);
        
        try{
            // COLOCA NA ORDEM DAS INTERROGACOES A PARTIR DA POSICAO 1

            pstm.setInt(1, Integer.parseInt(tblEditPratos.getModel().getValueAt(setar, 0).toString()));
            pstm.setString(2, formatador.format(data));
            pstm.setString(3, txtEditNomeR.getText());
            pstm.setDouble(4, Double.parseDouble(txtEditValorR.getText()));

            //retorna um inteiro, se for 1 = inseriu    se for 0 = não inseriu
            int resultado = pstm.executeUpdate();
            
          
            if (resultado == 1){
                System.out.println("inseriu");
                JOptionPane.showMessageDialog(null, "Preco inserido com sucesso");
            }else{
                System.out.println("nao inseriu");
            }
        
        } catch(SQLException e){
            //JOptionPane.showMessageDialog(null, "Erro ao realizar Pedido");
            Logger.getLogger(TelaCadastroCliente.class.getName()).log(Level.SEVERE, null, e);
        } 
        conexaoSQlite.desconectar();
        
        

    }

    private void removerPrato() {

        String sql = "DELETE FROM tbl_prato"
                + " WHERE idPrato"
                + " LIKE ?";

        int setar = tblEditPratos.getSelectedRow();

        try {
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);

            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            pstmt.setInt(1, Integer.parseInt(tblEditPratos.getModel().getValueAt(setar, 0).toString()));
            //pstmt.setString(1, restauranteLogado.getId());
            int resultado = pstmt.executeUpdate();

            System.out.println(resultado);
            if (resultado == 1) {
                System.out.println("inseriu");
                JOptionPane.showMessageDialog(null, "Prato excluído com sucesso");
                dispose();
            } else {
                System.out.println("nao inseriu");
            }
        } catch (SQLException e) {

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEditPratos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblEditNomeRest = new javax.swing.JLabel();
        btnSalvarInfo = new javax.swing.JButton();
        txtEditNomeR = new javax.swing.JTextField();
        txtEditValorR = new javax.swing.JTextField();
        txtEditDescriçãoR = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnRemoverPrato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Ci Food");

        tblEditPratos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEditPratos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblEditPratosMouseMoved(evt);
            }
        });
        tblEditPratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEditPratosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEditPratos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cardápio:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Informações:");

        lblEditNomeRest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEditNomeRest.setText("NOME RESTAURANTE");

        btnSalvarInfo.setText("Salvar Informações");
        btnSalvarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarInfoActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome:");

        jLabel5.setText("Valor:");

        jLabel6.setText("Descrição");

        btnRemoverPrato.setText("Remover Prato");
        btnRemoverPrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPratoActionPerformed(evt);
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
                                .addGap(151, 151, 151)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 143, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtEditNomeR)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                    .addComponent(txtEditValorR))
                                .addGap(19, 19, 19)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEditDescriçãoR)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvarInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemoverPrato, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(lblEditNomeRest)
                    .addContainerGap(246, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEditNomeR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditValorR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEditDescriçãoR, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarInfo)
                    .addComponent(btnRemoverPrato))
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(lblEditNomeRest)
                    .addContainerGap(497, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(416, 633));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblEditPratosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEditPratosMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEditPratosMouseMoved

    private void tblEditPratosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEditPratosMouseClicked
        // TODO add your handling code here:
        //evento usado para setar os campos clicando com o mouse
        setarInformações();

    }//GEN-LAST:event_tblEditPratosMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        pesquisarPratos();
    }//GEN-LAST:event_formWindowActivated

    private void btnSalvarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarInfoActionPerformed
        // TODO add your handling code here:
        atualizarInformações();

    }//GEN-LAST:event_btnSalvarInfoActionPerformed

    private void btnRemoverPratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPratoActionPerformed
        // TODO add your handling code here:
        removerPrato();
    }//GEN-LAST:event_btnRemoverPratoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEditCardápio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditCardápio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditCardápio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditCardápio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditCardápio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemoverPrato;
    private javax.swing.JButton btnSalvarInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblEditNomeRest;
    public static javax.swing.JTable tblEditPratos;
    private javax.swing.JTextField txtEditDescriçãoR;
    private javax.swing.JTextField txtEditNomeR;
    private javax.swing.JTextField txtEditValorR;
    // End of variables declaration//GEN-END:variables
}
