package models;

public class Cliente {

    private int IdClientes;
    private String nome;
    private String telefone;

    public Cliente() {
    }

    public Cliente(int IdClientes, String nomeClientes, String telefoneClientes) {
        this.IdClientes = IdClientes;
        this.nome = nomeClientes;
        this.telefone = telefoneClientes;
    }

    public int getIdClientes() {
        return IdClientes;
    }

    public void setIdClientes(int IdClientes) {
        this.IdClientes = IdClientes;
    }

    public String getNomeClientes() {
        return nome;
    }

    public void setNomeClientes(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String clientes) {
        this.telefone = clientes;
    }

    public String toString() {
        return nome;
    }
}
