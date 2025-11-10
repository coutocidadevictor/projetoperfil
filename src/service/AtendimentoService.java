/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import dao.AtendimentoDAO;
import dao.ClienteDAO;
import dao.ColaboradorDAO;
import dao.ServicoDAO;
import models.Atendimento;
import models.Cliente;
import models.Colaborador;
import models.Servico;
import java.sql.SQLException;
import java.util.List;

public class AtendimentoService {
    private AtendimentoDAO atendimentoDAO;
    private ClienteDAO clienteDAO;
    private ServicoDAO servicoDAO;
    private ColaboradorDAO colaboradorDAO;
    
    public AtendimentoService() {
        this.atendimentoDAO = new AtendimentoDAO();
        this.clienteDAO = new ClienteDAO();
        this.servicoDAO = new ServicoDAO();
        this.colaboradorDAO = new ColaboradorDAO();
    }
    
    public void salvarAtendimento(Atendimento atendimento) throws SQLException {
        validarAtendimento(atendimento);
        
        if (atendimento.getIdAtendimentos() == 0) {
            atendimentoDAO.inserir(atendimento);
        } else {
            atendimentoDAO.atualizar(atendimento);
        }
    }
    
    public void excluirAtendimento(int idAtendimento) throws SQLException {
        atendimentoDAO.excluir(idAtendimento);
    }
    
    public List<Atendimento> listarTodosAtendimentos() throws SQLException {
        return atendimentoDAO.listarTodos();
    }
    
    public Atendimento buscarAtendimentoPorId(int idAtendimento) throws SQLException {
        return atendimentoDAO.buscarPorId(idAtendimento);
    }
    
    // Métodos para carregar combos
    public List<Cliente> listarTodosClientes() throws SQLException {
        return clienteDAO.listarTodos();
    }
    
    public List<Servico> listarTodosServicos() throws SQLException {
        return servicoDAO.listarTodos();
    }
    
    public List<Colaborador> listarTodosColaboradores() throws SQLException {
        return colaboradorDAO.listarTodos();
    }
    
    private void validarAtendimento(Atendimento atendimento) {
        if (atendimento.getIdClientes() == 0) {
            throw new IllegalArgumentException("Cliente é obrigatório");
        }
        if (atendimento.getIdServico() == 0) {
            throw new IllegalArgumentException("Serviço é obrigatório");
        }
        if (atendimento.getIdColaboradores() == 0) {
            throw new IllegalArgumentException("Colaborador é obrigatório");
        }
        if (atendimento.getDataAtendimentos() == null || atendimento.getDataAtendimentos().trim().isEmpty()) {
            throw new IllegalArgumentException("Data do atendimento é obrigatória");
        }
    }
}