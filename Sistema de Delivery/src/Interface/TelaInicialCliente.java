/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import static Interface.TelaCardápio.tblPratos;
import bd20191.Cliente;
import conexoes.ConexaoSQlite;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
// a linha abaixo importa recursos da biblio rs2xml.jar
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Luiz Cardoso
 */
public class TelaInicialCliente extends javax.swing.JFrame {
    
    private Cliente clienteLogado;
    /**
     * Creates new form TelaInicialCliente
     */
    public TelaInicialCliente(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
        initComponents();
        
    }

    private TelaInicialCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Método para pesquisar restaurantes pelo nome com Filtro
    private void pesquisarRestaurante() {

        String sql = "SELECT IdR,Nome,Categoria,Situação,Frete"
                + " FROM tbl_restaurante"
                + " WHERE Nome"
                + " LIKE ?";
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            pstmt.setString(1, txtPesquisar.getText() + "%");
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void pesquisarPrato(){
    
         String sql = "SELECT id_rest as ID,Nome,nomeRestaurante as Restaurante"
                + " FROM tbl_prato"
                + " WHERE Nome"
                + " LIKE ?";
         
         try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            pstmt.setString(1, txtPesquisarP.getText() + "%");

            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    
    
    private void pesquisarFrete(){

        String sql = "SELECT IdR,Nome,Categoria,Situação,Frete"
                + " FROM tbl_restaurante"
                + " WHERE Frete"
                + " LIKE ?";
        
        checkBoxMP.setSelected(false);
        checkBoxPromoções.setSelected(false);
        checkBoxPopular.setSelected(false);
         
         try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            pstmt.setString(1, "Grátis");
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    private void pesquisarPopulares(){
    
        String sql = "SELECT *"
                + " FROM tbl_restaurante";
        
        checkBoxMP.setSelected(false);
        checkBoxPromoções.setSelected(false);
        checkBoxGrátis.setSelected(false);
         
         try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            resultset = pstmt.executeQuery();
            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            //for (int i = 0; i < resultset.){
                
            //}
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisar = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNomeC = new javax.swing.JLabel();
        btnPrint = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblChinesa = new javax.swing.JLabel();
        lblJaponesa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPizzas = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDoceria = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblLanches = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblBrasileira = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblItaliana = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblMexicana = new javax.swing.JLabel();
        emailC = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPesquisarP = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        checkBoxMP = new javax.swing.JCheckBox();
        checkBoxPromoções = new javax.swing.JCheckBox();
        checkBoxGrátis = new javax.swing.JCheckBox();
        checkBoxPopular = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("jMenu5");

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("File");
        jMenuBar4.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar4.add(jMenu9);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Inicial");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ci Food");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 30, 79, 29);

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesquisar);
        txtPesquisar.setBounds(20, 460, 150, 29);

        tblPesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Nome: ", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesquisarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesquisar);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 550, 550, 140);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier-1_icon-icons.com_56924.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(610, 460, 45, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Pesquisar por Restaurante: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 430, 170, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Bem Vindo(a), ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 100, 110, 17);

        lblNomeC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNomeC.setText("NOME");
        getContentPane().add(lblNomeC);
        lblNomeC.setBounds(130, 100, 155, 17);

        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrint.setText("DATA");
        getContentPane().add(btnPrint);
        btnPrint.setBounds(10, 145, 390, 17);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Sushi_44346.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(370, 310, 55, 57);

        lblChinesa.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblChinesa.setText("Chinesa");
        getContentPane().add(lblChinesa);
        lblChinesa.setBounds(210, 360, 60, 20);

        lblJaponesa.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblJaponesa.setText("Japonesa");
        getContentPane().add(lblJaponesa);
        lblJaponesa.setBounds(370, 390, 60, 13);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ramen_food_japanese_asian_bowl_noodle_soup_japan_icon_127296.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(210, 300, 65, 63);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Categorias");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(270, 160, 79, 17);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/3558094-bake-bread-fast-food-pizza_107831.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(200, 200, 64, 60);

        lblPizzas.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblPizzas.setText("Pizzas");
        getContentPane().add(lblPizzas);
        lblPizzas.setBounds(210, 270, 50, 13);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cake-Sweet-icon-512_icon-icons.com_52593.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9);
        jLabel9.setBounds(360, 180, 70, 80);

