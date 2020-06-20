/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import static Interface.TelaAdicionarPrato.lblNomeRest;
import static Interface.TelaCardápio.tblPratos;
import static Interface.TelaInicialCliente.tblPesquisar;
import static Interface.TelaInicialRestaurante.lblNomeResta;
import bd20191.Prato;
import bd20191.Restaurante;
import conexoes.ConexaoSQlite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Luiz Cardoso
 */
public class TelaEmitirRelatório extends javax.swing.JFrame {
    
    Restaurante restauranteLogado;

    /**
     * Creates new form TelaEmitirRelatório
     */
    public TelaEmitirRelatório(Restaurante restauranteLogado) {
        
        this.restauranteLogado = restauranteLogado;
        initComponents();
    }

    private TelaEmitirRelatório() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void emitirPedidosSolicitados(){
    
        String sql = "SELECT id_pedido,id_cliente,detalhes, data_hora,valor,local_entrega"
                + " FROM tbl_pedido"
                + " WHERE nomeRestaurante"
                + " LIKE ?"
                + " ORDER BY id_pedido DESC";
         
         try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            pstmt.setString(1, lblNomeResta.getText());
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblEmitirRelatórios.setModel(DbUtils.resultSetToTableModel(resultset));
            
            int quantLinhas = tblEmitirRelatórios.getModel().getRowCount();
            int auxValor = 0;
            
            for (int i=0; i < quantLinhas; i++){
            
            String str[] = new String[10];
            str = tblEmitirRelatórios.getModel().getValueAt(i, 4).toString().split(" ");
            System.out.println(str[3]);
            auxValor += Double.parseDouble(str[3].trim());
            lblsetarTexto.setText("Valor Total Recebido:");
            txtValorTotal.append("Pedido " + tblEmitirRelatórios.getModel().getValueAt(i, 0).toString() + ": " + str[3] + "\n");
            }
            txtValorTotal.append("Total recebido: " + auxValor + "\n");
            
            
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    
    }
    
