package br.edu.ifrs.poa.inf.aula.sisdoc;

/**
 * Created by 0291048 on 05/07/2017.
 */

public class Servidor {
    private int _id;
    private String nome;
    private String torre;
    private String sala;
    private String horario;

    public Servidor(){}

    public Servidor(String nome, String torre, String sala, String horario) {
        this(0, nome, torre, sala, horario);
    }

    public Servidor(int _id, String nome, String torre, String sala, String horario) {
        this._id = _id;
        this.nome = nome;
        this.torre = torre;
        this.sala = sala;
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Servidor{" +
                "_id=" + _id +
                ", nome='" + nome + '\'' +
                ", torre='" + torre + '\'' +
                ", sala='" + sala + '\'' +
                ", horario='" + horario + '\'' +
                '}';
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

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servidor servidor = (Servidor) o;

        return _id == servidor._id;

    }

    @Override
    public int hashCode() {
        return _id;
    }

}
