/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.ClienteService;
import models.Cliente;
import java.sql.SQLException;
import java.util.List;

public class ClienteController {

    private ClienteService clienteService;

    public ClienteController() {
        this.clienteService = new ClienteService();
    }

    public boolean salvar(String nome, String telefone, String id) throws SQLException {
        try {
            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setTelefone(telefone);

            if (id != null && !id.isEmpty()) {
                cliente.setIdCliente(Integer.parseInt(id));
            }

            clienteService.salvarCliente(cliente);
            return true;

        } catch (IllegalArgumentException e) {
            // Poderia logar o erro ou tratar de forma específica
            throw e;
        }
    }

    public boolean excluir(String id) throws SQLException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do cliente é obrigatório para exclusão");
        }

        clienteService.excluirCliente(Integer.parseInt(id));
        return true;
    }

    public List<Cliente> listarTodos() throws SQLException {
        return clienteService.listarTodosClientes();
    }

    public Cliente buscarPorId(String id) throws SQLException {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return clienteService.buscarClientePorId(Integer.parseInt(id));
    }

    public Cliente buscarClienteDaTabela(int idCliente) throws SQLException {
        return clienteService.buscarClientePorId(idCliente);
    }
}
