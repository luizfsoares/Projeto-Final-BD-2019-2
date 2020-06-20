/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd20191;

import Interface.TelaCadastroCliente;
import static Interface.TelaEditCardápio.tblEditPratos;
import static Interface.TelaInicialCliente.emailC;
import Interface.TelaLoguin;
import conexoes.ConexaoSQlite;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.DropMode.ON;
import javax.swing.JOptionPane;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

/**
 *
 * @author bruno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        CriarBancoSQlite meuBanco = new CriarBancoSQlite(conexaoSQlite);

        meuBanco.criarTabelaCliente();
        meuBanco.criarTabelaRestaurante();
        meuBanco.criarTabelaPreço();
        meuBanco.criarTabelaPrato();
        meuBanco.criarTabelaPedido();
        meuBanco.criarTabelaCarrinho();

        TelaLoguin telaloguin = new TelaLoguin();
        telaloguin.setVisible(true);
        conexaoSQlite.desconectar();
        

        

    }
}
