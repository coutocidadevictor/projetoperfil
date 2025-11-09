package dao;

import db.Conexao;
import models.Servico;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Servico;
import db.Conexao;
import models.Atendimento;
import tabela.Tabela;
import view.TelaServicos;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;

public class AtendimentoDAO {

    public void Cadastrar(Atendimento A) throws SQLException {

        Conexao bd = new Conexao();
        bd.conectar();

        String sqlQuery = "insert into atendimentos(idClientes, idServico, idColaboradores, dataAtendimento) values (?, ?, ?, ?)";
        PreparedStatement cadastro = bd.getConexao().prepareStatement(sqlQuery);

        cadastro.setInt(1, A.getIdClientes());
        cadastro.setInt(2, A.getIdServico());
        cadastro.setInt(3, A.getIdColaboradores());
        cadastro.setString(4, A.getDataAtendimentos());
        cadastro.execute();
        System.out.println(sqlQuery);
    }

    public static ArrayList<Atendimento> listaAtendimentos() throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();

        String query = "select * from atendimentos";
        ArrayList<Atendimento> listaAtendimentos = new ArrayList<>();

        PreparedStatement cadastro = bd.getConexao().prepareStatement(query);
        ResultSet rs = cadastro.executeQuery();

        while (rs.next()) {

            Atendimento atendimento = new Atendimento();
            atendimento.setIdAtendimentos(rs.getInt("Idatendimentos"));
            atendimento.setIdClientes(rs.getInt("IdClientes"));
            atendimento.setIdServico(rs.getInt("IdServico"));
            atendimento.setIdColaboradores(rs.getInt("IdColaboradores"));
            atendimento.setDataAtendimentos(rs.getString("dataAtendimento"));

            listaAtendimentos.add(atendimento);
        }
        return listaAtendimentos;
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
        String query = "delete servicos where id = " + B.getIdServico();
        PreparedStatement consulta = bd.getConexao().
                prepareStatement(query);
        try {
            consulta.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(query);
            e.getMessage();
        }

    }

}
