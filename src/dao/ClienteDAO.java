package dao;

import db.Conexao;
import models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Conexao conexao;

    public ClienteDAO() {
        this.conexao = Conexao.getInstance();
    }

    public void inserir(Cliente cliente) throws SQLException {
        // Cria a query
        String sql = "INSERT INTO clientes (nomeClientes, telefoneClientes) VALUES (?, ?)";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setString(1, cliente.getNomeClientes());
            ps.setString(2, cliente.getTelefone());
            
            // Executa a query
            ps.executeUpdate();
        }
    }

    public List<Cliente> listarTodos() throws SQLException {
        // Cria a query
        String sql = "SELECT * FROM clientes";
        List<Cliente> clientes = new ArrayList<>();
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdClientes(rs.getInt("IdClientes"));
                cliente.setNomeClientes(rs.getString("nomeClientes"));
                cliente.setTelefone(rs.getString("telefoneClientes"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void atualizar(Cliente cliente) throws SQLException {
        // Cria a query
        String sql = "UPDATE clientes SET nomeClientes = ?, telefoneClientes = ? WHERE IdClientes = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setString(1, cliente.getNomeClientes());
            ps.setString(2, cliente.getTelefone());
            ps.setInt(3, cliente.getIdClientes());
            
            // Executa a query
            ps.executeUpdate();
        }
    }

    public void excluir(int idCliente) throws SQLException {
        // Cria a query
        String sql = "DELETE FROM clientes WHERE IdClientes = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setInt(1, idCliente);
            
            // Executa a query
            ps.executeUpdate();
        }
    }

    public Cliente buscarPorId(int idCliente) throws SQLException {
        // Cria a query
        String sql = "SELECT * FROM clientes WHERE IdClientes = ?";
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setInt(1, idCliente);
            
            // Executa a query
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdClientes(rs.getInt("IdClientes"));
                    cliente.setNomeClientes(rs.getString("nomeClientes"));
                    cliente.setTelefone(rs.getString("telefoneClientes"));
                    return cliente;
                }
            }
        }
        return null;
    }

    public List<Cliente> buscarPorNome(String nome) throws SQLException {
        // Cria a query
        String sql = "SELECT * FROM clientes WHERE nomeClientes LIKE ?";
        List<Cliente> clientes = new ArrayList<>();
        
        try (Connection conn = conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Substitui valores na query
            ps.setString(1, "%" + nome + "%");
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdClientes(rs.getInt("IdClientes"));
                    cliente.setNomeClientes(rs.getString("nomeClientes"));
                    cliente.setTelefone(rs.getString("telefoneClientes"));
                    clientes.add(cliente);
                }
            }
        }
        return clientes;
    }
}
