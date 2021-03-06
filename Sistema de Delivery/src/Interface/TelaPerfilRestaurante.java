/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import static Interface.TelaPerfilCliente.txtEditarEmailC;
import bd20191.Restaurante;
import conexoes.ConexaoSQlite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Cardoso
 */
public class TelaPerfilRestaurante extends javax.swing.JFrame {

    
    Restaurante restauranteLogado;
    /**
     * Creates new form TelaPerfilRestaurante
     */
    public TelaPerfilRestaurante(Restaurante restauranteLogado) {
        
        this.restauranteLogado = restauranteLogado;
        initComponents();
    }

    TelaPerfilRestaurante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void setarInformações(){
    
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();

        ResultSet resultSet = null;
        PreparedStatement pstmt = null;

        String sql2 = "SELECT *"
                + " FROM tbl_restaurante"
                + " WHERE idR = ?";
        
        try{
            pstmt = conexaoSQlite.criarPreparedStatement(sql2);
            pstmt.setInt(1, restauranteLogado.getId());
            resultSet = pstmt.executeQuery();
            String editemail = resultSet.getString(2);
            txtEditarEmailR.setText(editemail);
            String editnome = resultSet.getString(3);
            txtEditarNomeR.setText(editnome);
            String editsenha = resultSet.getString(4);
            txtEditarSenhaR.setText(editsenha);
            String end = resultSet.getString(5);
            txtEditarEndR.setText(end);
            String frete = resultSet.getString(8);
            CBEditFrete.setSelectedItem(frete);
            String categoria = resultSet.getString(7);
            CBEditItem.setSelectedItem(categoria);
            conexaoSQlite.desconectar();
        
        }catch(Exception e){
            Logger.getLogger(TelaCadastroCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void atualizarInformações() {

        String sql = "UPDATE tbl_restaurante"
                + " SET Nome = ?,"
                + " emailR = ?,"
                + " senhaR = ?,"
                + " endereçoR = ?,"
                + " Categoria = ?,"
                + " Frete = ?"
                + " WHERE idR"
                + " LIKE ?";


        try {
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);

            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            pstmt.setString(1, txtEditarNomeR.getText());
            pstmt.setString(2, txtEditarEmailR.getText());
            pstmt.setString(3, txtEditarSenhaR.getText());
            pstmt.setString(4, txtEditarEndR.getText());
            pstmt.setString(5, CBEditItem.getSelectedItem().toString());
            pstmt.setString(6, CBEditFrete.getSelectedItem().toString());
            pstmt.setInt(7, restauranteLogado.getId());
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

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEditarNomeR = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEditarEmailR = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEditarSenhaR = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEditarEndR = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CBEditItem = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        CBEditFrete = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnSalvarInfoR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Editar Informações do Perfil:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(18, 183, 226, 13);
        getContentPane().add(txtEditarNomeR);
        txtEditarNomeR.setBounds(18, 244, 243, 19);

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(18, 220, 100, 13);

        jLabel3.setText("Email:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(18, 281, 109, 13);

        txtEditarEmailR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditarEmailRActionPerformed(evt);
            }
        });
        getContentPane().add(txtEditarEmailR);
        txtEditarEmailR.setBounds(18, 300, 243, 19);

        jLabel4.setText("Senha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(18, 330, 98, 13);
        getContentPane().add(txtEditarSenhaR);
        txtEditarSenhaR.setBounds(18, 349, 243, 19);

        jLabel5.setText("Endereço: ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(18, 379, 243, 13);
        getContentPane().add(txtEditarEndR);
        txtEditarEndR.setBounds(18, 398, 243, 19);

        jLabel6.setText("Categoria:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 440, 121, 13);

        CBEditItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lanches", "Brasileira", "Chinesa", "Japonesa", "Pizzas", "Hambúrguer", "Mexicana", "Italiana", "Doceria" }));
        getContentPane().add(CBEditItem);
        CBEditItem.setBounds(20, 460, 121, 19);

        jLabel7.setText("Tipo de Frete: ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(210, 440, 110, 13);

        CBEditFrete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grátis", "Pago - Valor fixo" }));
        getContentPane().add(CBEditFrete);
        CBEditFrete.setBounds(210, 460, 124, 19);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fooddome_118034.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 10, 180, 150);

        btnSalvarInfoR.setText("Salvar Informações");
        btnSalvarInfoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarInfoRActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarInfoR);
        btnSalvarInfoR.setBounds(120, 520, 160, 21);

        setSize(new java.awt.Dimension(417, 588));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEditarEmailRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditarEmailRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditarEmailRActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        setarInformações();
        
    }//GEN-LAST:event_formWindowActivated

    private void btnSalvarInfoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarInfoRActionPerformed
        // TODO add your handling code here:
        atualizarInformações();
    }//GEN-LAST:event_btnSalvarInfoRActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPerfilRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPerfilRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPerfilRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPerfilRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPerfilRestaurante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBEditFrete;
    private javax.swing.JComboBox<String> CBEditItem;
    private javax.swing.JButton btnSalvarInfoR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtEditarEmailR;
    private javax.swing.JTextField txtEditarEndR;
    private javax.swing.JTextField txtEditarNomeR;
    private javax.swing.JTextField txtEditarSenhaR;
    // End of variables declaration//GEN-END:variables
}
