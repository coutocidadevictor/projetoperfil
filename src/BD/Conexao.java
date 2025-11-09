package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection conexao; //atributo

    public void conectar() {
        try {
            System.out.println("Iniciando conexão ao banco de dados...!");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Perfil_V2", "root", "admin");//string de conexao
            System.out.println("SUCESSO DE CONEXAO");
        } catch (SQLException ex) {
            System.out.println("FALHA: Nao conseguiu conectar !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("FALHA: Nao encontrou a classe de conexao");
        }
    }

    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Desconectado com Sucesso");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar" + ex.getMessage());
        }
    }

    public Connection getConexao() {
        return conexao;

    }
}
