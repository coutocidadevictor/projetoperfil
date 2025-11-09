package models;

public class Colaborador {

    private int IdColaboradores;
    private String nome;
    private String telefone;

    public Colaborador() {
    }

    public Colaborador(int IdColaboradores, String nome, String telefone) {
        this.IdColaboradores = IdColaboradores;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getIdColaboradores() {
        return IdColaboradores;
    }

    public void setIdColaboradores(int IdColaboradores) {
        this.IdColaboradores = IdColaboradores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return nome;
    }
}
