package models;

public class Colaborador {

    int IdColaboradores;
    String nomeColaboradores, telefoneColaboradores;
    
    public int getIdColaboradores() {
        return IdColaboradores;
    }

    public void setIdColaboradores(int IdColaboradores) {
        this.IdColaboradores = IdColaboradores;
    }

    public void setIdColaboradores(String IdColaboradores) {
        this.IdColaboradores = Integer.parseInt(IdColaboradores);
    }
    
    public String getNomeColaboradores() {
        return nomeColaboradores;
    }

    public void setNomeColaboradores(String nomeColaboradores) {
        this.nomeColaboradores = nomeColaboradores;
    }

    public String getTelefoneColaboradores() {
        return telefoneColaboradores;
    }

    public void setTelefoneColaboradores(String telefoneColaboradores) {
        this.telefoneColaboradores = telefoneColaboradores;
    }


    public Colaborador(int IdColaboradores, String nomeColaboradores, String valor) {
        this.IdColaboradores = IdColaboradores;
        this.nomeColaboradores = nomeColaboradores;
        this.telefoneColaboradores = telefoneColaboradores;
    }

    public Colaborador() {
    }

    public String toString(){
        return nomeColaboradores;
    }
}
