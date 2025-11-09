package DAO;

import BD.Conexao;
import Beans.CadastroServicosBeans;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import Beans.CadastroServicosBeans;
import BD.Conexao;
import Tabela.Tabela;
import View.Servicos;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;

public class CadastroServicosDAO {

    public void Cadastrar(CadastroServicosBeans S) throws SQLException {

        Conexao bd = new Conexao();
        bd.conectar();

        String sqlQuery = "insert into servicos(nome, valor) values (?, ?)";
        PreparedStatement cadastro = bd.getConexao().prepareStatement(sqlQuery);

        cadastro.setString(1, S.getNome());
        cadastro.setString(2, S.getValor());
        cadastro.execute();
        System.out.println(sqlQuery);
    }

    public static ArrayList<CadastroServicosBeans> listaServicos() throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();

        String query = "select * from servicos";
        ArrayList<CadastroServicosBeans> listaServicos = new ArrayList<>();

        PreparedStatement cadastro = bd.getConexao().prepareStatement(query);
        ResultSet rs = cadastro.executeQuery();

        while (rs.next()) {

            CadastroServicosBeans servico = new CadastroServicosBeans();
            servico.setIdServico(rs.getInt("IdServico"));
            servico.setNome(rs.getString("nome"));
            servico.setValor(rs.getString("valor"));
            listaServicos.add(servico);
        }
        return listaServicos;
    }

    public void alterar(CadastroServicosBeans B) throws SQLException {
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

    public void excluir(CadastroServicosBeans B) throws SQLException {
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
