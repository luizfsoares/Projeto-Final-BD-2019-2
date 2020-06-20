/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luiz Cardoso
 */
public class ConexaoSQlite {
    
    private Connection conexao;
    
    //conecta a um banco de dados mas tbm cria o banco se ele nao existir
    public boolean conectar() {

        String url = "jdbc:sqlite:banco_de_dados/banco_sqlite.db"; //string de conexao
        // habilitar chave estrangeira
        String sql2 =  "PRAGMA foreign_keys = ON";
        
        try{
            //criar lugar onde o banco estará
            
            this.conexao = DriverManager.getConnection(url); //criar conexao e jogar no objeto conexao (atributo) Passa a url criada para enontrar o banco
            Statement statement = this.conexao.createStatement();
            statement.execute(sql2);
            System.out.println("conecteeeei");
            
        }catch(SQLException e){
            System.err.println(e.getMessage()); 
            return false;
        }
        
        return true;
    }
    
    public boolean desconectar(){
        
        try{
            //verifica se a conexao está fechada, se nao tiver, fecha.
            if(this.conexao.isClosed() == false){
                this.conexao.close();
                
                System.out.println("desconectouu");
            }
        } catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    //metodo apenas para ficar retornando o statement e poupar trabalho
    // um statement basicamente executa um sql
    public PreparedStatement criarPreparedStatement(String sql){
    PreparedStatement pstmt;
        try{
            pstmt = conexao.prepareStatement(sql);
            return pstmt;
            
        }catch(SQLException e){
            System.out.println("fudeu");
            return null;
        }
    }
    
    public Statement criarStatement(){
    
        try{
            return this.conexao.createStatement();
            
        }catch(SQLException e){
            return null;
        }
    }
    
    //metodo apenas para retornar a conexao
    public Connection getConexao(){
        return this.conexao;
    }
}
