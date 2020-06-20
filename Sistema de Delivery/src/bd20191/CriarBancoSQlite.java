/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd20191;

import java.sql.Connection;
import conexoes.ConexaoSQlite;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 *
 * @author Luiz Cardoso
 */
public class CriarBancoSQlite {

    private final ConexaoSQlite conexaoSQlite; // como é final tem que instanciar no construtor da classe

    public CriarBancoSQlite(ConexaoSQlite pconexaoSQlite) {
        this.conexaoSQlite = pconexaoSQlite;
    }

    public void criarTabelaCliente() {

        //string para criar tabela cliente
        String sql = "CREATE TABLE IF NOT EXISTS tbl_cliente"
                + "("
                + "id_cliente integer PRIMARY KEY AUTOINCREMENT,"
                + "email text NOT NULL,"
                + "nome text NOT NULL,"
                + "senha text NOT NULL,"
                + "endereco text NOT NULL"
                + ");";

        //executar o sql de criar tabela
        //boolean pra ver se conectou de fato
        boolean conectou = false;

        try {
            //tentar conectar, se conectar, cria um statement que é utilizado para executar o sql acima
            conectou = this.conexaoSQlite.conectar();
            //System.out.println(conectou);
            
            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            //System.out.println(stmt);

            System.out.println("tabela cliente criada");

        } catch (SQLException e) {
            //mensagem de erro na criação da tabela

        } finally {
            if (conectou) {
                //so fecha se tiver sido aberta
                this.conexaoSQlite.desconectar();
            }
        }
    }

    public void criarTabelaPedido() {

        String sql1 = "CREATE TABLE IF NOT EXISTS tbl_pedido"
                + "("
                + "id_pedido integer PRIMARY KEY AUTOINCREMENT,"
                + "id_cliente integer NOT NULL,"
                + "data_hora text NOT NULL,"
                + "local_entrega text NOT NULL,"
                + "valor real NOT NULL,"
                + "detalhes text NOT NULL,"
                + "nomeRestaurante text NOT NULL,"
                + "FOREIGN KEY (id_cliente) REFERENCES tbl_cliente(id_cliente)"
                + ");";
        
        
        

        //executar o sql de criar tabela
        //boolean pra ver se conectou de fato
        boolean conectou = false;


        try {
            //tentar conectar, se conectar, cria um statement que é utilizado para executar o sql acima
            conectou = this.conexaoSQlite.conectar();
            //System.out.println(conectou);

           

            Statement stmt = this.conexaoSQlite.criarStatement();

            stmt.execute(sql1);
            
            //System.out.println(stmt);

            System.out.println("tabela pedido criada");

        } catch (SQLException e) {
            //mensagem de erro na criação da tabela
            System.out.println("erro ao criar tabela");

        } finally {
            if (conectou) {
                //so fecha se tiver sido aberta
                this.conexaoSQlite.desconectar();
            }
        }
    }

    public void criarTabelaRestaurante() {

        String sql = "CREATE TABLE IF NOT EXISTS tbl_restaurante"
                + "("
                + "idR integer PRIMARY KEY AUTOINCREMENT,"
                + "emailR text NOT NULL,"
                + "Nome text NOT NULL,"
                + "senhaR text NOT NULL,"
                + "endereçoR text NOT NULL,"
                + "Situação text NOT NULL,"
                + "Categoria text NOT NULL,"
                + "Frete text NOT NULL"
                + ");";

        //executar o sql de criar tabela
        //boolean pra ver se conectou de fato
        boolean conectou = false;

        try {
            //tentar conectar, se conectar, cria um statement que é utilizado para executar o sql acima
            conectou = this.conexaoSQlite.conectar();
            //System.out.println(conectou);

            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            //System.out.println(stmt);

            System.out.println("tabela restaurante criada");

        } catch (SQLException e) {
            //mensagem de erro na criação da tabela
            System.out.println("erro ao criar tabela");

        } finally {
            if (conectou) {
                //so fecha se tiver sido aberta
                this.conexaoSQlite.desconectar();
            }
        }
    }

    public void criarTabelaPrato() {

        String sql = "CREATE TABLE IF NOT EXISTS tbl_prato"
                + "("
                + "idPrato integer PRIMARY KEY AUTOINCREMENT,"
                + "id_rest integer NOT NULL,"
                //+ "id_preco integer,"
                + "Nome text NOT NULL,"
                + "Descrição text NOT NULL,"
                + "nomeRestaurante text NOT NULL,"
                + "Valor real NOT NULL,"
                + "FOREIGN KEY (id_rest) REFERENCES tbl_restaurante(idR)"
                //+ "FOREIGN KEY (id_preco) REFERENCES tbl_preco(id_preco)"
                //+ "FOREIGN KEY (id_cliente) REFERENCES tbl_cliente(id_cliente)"
                + ");";

        //executar o sql de criar tabela
        //boolean pra ver se conectou de fato
        boolean conectou = false;

        try {
            //tentar conectar, se conectar, cria um statement que é utilizado para executar o sql acima
            conectou = this.conexaoSQlite.conectar();
            //System.out.println(conectou);

            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            //System.out.println(stmt);

            System.out.println("tabela prato criada");

        } catch (SQLException e) {
            //mensagem de erro na criação da tabela
            System.out.println("erro ao criar tabela");

        } finally {
            if (conectou) {
                //so fecha se tiver sido aberta
                this.conexaoSQlite.desconectar();
            }
        }
    }

    public void criarTabelaPreço() {

        String sql = "CREATE TABLE IF NOT EXISTS tbl_preco"
                + "("
                + "id_preco integer PRIMARY KEY AUTOINCREMENT,"
                + "id_prato integer NOT NULL,"
                + "data_hora text NOT NULL,"
                + "nomeRestaurante text NOT NULL,"
                + "valor real NOT NULL"
                + ");";

        //executar o sql de criar tabela
        //boolean pra ver se conectou de fato
        boolean conectou = false;

        try {
            //tentar conectar, se conectar, cria um statement que é utilizado para executar o sql acima
            conectou = this.conexaoSQlite.conectar();
            //System.out.println(conectou);

            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            //System.out.println(stmt);

            System.out.println("tabela preço criada");

        } catch (SQLException e) {
            //mensagem de erro na criação da tabela
            System.out.println("erro ao criar tabela");

        } finally {
            if (conectou) {
                //so fecha se tiver sido aberta
                this.conexaoSQlite.desconectar();
            }
        }
    }

    public void criarTabelaCarrinho() {

        String sql = "CREATE TABLE IF NOT EXISTS tbl_carrinho"
                + "("
                + "id_pedido integer PRIMARY KEY,"
                + "id_prato integer,"
                + "quantidade integer NOT NULL,"
                + "nomeCliente text NOT NULL,"
                + "FOREIGN KEY (id_pedido) REFERENCES tbl_pedido(id_pedido),"
                + "FOREIGN KEY (id_prato) REFERENCES tbl_prato(idPrato)"
                + ");";

        //executar o sql de criar tabela
        //boolean pra ver se conectou de fato
        boolean conectou = false;

        try {
            //tentar conectar, se conectar, cria um statement que é utilizado para executar o sql acima
            conectou = this.conexaoSQlite.conectar();
            //System.out.println(conectou);

            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            //System.out.println(stmt);

            System.out.println("tabela carirnho criada");

        } catch (SQLException e) {
            //mensagem de erro na criação da tabela
            System.out.println("erro ao criar tabela");

        } finally {
            if (conectou) {
                //so fecha se tiver sido aberta
                this.conexaoSQlite.desconectar();
            }
        }
    }

}
