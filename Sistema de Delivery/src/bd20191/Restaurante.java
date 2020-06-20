/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd20191;

/**
 *
 * @author Luiz Cardoso
 */
public class Restaurante {
    
    private int id;
    private String nome;
    private String senha;
    private String email;
    private String endereco;
    private String tipo_frete;
    private String situaçao;
    private String categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo_frete() {
        return tipo_frete;
    }

    public void setTipo_frete(String tipo_frete) {
        this.tipo_frete = tipo_frete;
    }

    public String getSituaçao() {
        return situaçao;
    }

    public void setSituaçao(String situaçao) {
        this.situaçao = situaçao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
