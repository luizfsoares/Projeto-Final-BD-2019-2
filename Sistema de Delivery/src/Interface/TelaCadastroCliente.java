/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import bd20191.Cliente;
import java.sql.ResultSet;
import conexoes.ConexaoSQlite;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Cardoso
 */
public class TelaCadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastroCliente() {
        initComponents();
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
        txtEmail = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Cadastro");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ci Food");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 70, 79, 29);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(100, 190, 230, 30);
        getContentPane().add(txtNome);
        txtNome.setBounds(100, 250, 227, 30);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(100, 320, 230, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Email:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 200, 70, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nome: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 260, 70, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Senha: ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 330, 80, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Endereço: ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 370, 90, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Realizar Cadastro:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(26, 140, 150, 17);

        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(160, 560, 110, 21);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Rua: ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(50, 420, 70, 15);
        getContentPane().add(txtRua);
        txtRua.setBounds(100, 410, 230, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Número: ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 470, 80, 13);
        getContentPane().add(txtNum);
        txtNum.setBounds(100, 460, 230, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Bairro: ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 510, 70, 13);
        getContentPane().add(txtBairro);
        txtBairro.setBounds(100, 500, 230, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2959518_Easy-Resize.com (1).jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(-430, -150, 1270, 810);

        setSize(new java.awt.Dimension(850, 633));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        boolean jaCadastrado = false;
        Cliente cliente1 = new Cliente();
        cliente1.setEmail(txtEmail.getText());
        //cliente1.setEndereco(txtEndereço.getText());
        cliente1.setNome(txtNome.getText());
        cliente1.setSenha(txtSenha.getText());
        cliente1.setId(1);
        cliente1.setRua(txtRua.getText());
        cliente1.setNumeroCasa(txtNum.getText());
        cliente1.setBairro(txtBairro.getText());
        
        //SALVAR NO BANCO primeiro conecta
        ConexaoSQlite conexaoSQlite1 = new ConexaoSQlite();
        conexaoSQlite1.conectar();
        
        ResultSet resultSet = null;
        PreparedStatement pstmtB = null;
        //System.out.println(cliente1.getEndereco());
        
        String sqlBusca = "SELECT *"
                + " FROM tbl_cliente"
                + " WHERE email = ?";
                
        
       
       
       try {

            pstmtB = conexaoSQlite1.criarPreparedStatement(sqlBusca);
            pstmtB.setString(1, cliente1.getEmail());
            

            resultSet = pstmtB.executeQuery();
            
            

            if (resultSet.next()) {
                
                jaCadastrado = true;
                pstmtB.close();
                conexaoSQlite1.desconectar();

            } else {
                
                pstmtB.close();
                conexaoSQlite1.desconectar();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        if(jaCadastrado){
            JOptionPane.showMessageDialog(null, "Usuário já cadastrado!");
        }else{
            String sqlInsert = "INSERT INTO tbl_cliente ("
                //+ "id,"  //primary key se tentar inserir 2 do mesmo id da erro
                + "email,"
                + "nome,"
                + "senha,"
                + "endereco"
                + ") VALUES(?, ?, ?, ?)"
                + ";";
        
        // "INSERT INTO tbl_cliente (email, nome, senha, endereço) VALUES (?, ?, ?, ?);"
        
        conexaoSQlite1.conectar();
        PreparedStatement preparedstatement = conexaoSQlite1.criarPreparedStatement(sqlInsert);
        
        //System.out.println(cliente1.getNome());
        
        try{
            // COLOCA NA ORDEM DAS INTERROGACOES A PARTIR DA POSICAO 1
            //preparedstatement.setInt(1, cliente1.getId());
            preparedstatement.setString(1, cliente1.getEmail());
            preparedstatement.setString(2, cliente1.getNome());
            preparedstatement.setString(3, cliente1.getSenha());
            preparedstatement.setString(4, cliente1.getRua() + ", " + cliente1.getNumeroCasa() + " - " + cliente1.getBairro());
            
            //retorna um inteiro, se for 1 = inseriu    se for 0 = não inseriu
            int resultado = preparedstatement.executeUpdate();
            
            System.out.println(resultado);
            if (resultado == 1){
                System.out.println("inseriu");
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
            }else{
                System.out.println("nao inseriu");
            }
        
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao realizar Cadastro");
        } finally { //fechar tudo
                if(preparedstatement != null){
                    try {
                        preparedstatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                conexaoSQlite1.desconectar();
            }
        }
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
