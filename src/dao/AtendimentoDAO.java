package dao;

import db.Conexao;
import models.Servico;
import models.Atendimento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDAO {

    private Conexao conexao;

    public AtendimentoDAO() {
        this.conexao = Conexao.getInstance();
    }

    public void inserir(Atendimento A) throws SQLException {
        // Cria a query
        String sql = "INSERT INTO atendimentos(idClientes, idServico, idColaboradores, dataAtendimento) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Substitui valores na query
            ps.setInt(1, A.getIdClientes());
            ps.setInt(2, A.getIdServico());
            ps.setInt(3, A.getIdColaboradores());
            ps.setString(4, A.getDataAtendimentos());

            // Executa a query
            ps.executeUpdate();
        }
    }

    public List<Atendimento> listarTodos() throws SQLException {
        // Cria a query
        String sql = "SELECT * FROM atendimentos";
        List<Atendimento> atendimentos = new ArrayList<>();

        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {
            
            // Preenche a lista de resultados
            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setIdAtendimentos(rs.getInt("Idatendimentos"));
                atendimento.setIdClientes(rs.getInt("IdClientes"));
                atendimento.setIdServico(rs.getInt("IdServico"));
                atendimento.setIdColaboradores(rs.getInt("IdColaboradores"));
                atendimento.setDataAtendimentos(rs.getString("dataAtendimento"));
                atendimentos.add(atendimento);
            }
        }
        
        // Retorna lista
        return atendimentos;
    }

    public void atualizar(Atendimento atendimento) throws SQLException {
        // Cria a query
        String sql = "UPDATE atendimentos SET idClientes = ?, idServico = ?, idColaboradores = ?, dataAtendimento = ? WHERE Idatendimentos = ?";
            
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setInt(1, atendimento.getIdClientes());
            ps.setInt(2, atendimento.getIdServico());
            ps.setInt(3, atendimento.getIdColaboradores());
            ps.setString(4, atendimento.getDataAtendimentos());
            ps.setInt(5, atendimento.getIdAtendimentos());
            
            // Executa a query
            ps.executeUpdate();
        }
    }

    public void excluir(int idAtendimento) throws SQLException {
        // Cria a query
        String sql = "DELETE FROM atendimentos WHERE Idatendimentos = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setInt(1, idAtendimento);
            
            // Executa a query
            ps.executeUpdate();
        }
    }
    
    public Atendimento buscarPorId(int idAtendimento) throws SQLException {
        // Cria a query
        String sql = "SELECT * FROM atendimentos WHERE Idatendimentos = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            stmt.setInt(1, idAtendimento);
            
            // Executa a query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Atendimento atendimento = new Atendimento();
                    atendimento.setIdAtendimentos(rs.getInt("Idatendimentos"));
                    atendimento.setIdClientes(rs.getInt("IdClientes"));
                    atendimento.setIdServico(rs.getInt("IdServico"));
                    atendimento.setIdColaboradores(rs.getInt("IdColaboradores"));
                    atendimento.setDataAtendimentos(rs.getString("dataAtendimento"));
                    return atendimento;
                }
            }
        }
        
        return null;
    }
    

}
