package models;

public class Atendimento {

    private int IdAtendimentos;
    private int idClientes;
    private int idServico;
    private int idColaboradores;
    private String dataAtendimentos;

    public Atendimento() {
    }

    public Atendimento(int IdAtendimentos, int idClientes, int idServico, int idColaboradores, String dataAtendimentos) {
        this.IdAtendimentos = IdAtendimentos;
        this.idClientes = idClientes;
        this.idServico = idServico;
        this.idColaboradores = idColaboradores;
        this.dataAtendimentos = dataAtendimentos;
    }

    public int getIdAtendimentos() {
        return IdAtendimentos;
    }

    public void setIdAtendimentos(int IdAtendimentos) {
        this.IdAtendimentos = IdAtendimentos;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getIdColaboradores() {
        return idColaboradores;
    }

    public void setIdColaboradores(int idColaboradores) {
        this.idColaboradores = idColaboradores;
    }

    public String getDataAtendimentos() {
        return dataAtendimentos;
    }

    public void setDataAtendimentos(String dataAtendimentos) {
        this.dataAtendimentos = dataAtendimentos;
    }

}
