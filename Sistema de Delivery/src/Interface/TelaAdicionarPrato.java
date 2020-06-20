/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import static Interface.TelaCardápio.lblNomeCardapio;
import static Interface.TelaCarrinho.txtAreaCarrinho;
import bd20191.Cliente;
import bd20191.Prato;
import bd20191.Restaurante;
import conexoes.ConexaoSQlite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Cardoso
 */
public class TelaAdicionarPrato extends javax.swing.JFrame {
    
    private Restaurante restauranteLogado;

    /**
     * Creates new form TelaAdicionarPrato
     */
    public TelaAdicionarPrato(Restaurante restauranteLogado) {
        this.restauranteLogado = restauranteLogado;
        initComponents();
    }

    private TelaAdicionarPrato() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        txtNomePrato = new javax.swing.JTextField();
        txtValorPrato = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescPrato = new javax.swing.JTextArea();
        btnCadastroPrato = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblNomeRest = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Novo Prato");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ci Food");

        jLabel2.setText("Nome do Prato: ");

        jLabel3.setText("Valor do prato: ");

        jLabel4.setText("Descrição do Prato:");

        txtDescPrato.setColumns(20);
        txtDescPrato.setRows(5);
        jScrollPane1.setViewportView(txtDescPrato);

        btnCadastroPrato.setText("Cadastrar");
        btnCadastroPrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroPratoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Cadastrar Novo Prato:");

        lblNomeRest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNomeRest.setText("NOME RESTAURANTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCadastroPrato)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNomePrato)
                                .addComponent(txtValorPrato)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addComponent(jLabel5)
                            .addComponent(lblNomeRest)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(lblNomeRest)
                .addGap(43, 43, 43)
                .addComponent(jLabel5)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomePrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValorPrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastroPrato)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(358, 677));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public int pegarIdPrato(Prato novoPrato){
        
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();

        ResultSet resultSet = null;
        PreparedStatement pstmt = null;

        String sql1 = "SELECT idPrato"
                + " FROM tbl_prato"
                + " WHERE Nome = ?";

        try {

            pstmt = conexaoSQlite.criarPreparedStatement(sql1);
            pstmt.setString(1, novoPrato.getNomeP());
            resultSet = pstmt.executeQuery();
            int a = resultSet.getInt(1);
            pstmt.close();
            conexaoSQlite.desconectar();
            return a;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        return 0;
    }
    private void btnCadastroPratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroPratoActionPerformed
        // TODO add your handling code here:
        
        Date data = new Date();
        DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH'h'mm");
        
        Prato novoPrato = new Prato();
        novoPrato.setNomeP(txtNomePrato.getText());
        novoPrato.setValorP(Double.parseDouble(txtValorPrato.getText()));
        novoPrato.setDescrição(txtDescPrato.getText());
        novoPrato.setIdP(1);
        
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaAdicionarPrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //SALVAR NO BANCO primeiro conecta
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        
        //SALVAR NO BANCO primeiro conecta
        //System.out.println(cliente1.getEndereco());
        
        //System.out.println(cliente1.getEndereco());
        String sqlInsert = "INSERT INTO tbl_prato ("
                //+ "id,"  //primary key se tentar inserir 2 do mesmo id da erro
                + "Nome,"
                + "id_rest,"
                + "Descrição,"
                + "nomeRestaurante,"
                + "Valor"
                + ") VALUES(?, ?, ?, ?, ?)"
                + ";";
        
        PreparedStatement preparedstatement;
        preparedstatement = conexaoSQlite.criarPreparedStatement(sqlInsert);
        
        try{
            // COLOCA NA ORDEM DAS INTERROGACOES A PARTIR DA POSICAO 1
            //preparedstatement.setInt(1, cliente1.getId());
            preparedstatement.setString(1, novoPrato.getNomeP());
            preparedstatement.setInt(2, restauranteLogado.getId());
            preparedstatement.setString(3, novoPrato.getDescrição());
            preparedstatement.setString(4, lblNomeRest.getText());
            preparedstatement.setDouble(5, novoPrato.getValorP());
            
            //retorna um inteiro, se for 1 = inseriu    se for 0 = não inseriu
            int resultado = preparedstatement.executeUpdate();
            
            System.out.println(resultado);
            if (resultado == 1){
                System.out.println("inseriu");
                JOptionPane.showMessageDialog(null, "Prato adicionado com sucesso");
            }else{
                System.out.println("nao inseriu");
            }
        
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao realizar Cadastro");
            Logger.getLogger(TelaCadastroCliente.class.getName()).log(Level.SEVERE, null, e);
        } finally { //fechar tudo
                if(preparedstatement != null){
                    try {
                        preparedstatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                conexaoSQlite.desconectar();
            }
        
        String sql2 = "UPDATE tbl_prato SET id_rest = tbl_restaurante.idR WHERE tbl_restaurante.emailR = ?";
        
        int idPrato = pegarIdPrato(novoPrato);
        System.out.println(idPrato);
        
        String sqlInsert1 = "INSERT INTO tbl_preco ("
                //+ "id,"  //primary key se tentar inserir 2 do mesmo id da erro
                + "id_prato,"
                + "data_hora,"
                + "nomeRestaurante,"
                + "valor"
                + ") VALUES(?, ?, ?, ?)"
                + ";";
        
        conexaoSQlite.conectar();
        PreparedStatement pstm;
        pstm = conexaoSQlite.criarPreparedStatement(sqlInsert1);
        
        try{
            // COLOCA NA ORDEM DAS INTERROGACOES A PARTIR DA POSICAO 1
            //preparedstatement.setInt(1, cliente1.getId());
            pstm.setInt(1, idPrato);
            pstm.setString(2, formatador.format(data));
            pstm.setString(3, lblNomeRest.getText());
            pstm.setDouble(4, Double.parseDouble(txtValorPrato.getText()));

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
    }//GEN-LAST:event_btnCadastroPratoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAdicionarPrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarPrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarPrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarPrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicionarPrato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroPrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblNomeRest;
    private javax.swing.JTextArea txtDescPrato;
    private javax.swing.JTextField txtNomePrato;
    private javax.swing.JTextField txtValorPrato;
    // End of variables declaration//GEN-END:variables
}
