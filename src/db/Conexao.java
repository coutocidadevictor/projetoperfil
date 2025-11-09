package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Conexao instance;
    private Connection conexao;
    
    // Configurações do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/Perfil_V2";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    
    // Construtor privado para impedir instanciação externa
    private Conexao() {
    }
    
    // Método estático para obter a instância única
    public static Conexao getInstance() {
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }
    
    public Connection getConexao() throws SQLException {
        // Se a conexão não existe ou está fechada, cria uma nova
        if (conexao == null || conexao.isClosed()) {
            conectar();
        }
        return conexao;
    }
    
    private void conectar() throws SQLException {
        try {
            // Realiza conexão
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com banco de dados estabelecida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Não é possível conectar ao banco de dados!");
            System.err.println("Erro: " + e.getMessage());
            throw e; // Lança a exceção
        }
    }
    
    public void desconectar() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão com banco de dados finalizada com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            } finally {
                conexao = null;
            }
        }
    }
    
    // Método para testar a conexão
    public boolean testarConexao() {
        try {
            Connection conn = getConexao();
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}
