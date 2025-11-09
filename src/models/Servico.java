package models;

public class Servico {

    int IdServico;
    String nome, valor;

    public Servico(int IdServico, String nome, String valor) {
        this.IdServico = IdServico;
        this.nome = nome;
        this.valor = valor;
    }

    public Servico() {
    }

    public int getIdServico() {
        return IdServico;
    }

    public void setIdServico(int IdServico) {
        this.IdServico = IdServico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public String toString(){
        return nome + " ( " + valor + " ) ";
}

}
