package dao;

import db.Conexao;
import models.Servico;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import db.Conexao;
import models.Colaborador;
import tabela.Tabela;
import view.TelaAtendimentos;
import view.TelaColaboradores;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;
import java.util.Vector;

public class ColaboradorDAO {

    Vector<Integer> nomeColaborador = new Vector<Integer>();
    
    
    
    public void Cadastrar(Colaborador S) throws SQLException {

        Conexao bd = new Conexao();
        bd.conectar();

        String sqlQuery = "insert into colaboradores(nomeColaboradores, telefoneColaboradores) values (?, ?)";
        PreparedStatement cadastro = bd.getConexao().prepareStatement(sqlQuery);

        cadastro.setString(1, S.getNomeColaboradores());
        cadastro.setString(2, S.getTelefoneColaboradores());
        cadastro.execute();
        System.out.println(sqlQuery);
    }

    public static ArrayList<Colaborador> listaColaboradores() throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();

        
        String[] colunas = new String[]{"IdColaboradores", "nomeColaboradores", "telefoneColaboradores"};
        String query = "select * from colaboradores";
        {
            ArrayList<Colaborador> listaColaboradores;

            PreparedStatement cadastro = bd.getConexao().prepareStatement(query);
            ResultSet rs = cadastro.executeQuery();
            listaColaboradores = new ArrayList<>();

            while (rs.next()) {
            Colaborador colaborador = new Colaborador();
            colaborador.setIdColaboradores(rs.getInt("IdColaboradores"));
            colaborador.setNomeColaboradores(rs.getString("nomeColaboradores"));
            colaborador.setTelefoneColaboradores(rs.getString("telefoneColaboradores"));
            listaColaboradores.add(colaborador);
            }
            return listaColaboradores;
        }

    }

    
        public static Tabela obterTabela() throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();

        ArrayList dados = new ArrayList<>();
        String[] colunas = new String[]{"IdColaboradores", "nomeColaboradores", "telefoneColaboradores"};
        String query = "select * from colaboradores";
        {

            PreparedStatement cadastro = bd.getConexao().prepareStatement(query);
            ResultSet rs = cadastro.executeQuery();
          

            while (rs.next()) {
                dados.add(new Object[]{
                    rs.getString("IdColaboradores"),
                    rs.getString("nomeColaboradores"),
                    rs.getString("telefoneColaboradores")});
            }
            Tabela modelo = new Tabela(dados, colunas);
            return modelo;
        }

    }
        
        
    public void alterar(Colaborador B) throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();
        String query = "update colaboradores set nomeColaboradores = '" + 
                B.getNomeColaboradores()+ "', telefoneColaboradores = '" + 
                B.getTelefoneColaboradores()+ "' where IdColaboradores = " + 
                B.getIdColaboradores();
        PreparedStatement consulta = bd.getConexao().prepareStatement(query);
        try {
            consulta.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(query);
            e.getMessage();
        }

    }

    public void excluir(Colaborador B) throws SQLException {
        System.out.println(B.getIdColaboradores());
        Conexao bd = new Conexao();
        bd.conectar();
        String query = "delete from colaboradores where IdColaboradores = ?";
        PreparedStatement consulta = bd.getConexao().
                prepareStatement(query);
                
        consulta.setInt(1, B.getIdColaboradores());
        
        try {
            consulta.executeUpdate();
        } catch (SQLException e) {
            System.out.println(query);
            e.printStackTrace();
            e.getMessage();
        }

    }
    

}
