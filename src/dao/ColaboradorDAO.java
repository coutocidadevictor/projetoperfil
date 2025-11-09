package dao;

import db.Conexao;
import models.Colaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {
    private Conexao conexao;

    public ColaboradorDAO() {
        this.conexao = Conexao.getInstance();
    }

    public void inserir(Colaborador colaborador) throws SQLException {
        // Cria a query
        String sql = "INSERT INTO colaboradores(nomeColaboradores, telefoneColaboradores) VALUES (?, ?)";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setString(1, colaborador.getNome());
            ps.setString(2, colaborador.getTelefone());
            
            // Executa a query
            ps.executeUpdate();
        }
    }

    public List<Colaborador> listarTodos() throws SQLException {
        // Cria a query
        String sql = "SELECT * FROM colaboradores";
        List<Colaborador> colaboradores = new ArrayList<>();
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setIdColaboradores(rs.getInt("IdColaboradores"));
                colaborador.setNome(rs.getString("nomeColaboradores"));
                colaborador.setTelefone(rs.getString("telefoneColaboradores"));
                colaboradores.add(colaborador);
            }
        }
        return colaboradores;
    }

    public void atualizar(Colaborador colaborador) throws SQLException {
        // Cria a query
        String sql = "UPDATE colaboradores SET nomeColaboradores = ?, telefoneColaboradores = ? WHERE IdColaboradores = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setString(1, colaborador.getNome());
            ps.setString(2, colaborador.getTelefone());
            ps.setInt(3, colaborador.getIdColaboradores());
            
            // Executa a query
            ps.executeUpdate();
        }
    }

    public void excluir(int idColaborador) throws SQLException {
        // Cria a query
        String sql = "DELETE FROM colaboradores WHERE IdColaboradores = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setInt(1, idColaborador);
            
            // Executa a query
            ps.executeUpdate();
        }
    }

    public Colaborador buscarPorId(int idColaborador) throws SQLException {
        // Cria a query
        String sql = "SELECT * FROM colaboradores WHERE IdColaboradores = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setInt(1, idColaborador);
            
            // Executa a query
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Colaborador colaborador = new Colaborador();
                    colaborador.setIdColaboradores(rs.getInt("IdColaboradores"));
                    colaborador.setNome(rs.getString("nomeColaboradores"));
                    colaborador.setTelefone(rs.getString("telefoneColaboradores"));
                    return colaborador;
                }
            }
        }
        return null;
    }
}