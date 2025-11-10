/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import dao.ClienteDAO;
import models.Cliente;
import java.sql.SQLException;
import java.util.List;

public class ClienteService {
    private ClienteDAO clienteDAO;
    
    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }
    
    public void salvarCliente(Cliente cliente) throws SQLException {
        // Valida o cliente
        validarCliente(cliente);
        
        // Insere o novo cliente caso seu id seja igual 0
        if (cliente.getIdCliente() == 0) {
            clienteDAO.inserir(cliente);
            
        // Caso contrário, atualiza o cliente
        } else {
            clienteDAO.atualizar(cliente);
        }
    }
    
    public void excluirCliente(int idCliente) throws SQLException {
        clienteDAO.excluir(idCliente);
    }
    
    public List<Cliente> listarTodosClientes() throws SQLException {
        return clienteDAO.listarTodos();
    }
    
    public Cliente buscarClientePorId(int idCliente) throws SQLException {
        return clienteDAO.buscarPorId(idCliente);
    }
    
    private void validarCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }
        
        // Outras validações podem ser adicionadas aqui
    }
}