package dao;

import db.Conexao;
import models.Servico;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Servico;
import db.Conexao;
import tabela.Tabela;
import view.TelaServicos;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;

public class ServicoDAO {

    public void Cadastrar(Servico S) throws SQLException {

        Conexao bd = new Conexao();
        bd.conectar();

        String sqlQuery = "insert into servicos(nome, valor) values (?, ?)";
        PreparedStatement cadastro = bd.getConexao().prepareStatement(sqlQuery);

        cadastro.setString(1, S.getNome());
        cadastro.setString(2, S.getValor());
        cadastro.execute();
        System.out.println(sqlQuery);
    }

    public static ArrayList<Servico> listaServicos() throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();

        String query = "select * from servicos";
        ArrayList<Servico> listaServicos = new ArrayList<>();

        PreparedStatement cadastro = bd.getConexao().prepareStatement(query);
        ResultSet rs = cadastro.executeQuery();

        while (rs.next()) {

            Servico servico = new Servico();
            servico.setIdServico(rs.getInt("IdServico"));
            servico.setNome(rs.getString("nome"));
            servico.setValor(rs.getString("valor"));
            listaServicos.add(servico);
        }
        return listaServicos;
    }

    public void alterar(Servico B) throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();
        String query = "update servicos set nome = '" + B.getNome() + "', valor = '" + B.getValor() + "' where IdServico = " + B.getIdServico();
        PreparedStatement consulta = bd.getConexao().prepareStatement(query);
        try {
            consulta.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(query);
            e.getMessage();
        }

    }

    public void excluir(Servico B) throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();
        String query = "DELETE FROM servicos WHERE IdServico = ?";
        PreparedStatement consulta = bd.getConexao().
                prepareStatement(query);
        try {
            consulta.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(query);
            e.getMessage();
        }

    }

            public static Tabela obterTabela() throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();

        ArrayList dados = new ArrayList<>();
        String[] colunas = new String[]{"IdServico", "nome", "valor"};
        String query = "select * from servicos";
        {

            PreparedStatement cadastro = bd.getConexao().prepareStatement(query);
            ResultSet rs = cadastro.executeQuery();
          

            while (rs.next()) {
                dados.add(new Object[]{
                    rs.getString("IdServico"),
                    rs.getString("nome"),
                    rs.getString("valor")});
            }
            Tabela modelo = new Tabela(dados, colunas);
            return modelo;
        }

    }
            
}