    private void emitirMaisPedidos(){
    
        String sql = "SELECT id_pedido,id_cliente,detalhes,data_hora,valor,local_entrega"
                + " FROM tbl_pedido"
                + " WHERE nomeRestaurante"
                + " LIKE ?";
         
         try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            pstmt.setString(1, lblNomeResta.getText());
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblEmitirRelatórios.setModel(DbUtils.resultSetToTableModel(resultset));
            
            int quantLinhas = tblEmitirRelatórios.getModel().getRowCount();
            
            ArrayList<Prato> pedidos = new ArrayList();
            //Prato Pratoaleatório = new Prato();
            //pedidos.add(Pratoaleatório);
            
            for (int i=0; i < quantLinhas; i++){
            
            String str[] = new String[300];
            str = tblEmitirRelatórios.getModel().getValueAt(i, 2).toString().split(" ");
            boolean entrou;
           
            //str = tblEmitirRelatórios.getModel().getValueAt(i, 4).toString().split(" ");
            //
            //System.out.println(str[6]);
            
            for(int j = 0; j < str.length; j += 3){
                entrou = false;
                
                if(pedidos.isEmpty()){
                        
                        Prato newPrato = new Prato();
                        newPrato.setNomeP(str[j].trim());
                        newPrato.addPrato();
                        //System.out.println(newPrato.getNomeP());
                        pedidos.add(newPrato);
                        entrou = true;
                        
                }else{
                    int aux = pedidos.size();
                    for(int k = 0; k < aux; k++){
                        //System.out.println("ITERAÇÃO: " + k + pedidos.get(k).getNomeP() + " " + str[j]);
                        
                    if(pedidos.get(k).getNomeP().equals(str[j].trim())){
                        //System.out.println("ENTROU");
                        pedidos.get(k).addPrato();
                        entrou = true;
                    }
                    
                }
                    
                    if(entrou == false){
                        Prato newPrato = new Prato();
                        newPrato.setNomeP(str[j].trim());
                        newPrato.addPrato();
                        pedidos.add(newPrato);
                    }
                    
                }
                
                
            }
            //auxValor += Double.parseDouble(str[3].trim());
            //txtValorTotal.append("Pedido " + tblEmitirRelatórios.getModel().getValueAt(i, 0).toString() + ": " + str[3] + "\n");
            }
            //txtValorTotal.append("Total recebido: " + auxValor + "\n");
            Prato maisPedido = new Prato();
            maisPedido = null;
            
            ArrayList<Prato> maisPedidos = new ArrayList();
            
             //System.out.println("\n" + pedidos.size());
             
            for(int i = 0; i < pedidos.size(); i++){
                
                if(maisPedido == null){
                    maisPedido = pedidos.get(i);
                }else if(maisPedido.getQuantidade() <= pedidos.get(i).getQuantidade()){
                    maisPedido = pedidos.get(i);
                }
                   //System.out.println(pedidos.get(i).getNomeP() + " " + pedidos.get(i).getQuantidade());
                    
            }
            
            if(maisPedido != null){
               maisPedidos.add(maisPedido); 
            }

            for(int i = 0; i < pedidos.size(); i++){
                
                if(maisPedido.getQuantidade() == pedidos.get(i).getQuantidade()){
                    if(pedidos.get(i) != maisPedido){
                       maisPedidos.add(pedidos.get(i));
                    }
                }
                   //System.out.println(pedidos.get(i).getNomeP() + " " + pedidos.get(i).getQuantidade());
                    
            }
            
            if(maisPedido == null){
                JOptionPane.showMessageDialog(null, "Ainda não ouve pedidos esse mês!");
            }else{
                TelaMaisPedidos telamaispedidos = new TelaMaisPedidos();
                
                for(int i = 0; i < maisPedidos.size(); i++){
                    
                    TelaMaisPedidos.textoMaisPedidos.append(" " + maisPedidos.get(i).getNomeP() + "\n");
                    
                }
                
                TelaMaisPedidos.textoMaisPedidos.append("Quantidade de cada: " + " " + maisPedidos.get(0).getQuantidade()+ "\n");
                
                telamaispedidos.setVisible(true);
            }
            
             System.out.println(maisPedido.getNomeP());
            
             //System.out.println("\n" + maisPedido.getNomeP());
            
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    
    }
    private void setarPratos() {

        String sql = "SELECT idPrato as ID, Nome, Descrição, Valor"
                + " FROM tbl_prato"
                + " WHERE id_rest"
                + " LIKE ?";
        
        try{
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
            tblEmitirRelatórios.setModel(DbUtils.resultSetToTableModel(resultset));
            txtValorTotal.setText("");
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void emitirPreçoMedio(){
    
        String sql = "SELECT valor"
                + " FROM tbl_preco"
                + " WHERE id_prato"
                + " LIKE ?";
        
        int setar = tblEmitirRelatórios.getSelectedRow();
        double soma = 0;
        double media = 0;
        int cont = 0;
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            pstmt.setInt(1, Integer.parseInt(tblEmitirRelatórios.getModel().getValueAt(setar, 0).toString()));
            resultset = pstmt.executeQuery();
            
            while(resultset.next()){    
                soma += resultset.getDouble(1);
                cont++;
            }
            
            media = (soma/cont);

            lblsetarTexto.setText("Preço Médio do Item Selecionado");
            txtValorTotal.setText("Média de Preço: " + media + " reais.");
            
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
        btnPedidosSolicitados = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmitirRelatórios = new javax.swing.JTable();
        lblsetarTexto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtValorTotal = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/analytics_117968.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 10, 160, 140);

        btnPedidosSolicitados.setText("Relatório de Pedidos Solicitados");
        btnPedidosSolicitados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosSolicitadosActionPerformed(evt);
            }
        });
        getContentPane().add(btnPedidosSolicitados);
        btnPedidosSolicitados.setBounds(10, 190, 240, 21);

        jButton3.setText("Relatório Preço Médio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 220, 240, 21);

        jButton2.setText("Relatório Mais Pedidos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 250, 240, 21);

        tblEmitirRelatórios.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmitirRelatórios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmitirRelatóriosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmitirRelatórios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 300, 375, 90);

        lblsetarTexto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblsetarTexto.setText("Valor Total Recebido:");
        getContentPane().add(lblsetarTexto);
        lblsetarTexto.setBounds(10, 420, 200, 20);

        txtValorTotal.setColumns(20);
        txtValorTotal.setRows(5);
        jScrollPane2.setViewportView(txtValorTotal);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 450, 290, 61);

        setSize(new java.awt.Dimension(414, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedidosSolicitadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosSolicitadosActionPerformed
        // TODO add your handling code here:
        System.out.println(lblNomeResta.getText());
        emitirPedidosSolicitados();
    }//GEN-LAST:event_btnPedidosSolicitadosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setarPratos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        emitirMaisPedidos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblEmitirRelatóriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmitirRelatóriosMouseClicked
        // TODO add your handling code here:
        emitirPreçoMedio();
    }//GEN-LAST:event_tblEmitirRelatóriosMouseClicked

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
            java.util.logging.Logger.getLogger(TelaEmitirRelatório.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmitirRelatório.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmitirRelatório.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmitirRelatório.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmitirRelatório().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPedidosSolicitados;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblsetarTexto;
    private javax.swing.JTable tblEmitirRelatórios;
    private javax.swing.JTextArea txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
