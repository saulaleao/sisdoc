package br.edu.ifrs.poa.inf.aula.sisdoc;

/**
 * Created by 0291048 on 05/07/2017.
 */

public class Comunidade {
    private int _id;
    private String nome;
    private String matricula;
    private String senha;

    public Comunidade(){}

    public Comunidade(int _id, String nome, String matricula, String senha) {
        this._id = _id;
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