        lblDoceria.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblDoceria.setText("Doceria");
        getContentPane().add(lblDoceria);
        lblDoceria.setBounds(370, 280, 60, 13);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/restaurant_food_hamburger__6614.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10);
        jLabel10.setBounds(50, 190, 64, 70);

        lblLanches.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblLanches.setText("Lanches");
        getContentPane().add(lblLanches);
        lblLanches.setBounds(60, 270, 60, 13);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/32403curryrice_98915.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11);
        jLabel11.setBounds(50, 290, 70, 64);

        lblBrasileira.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblBrasileira.setText("Brasileira");
        getContentPane().add(lblBrasileira);
        lblBrasileira.setBounds(60, 360, 60, 13);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Dish_Pasta_Spaghetti_26373.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12);
        jLabel12.setBounds(480, 190, 70, 60);

        lblItaliana.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblItaliana.setText("Italiana");
        getContentPane().add(lblItaliana);
        lblItaliana.setBounds(490, 270, 60, 13);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Taco_icon-icons.com_68682.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel13);
        jLabel13.setBounds(480, 310, 70, 70);

        lblMexicana.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblMexicana.setText("Mexicana");
        getContentPane().add(lblMexicana);
        lblMexicana.setBounds(490, 380, 60, 13);

        emailC.setText("jLabel14");
        getContentPane().add(emailC);
        emailC.setBounds(420, 70, 0, 10);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Pesquisa por Prato:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(440, 430, 160, 17);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier-1_icon-icons.com_56924.png"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(180, 460, 45, 29);

        txtPesquisarP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarPKeyReleased(evt);
            }
        });
        getContentPane().add(txtPesquisarP);
        txtPesquisarP.setBounds(440, 460, 160, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Critérios Dinâmicos: ");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(250, 410, 150, 15);

        checkBoxMP.setText("Mais Pedidos");
        getContentPane().add(checkBoxMP);
        checkBoxMP.setBounds(210, 440, 120, 21);

        checkBoxPromoções.setText("Promoções");
        getContentPane().add(checkBoxPromoções);
        checkBoxPromoções.setBounds(210, 470, 110, 21);

        checkBoxGrátis.setText("Entrega Grátis");
        checkBoxGrátis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxGrátisActionPerformed(evt);
            }
        });
        getContentPane().add(checkBoxGrátis);
        checkBoxGrátis.setBounds(330, 440, 110, 21);

        checkBoxPopular.setText("Populares");
        checkBoxPopular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxPopularActionPerformed(evt);
            }
        });
        getContentPane().add(checkBoxPopular);
        checkBoxPopular.setBounds(330, 470, 110, 21);

        jMenu1.setText("Opções");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/diskette_save_saveas_1514.png"))); // NOI18N
        jMenuItem3.setText("Editar Informações");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setText("Encerrar Sessão");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Meus Pedidos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu10.setText("Sair");
        jMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu10ActionPerformed(evt);
            }
        });

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Encerrar Sessão");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem4);

        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(676, 782));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu10ActionPerformed
        // TODO add your handling code here:
        //caixa de dialogo para SAIR
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
    }//GEN-LAST:event_jMenu10ActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        // TODO add your handling code here:
        //evento de pesquisar em tempo real enquanto digita
        pesquisarRestaurante();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        btnPrint.setText(formatador.format(data));
        
        
        pesquisarRestaurante();
    }//GEN-LAST:event_formWindowActivated

    private void tblPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesquisarMouseClicked
        // TODO add your handling code here:
        int setar = tblPesquisar.getSelectedRow();
        TelaCardápio telaCardapio = new TelaCardápio(clienteLogado);
        
        TelaCardápio.lblNomeCardapio.setText(tblPesquisar.getModel().getValueAt(setar, 1).toString());
        telaCardapio.setVisible(true);
    }//GEN-LAST:event_tblPesquisarMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        String sql = "SELECT IdR,Nome,Categoria,Situação,Frete"
                + " FROM tbl_restaurante"
                + " WHERE Categoria"
                + " LIKE ?";
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string

            pstmt.setString(1, lblJaponesa.getText());
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        String sql = "SELECT IdR,Nome,Categoria,Situação,Frete"
                + " FROM tbl_restaurante"
                + " WHERE Categoria"
                + " LIKE ?";
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string

            pstmt.setString(1, lblChinesa.getText());
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        String sql = "SELECT IdR,Nome,Categoria,Situação,Frete"
                + " FROM tbl_restaurante"
                + " WHERE Categoria"
                + " LIKE ?";
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string

            pstmt.setString(1, lblPizzas.getText());
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        String sql = "SELECT IdR,Nome,Categoria,Situação,Frete"
                + " FROM tbl_restaurante"
                + " WHERE Categoria"
                + " LIKE ?";
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string

            pstmt.setString(1, lblDoceria.getText());
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        String sql = "SELECT IdR,Nome,Categoria,Situação,Frete"
                + " FROM tbl_restaurante"
                + " WHERE Categoria"
                + " LIKE ?";
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string

            pstmt.setString(1, lblLanches.getText());
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        String sql = "SELECT IdR,Nome,Categoria,Situação,Frete"
                + " FROM tbl_restaurante"
                + " WHERE Categoria"
                + " LIKE ?";
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string

            pstmt.setString(1, lblBrasileira.getText());
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        String sql = "SELECT IdR,Nome,Categoria,Situação,Frete"
                + " FROM tbl_restaurante"
                + " WHERE Categoria"
                + " LIKE ?";
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string

            pstmt.setString(1, lblItaliana.getText());
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        String sql = "SELECT IdR,Nome,Categoria,Situação,Frete"
                + " FROM tbl_restaurante"
                + " WHERE Categoria"
                + " LIKE ?";
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string

            pstmt.setString(1, lblMexicana.getText());
            resultset = pstmt.executeQuery();
            
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            tblPesquisar.setModel(DbUtils.resultSetToTableModel(resultset));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
        // TODO add your handling code here:
        TelaPerfilCliente telaperfil = new TelaPerfilCliente(clienteLogado);
        telaperfil.setVisible(true);
    }//GEN-LAST:event_jMenuItem3MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        TelaPerfilCliente telaperfil = new TelaPerfilCliente(clienteLogado);
        telaperfil.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        TelaLoguin telaloguin = new TelaLoguin();
        dispose();
        telaloguin.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
        // TODO add your handling code here:
        TelaLoguin telaloguin = new TelaLoguin();
        dispose();
        telaloguin.setVisible(true);
    }//GEN-LAST:event_jMenuItem5MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TelaPedidosCliente telapedidos = new TelaPedidosCliente(clienteLogado);
        telapedidos.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtPesquisarPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarPKeyReleased
        // TODO add your handling code here:
        pesquisarPrato();
    }//GEN-LAST:event_txtPesquisarPKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        

  

    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        String sql = "SELECT *"
                + " FROM tbl_cliente"
                + " WHERE id_cliente"
                + " LIKE ?";
        
        try{
            ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
            conexaoSQlite.conectar();
            PreparedStatement pstmt = conexaoSQlite.criarPreparedStatement(sql);
            ResultSet resultset = null;
            //passando o conteudo da caixa de pesquisa para o ? da string
            //atenção ao % que é a continuacao da string
            //pstmt.setString(1, txtPesquisarP.getText() + "%");
            pstmt.setInt(1, clienteLogado.getId());
            resultset = pstmt.executeQuery();
            //faz o preenchimento da tabela com o resultado 'ResultSet'
            lblNomeC.setText(resultset.getString(3));
            
            pstmt.close();
            conexaoSQlite.desconectar();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void checkBoxGrátisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxGrátisActionPerformed
        // TODO add your handling code here:
        
        pesquisarFrete();
    }//GEN-LAST:event_checkBoxGrátisActionPerformed

    private void checkBoxPopularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxPopularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxPopularActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicialCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel btnPrint;
    private javax.swing.JCheckBox checkBoxGrátis;
    private javax.swing.JCheckBox checkBoxMP;
    private javax.swing.JCheckBox checkBoxPopular;
    private javax.swing.JCheckBox checkBoxPromoções;
    public static javax.swing.JLabel emailC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrasileira;
    private javax.swing.JLabel lblChinesa;
    private javax.swing.JLabel lblDoceria;
    private javax.swing.JLabel lblItaliana;
    private javax.swing.JLabel lblJaponesa;
    private javax.swing.JLabel lblLanches;
    private javax.swing.JLabel lblMexicana;
    public static javax.swing.JLabel lblNomeC;
    private javax.swing.JLabel lblPizzas;
    public static javax.swing.JTable tblPesquisar;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtPesquisarP;
    // End of variables declaration//GEN-END:variables
}
