package Beans;

public class CadastroClientesBeans {

    int IdClientes;
    String nomeClientes, telefoneClientes;

    public CadastroClientesBeans(int IdClientes, String nomeClientes, String telefoneClientes) {
        this.IdClientes = IdClientes;
        this.nomeClientes = nomeClientes;
        this.telefoneClientes = telefoneClientes;
    }

    public int getIdClientes() {
        return IdClientes;
    }

    public void setIdClientes(int IdClientes) {
        this.IdClientes = IdClientes;
    }

    public String getNomeClientes() {
        return nomeClientes;
    }

    public void setNomeClientes(String nomeClientes) {
        this.nomeClientes = nomeClientes;
    }

    public String getTelefoneClientes() {
        return telefoneClientes;
    }

    public void setTelefoneClientes(String telefoneClientes) {
        this.telefoneClientes = telefoneClientes;
    }
   
    public CadastroClientesBeans() {
    }

    public String toString(){
        return nomeClientes;
    }
}
