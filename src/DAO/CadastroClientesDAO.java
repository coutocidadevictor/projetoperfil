package DAO;

import BD.Conexao;
import Beans.CadastroServicosBeans;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import BD.Conexao;
import Beans.CadastroClientesBeans;
import Tabela.Tabela;
import View.Clientes;
import java.sql.SQLDataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;

public class CadastroClientesDAO {

    public void Cadastrar(CadastroClientesBeans S) throws SQLException {

        Conexao bd = new Conexao();
        bd.conectar();

        String sqlQuery = "insert into clientes (nomeClientes, telefoneClientes) values (?, ?)";
        PreparedStatement cadastro = bd.getConexao().prepareStatement(sqlQuery);

        cadastro.setString(1, S.getNomeClientes());
        cadastro.setString(2, S.getTelefoneClientes());
        cadastro.execute();
        System.out.println(sqlQuery);
    }

    public static ArrayList<CadastroClientesBeans> listaClientes() throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();

        String query = "select * from clientes";
        {
            ArrayList<CadastroClientesBeans> listaClientes;

            PreparedStatement cadastro = bd.getConexao().prepareStatement(query);
            ResultSet rs = cadastro.executeQuery();
            listaClientes = new ArrayList<>();

            while (rs.next()) {
            CadastroClientesBeans cliente = new CadastroClientesBeans();
            cliente.setIdClientes(rs.getInt("IdClientes"));
            cliente.setNomeClientes(rs.getString("nomeClientes"));
            cliente.setTelefoneClientes(rs.getString("telefoneClientes"));
            listaClientes.add(cliente);
            }
           return listaClientes;
        }

    }

    public static Tabela obterTabela() throws SQLException{
                Conexao bd = new Conexao();
        bd.conectar();

        ArrayList dados = new ArrayList<>();
        String[] colunas = new String[]{"IdClientes", "nomeClientes", "telefoneClientes"};
        String query = "select * from clientes";
        {

            PreparedStatement cadastro = bd.getConexao().prepareStatement(query);
            ResultSet rs = cadastro.executeQuery();

            while (rs.next()) {
                dados.add(new Object[]{
                    rs.getString("IdClientes"),
                    rs.getString("nomeClientes"),
                    rs.getString("telefoneClientes")});
            }
            Tabela modelo = new Tabela(dados, colunas);
            return modelo;
        }
        
        
    }
    
    
    
    public void alterar(CadastroClientesBeans B) throws SQLException {
        Conexao bd = new Conexao();
        bd.conectar();
        String query = "update clientes set nomeClientes = '" + 
                        B.getNomeClientes()+ "', telefoneClientes = '" +    
                        B.getTelefoneClientes()+ "' where IdClientes = " + 
                        B.getIdClientes();
        PreparedStatement consulta = bd.getConexao().prepareStatement(query);
        try {
            consulta.executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(query);
            e.getMessage();
        }
       
    }

    public void excluir(CadastroClientesBeans B) throws SQLException {
                System.out.println(B.getIdClientes());
        Conexao bd = new Conexao();
        bd.conectar();
        String query = "delete from clientes where IdClientes = ?";
        PreparedStatement consulta = bd.getConexao().
                prepareStatement(query);
                
        consulta.setInt(1, B.getIdClientes());
        
        try {
            consulta.executeUpdate();
        } catch (SQLException e) {
            System.out.println(query);
            e.printStackTrace();
            e.getMessage();
        }
        
        
    }

    public void BuscaNome(CadastroClientesBeans B) {

        Conexao bd = new Conexao();
        bd.conectar();

        String sqlQuery = "SELECT * FROM clientes WHERE NOME LIKE  '%" + B.getNomeClientes();
        try ( PreparedStatement consulta = bd.getConexao().prepareStatement(sqlQuery)) {
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                if (rs != null) {
                    Clientes.jtfCodigoClientes.setText(String.valueOf(rs.getString("IdClientes")));
                }
                Clientes.jtfNomeClientes.setText(String.valueOf(rs.getString("nomeClientes")));
                Clientes.jtfTelefoneClientes.setText(String.valueOf(rs.getString("telefoneCLientes")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroClientesBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public void clicarTabela() {
    Conexao bd = new Conexao();
    bd.conectar();

    int linha = Clientes.tabelaPrincipalClientes.getSelectedRow();
    if (linha < 0) {
        return; // nenhuma linha selecionada
    }

    // pega o ID da tabela (coluna 0)
    String ID = Clientes.tabelaPrincipalClientes.getModel().getValueAt(linha, 0).toString();

    String sqlQuery = "SELECT * FROM clientes WHERE idClientes = ?";

    try (PreparedStatement consulta = bd.getConexao().prepareStatement(sqlQuery)) {
        consulta.setInt(1, Integer.parseInt(ID));
        ResultSet rs = consulta.executeQuery();

        if (rs.next()) {
            Clientes.jtfCodigoClientes.setText(String.valueOf(rs.getInt("IdClientes")));
            Clientes.jtfNomeClientes.setText(rs.getString("nomeClientes"));
            Clientes.jtfTelefoneClientes.setText(rs.getString("telefoneClientes"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(CadastroClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}
