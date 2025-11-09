package dao;

import models.Servico;
import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {
    private Conexao conexao;

    public ServicoDAO() {
        this.conexao = Conexao.getInstance();
    }

    public void inserir(Servico servico) throws SQLException {
        // Cria a query
        String sql = "INSERT INTO servicos(nome, valor) VALUES (?, ?)";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setString(1, servico.getNome());
            ps.setString(2, servico.getValor());
            
            // Executa a query
            ps.executeUpdate();
        }
    }

    public List<Servico> listarTodos() throws SQLException {
        // Cria a query
        String sql = "SELECT * FROM servicos";
        List<Servico> servicos = new ArrayList<>();
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setIdServico(rs.getInt("IdServico"));
                servico.setNome(rs.getString("nome"));
                servico.setValor(rs.getString("valor"));
                servicos.add(servico);
            }
        }
        return servicos;
    }

    public void atualizar(Servico servico) throws SQLException {
        // Cria a query
        String sql = "UPDATE servicos SET nome = ?, valor = ? WHERE IdServico = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setString(1, servico.getNome());
            ps.setString(2, servico.getValor());
            ps.setInt(3, servico.getIdServico());
            ps.executeUpdate();
        }
    }

    public void excluir(int idServico) throws SQLException {
        // Cria a query
        String sql = "DELETE FROM servicos WHERE IdServico = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setInt(1, idServico);
            
            // Executa a query
            ps.executeUpdate();
        }
    }

    public Servico buscarPorId(int idServico) throws SQLException {
        // Cria a query
        String sql = "SELECT * FROM servicos WHERE IdServico = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setInt(1, idServico);
            
            // Executa a query
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Servico servico = new Servico();
                    servico.setIdServico(rs.getInt("IdServico"));
                    servico.setNome(rs.getString("nome"));
                    servico.setValor(rs.getString("valor"));
                    return servico;
                }
            }
        }
        return null;
    }
}